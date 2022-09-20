package com.utils;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class APIHelper {
    private Playwright playwright;
    private PropertiesReader propertiesReader;
//    private APIRequestContext request;
    public APIHelper() {
    }

    void createPlaywright() {
        playwright = Playwright.create();
    }

    APIRequestContext createAPIRequestContext() {
        propertiesReader = new PropertiesReader();
        String API_TOKEN = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_API_TOKEN");
        String BASE_API_URL = propertiesReader.getProperties("BASE_API_URL");

        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
        headers.put("Accept", "application/vnd.github.v3+json");
        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
        headers.put("Authorization", "token " + API_TOKEN);

        APIRequestContext requestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL(BASE_API_URL)
                .setExtraHTTPHeaders(headers));
        return requestContext;
    }

    public APIResponse deleteRepository(String user, String repositoryName) {
        createPlaywright();
        APIRequestContext requestContext = createAPIRequestContext();

        APIResponse deleteRepoResponse = requestContext.delete("/repos/" + user + "/" + repositoryName);

        deleteRepoResponse.dispose();
        playwright.close();

        return deleteRepoResponse;
    }

    public APIResponse createRepository(String repositoryName) {
        createPlaywright();
        APIRequestContext requestContext = createAPIRequestContext();

        APIResponse createRepositoryResponse = requestContext.post("/user/repos",
                RequestOptions.create().setData(Collections.singletonMap("name", repositoryName)));

        requestContext.dispose();
        playwright.close();

        return createRepositoryResponse;
    }
}
