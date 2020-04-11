package services;

import bo.AccountDocument;
import bo.AgeAndGenderAggregator;
import bo.GenderAggregator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import play.libs.Json;
import play.mvc.BodyParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class AccountServiceImpl implements AccountService {

    private final String INDEX_NAME = "es-demo";
    private final String DOC_TYPE = "account";
    private final String DOCS_LIMIT = "100";
    private final String AGE = "25";

    private final RestClientBuilder clientBuilder = RestClient.builder(new HttpHost("localhost", 9200));
    private final RestHighLevelClient highLevelClient = new RestHighLevelClient(
            clientBuilder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder)
    );

    @Inject
    public AccountServiceImpl() {
    }

    @Override
    public JsonNode getAllAccounts() throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(queryBuilder).size(Integer.parseInt(DOCS_LIMIT));
        SearchRequest request = new SearchRequest(INDEX_NAME).types(DOC_TYPE).source(sourceBuilder);
        SearchResponse result = highLevelClient.search(request, RequestOptions.DEFAULT);
        return Json.toJson(responseParser(result));
    }

    @Override
    public JsonNode getOneAccountByAccountNo(String accountNumber) throws IOException {
        ObjectNode message = Json.newObject();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("account_number", Integer.parseInt(accountNumber));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(queryBuilder);
        SearchRequest request = new SearchRequest(INDEX_NAME).types(DOC_TYPE).source(sourceBuilder);
        SearchResponse result = highLevelClient.search(request, RequestOptions.DEFAULT);
        if (responseParser(result).size() == 0) {
            message.put("message", "Account Not Found By ID: " + accountNumber);
            return message;
        }
        return Json.toJson(responseParser(result));
    }

    @Override
    public JsonNode getAccountsByName(String name) throws IOException {
        ObjectNode message = Json.newObject();
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(name, "firstname", "lastname");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(queryBuilder);
        SearchRequest request = new SearchRequest(INDEX_NAME).source(sourceBuilder);
        SearchResponse result = highLevelClient.search(request, RequestOptions.DEFAULT);
        if (responseParser(result).size() == 0) {
            message.put("message", "No Accounts By Name: " + name);
            return message;
        }
        return Json.toJson(responseParser(result));
    }

    @Override
    public JsonNode getAccountByAgeRange(String age) throws IOException {
        ObjectNode message = Json.newObject();
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().filter(
                QueryBuilders.rangeQuery("age").gte(Integer.parseInt(age))
        );
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(queryBuilder);
        SearchRequest request = new SearchRequest(INDEX_NAME).source(sourceBuilder);
        SearchResponse result = highLevelClient.search(request, RequestOptions.DEFAULT);
        if (responseParser(result).size() == 0) {
            message.put("message", "No Accounts Greater than Age: " + age);
            return message;
        }
        return Json.toJson(responseParser(result));
    }

    @Override
    public JsonNode getAggregationByAgeAndGender() throws IOException {
        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.matchAllQuery())
                .aggregation(
                        AggregationBuilders.terms("AGE_AGGREGATION").field("age")
                                .subAggregation(AggregationBuilders.terms("GENDER_AGGREGATION").field("gender"))
                );
        SearchRequest request = new SearchRequest(INDEX_NAME).types(DOC_TYPE).source(query.from(0).size(0));
        SearchResponse response = highLevelClient.search(request, RequestOptions.DEFAULT);
        return Json.toJson(aggregationParser(response));
    }

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public JsonNode addAccount(JsonNode body) throws IOException {
        ObjectNode result = Json.newObject();
        AccountDocument accountDocument = Json.fromJson(body, AccountDocument.class);
        IndexRequest request = new IndexRequest(INDEX_NAME).type(DOC_TYPE).id(Integer.toString(accountDocument.account_number))
                .source(Json.stringify(Json.toJson(accountDocument)), XContentType.JSON);
        IndexResponse response = highLevelClient.index(request, RequestOptions.DEFAULT);
        if (response.getIndex() != null && response.status() == RestStatus.CREATED) {
            result.put("message", "Account Created By Account No: " + accountDocument.getAccount_number());
        } else {
            result.put("message", "Account Not Created");
        }
        return result;
    }

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public JsonNode deleteAccount(String id) throws IOException {
        ObjectNode result = Json.newObject();
        DeleteRequest request = new DeleteRequest(INDEX_NAME, DOC_TYPE, id);
        JsonNode account = getOneAccountByAccountNo(id);
        if (account.has("message") && account.get("message").asText() != null) {
            result.put("message", account.get("message").asText());
        } else {
            DeleteResponse response = highLevelClient.delete(request, RequestOptions.DEFAULT);
            if (response.getIndex() != null) {
                result.put("message", "Account Deleted by ID: " + id);
            } else {
                result.put("message", "Account Not Found by ID: " + id);
            }
        }
        return result;
    }

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public JsonNode addIndex(JsonNode body) throws IOException {
        ObjectNode result = Json.newObject();
        CreateIndexRequest request = new CreateIndexRequest(body.get("index").asText());

//        Map<String, Object> message = new HashMap<>();
//        message.put("type", "text");
//
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("message", message);
//
//        Map<String, Object> mapping = new HashMap<>();
//        mapping.put("properties", properties);
//        request.mapping(mapping);
//

        request.settings(Settings.builder()
                .put("index.number_of_shards", 5)
                .put("index.number_of_replicas", 1)
        );

        CreateIndexResponse response = highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        if (response.isAcknowledged()) {
            result.put("message", "Index Created: " + response.index());
        } else {
            result.put("message", "Index Not Found");
        }
        return result;
    }

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public JsonNode deleteIndex(String name) throws IOException {
        ObjectNode result = Json.newObject();
        DeleteIndexRequest request = new DeleteIndexRequest(name);
        AcknowledgedResponse response = null;
        try {
            response = highLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                result.put("message", "Index Not Found");
                return result;
            }
        }
        if (response.isAcknowledged()) {
            result.put("message", "Index Deleted: " + name);
        } else {
            result.put("message", "Index Not Found");
        }
        return result;
    }

    private List<AccountDocument> responseParser(SearchResponse searchResponse) {
        List<AccountDocument> results = new ArrayList<>();
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            String sourceAsString = documentFields.getSourceAsString();
            AccountDocument document = Json.fromJson(Json.parse(sourceAsString), AccountDocument.class);
            results.add(document);
        }
        return results;
    }

    private List<AgeAndGenderAggregator> aggregationParser(SearchResponse searchResponse) {
        List<AgeAndGenderAggregator> results = new ArrayList<>();
        MultiBucketsAggregation aggregations = searchResponse.getAggregations().get("AGE_AGGREGATION");
        for (MultiBucketsAggregation.Bucket bucket : aggregations.getBuckets()) {
            String ageKey = bucket.getKey().toString();
            long ageCount = bucket.getDocCount();
            MultiBucketsAggregation internalBuckets = bucket.getAggregations().get("GENDER_AGGREGATION");
            List<GenderAggregator> values = new ArrayList<>();
            for (MultiBucketsAggregation.Bucket internalBucket : internalBuckets.getBuckets()) {
                String genderKey = internalBucket.getKey().toString();
                long genderCount = internalBucket.getDocCount();
                values.add(new GenderAggregator(genderKey, genderCount));
            }
            results.add(new AgeAndGenderAggregator(ageKey, ageCount, values));
        }
        return results;
    }
}
