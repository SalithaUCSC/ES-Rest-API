package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

import java.io.IOException;

@ImplementedBy(AccountServiceImpl.class)
public interface AccountService {

    JsonNode getAllAccounts() throws IOException;

    JsonNode getOneAccountByAccountNo(String accountNumber) throws IOException;

    JsonNode getAccountsByName(String name) throws IOException;

    JsonNode getAccountByAgeRange(String age) throws IOException;

    JsonNode getAggregationByAgeAndGender() throws IOException;

    JsonNode addAccount(JsonNode body) throws IOException;

    JsonNode deleteAccount(String id) throws IOException;

    JsonNode addIndex(JsonNode body) throws IOException;

    JsonNode deleteIndex(String name) throws IOException;

}
