# ES-Rest-API
REST API written to handle documents with Elastic Search using Java Play framework.

## ES REST API Endpoints
```GET      /account/search```

```GET      /account/search/by_account/:accountNumber```

```GET      /account/search/by_name/:name```

```GET      /account/search/by_age/:age```

```GET      /account/search/aggregation```

```POST     /account/create```

```DELETE   /account/delete/:id```

```POST     /index/create```

```DELETE   /index/delete/:name```


## ES Index Structure

> PUT es-demo
```java
{
  "settings": {
    "analysis": {
      "filter": {
        "english_stop": {
          "type": "stop",
          "stopwords": "_english_"
        }
      },
      "analyzer": {
        "custom_english_analyzer": {
          "filter": [
            "lowercase",
            "english_stop"
          ],
          "type": "custom",
          "tokenizer": "standard"
        }
      }
    }
  },
  "mappings": {
    "account": {
      "properties": {
        "account_number": {
          "type": "integer"
        },
        "balance": {
          "type": "integer"
        },
        "firstname": {
          "type": "text",
          "analyzer": "standard"
        },
        "lastName": {
          "type": "text",
          "analyzer": "standard"
        },
        "age": {
          "type": "integer"
        },
        "gender": {
          "type": "keyword"
        },
        "address": {
          "type": "text",
          "analyzer": "custom_english_analyzer"
        },
        "email": {
          "type": "keyword"
        },
        "city": {
          "type": "text",
          "analyzer": "custom_english_analyzer"
        },
        "state": {
          "type": "text",
          "analyzer": "custom_english_analyzer"
        }
      }
    }
  }
}
```

## ES Document Structure

> 
```java
{
    "account_number" : 25,
    "balance" : 40540,
    "firstname" : "Virginia",
    "lastname" : "Ayala",
    "age" : 39,
    "gender" : "F",
    "address" : "171 Putnam Avenue",
    "employer" : "Filodyne",
    "email" : "virginiaayala@filodyne.com",
    "city" : "Nicholson",
    "state" : "PA"
}
```

## ES Queries

### ES Search - All
> GET es-demo/account/_search

### ES Search - Range Query
```java
{
  "query": {
    "range": {
      "age": {
        "gte": 40
      }
    }
  }
}
```

### ES Search - Multi Match Query
> GET es-demo/account/_search
```java
{
  "query": {
    "multi_match": {
      "query": "bates",
      "fields": ["firstname", "lastName", "city"]
    }
  }
}
```

### ES Search - Bool Query
> GET es-demo/account/_search
```java
{
  "query": {
    "bool": {
      "filter": {
        "term": {
          "gender": "M"
        }
      }, 
      "must": [
        {
          "term": {
            "age": {
              "value": "20"
            }
          }
        }
      ],
      "must_not": [
        {
          "term": {
            "state": {
              "value": "NM"
            }
          }
        }
      ]
    }
  }
}
```

### ES Search - Aggregation Query
> GET es-demo/account/_search
```java
{
  "size": 0, 
  "query": {
    "match_all": {}
  },
  "aggs": {
    "AGE_AGGREGATION": {
      "terms": {
        "field": "age",
        "size": 100
      },
      "aggs": {
        "GENDER AGGREGATION": {
          "terms": {
            "field": "gender",
            "size": 100
          }
        }
      }
    }
  }
}
```



