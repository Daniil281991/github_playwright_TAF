package com.utils;

import com.microsoft.playwright.APIResponse;

public class APIRunner {
    public static void main(String[] args) {
        APIResponse deleteRepositoryResponse;
        APIResponse createRepositoryResponse;

//        deleteRepositoryResponse = new APIHelper().deleteRepository(
//                "ta-user-danchik", "new_repository");

        createRepositoryResponse = new APIHelper().createRepository("My_first_repository_created");

//        System.out.println(deleteRepositoryResponse.ok());
//        System.out.println(deleteRepositoryResponse.status());

        System.out.println(createRepositoryResponse.ok());
        System.out.println(createRepositoryResponse.status());
    }
}
