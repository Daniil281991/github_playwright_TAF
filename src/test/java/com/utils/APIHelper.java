package com.utils;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class APIHelper {
    private Playwright playwright;
    private APIRequestContext request;
    private PropertiesReader propertiesReader;

    public APIHelper() {
    }

    void createPlaywright() {
        playwright = Playwright.create();
    }

    APIRequestContext createAPIRequestContext() {
        propertiesReader = new PropertiesReader();
        String API_TOKEN = propertiesReader.getProperties("API_TOKEN");

        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
        headers.put("Accept", "application/vnd.github.v3+json");
        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
        headers.put("Authorization", "token " + API_TOKEN);

        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL("https://api.github.com")
                .setExtraHTTPHeaders(headers));

        return request;
    }

    public void deleteRepository(String user, String repositoryName) {
        createPlaywright();
        request = createAPIRequestContext();

        APIResponse deleteRepoResponse = request.delete("/repos/" + user + "/" + repositoryName);

        request.dispose();
        playwright.close();
    }

}
