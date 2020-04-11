package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import play.libs.Json;
import play.mvc.*;
import services.AccountService;

import java.io.IOException;

@Singleton
public class AccountController extends Controller {

    private final AccountService accountService;

    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Result searchAllAccounts() throws IOException {
        JsonNode response = accountService.getAllAccounts();
        return ok(Json.toJson(response));
    }

    public Result searchOneAccountByAccount(String accountNumber) throws IOException {
        JsonNode response = accountService.getOneAccountByAccountNo(accountNumber);
        return ok(Json.toJson(response));
    }

    public Result searchAccountsByName(String name) throws IOException {
        JsonNode response = accountService.getAccountsByName(name);
        return ok(Json.toJson(response));
    }

    public Result searchAccountsByAgeRange(String age) throws IOException {
        JsonNode response = accountService.getAccountByAgeRange(age);
        return ok(Json.toJson(response));
    }

    public Result searchAggregationByAgeAndGender() throws IOException {
        JsonNode response = accountService.getAggregationByAgeAndGender();
        return ok(Json.toJson(response));
    }

    public Result createNewAccount(Http.Request request) throws IOException {
        JsonNode response = accountService.addAccount(request.body().asJson());
        return ok(Json.toJson(response));
    }

    public Result deleteAccount(String id) throws IOException {
        JsonNode response = accountService.deleteAccount(id);
        return ok(Json.toJson(response));
    }

    public Result createNewIndex(Http.Request request) throws IOException {
        JsonNode response = accountService.addIndex(request.body().asJson());
        return ok(Json.toJson(response));
    }

    public Result deleteIndex(String name) throws IOException {
        JsonNode response = accountService.deleteIndex(name);
        return ok(Json.toJson(response));
    }
}
