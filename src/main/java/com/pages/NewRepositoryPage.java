package com.pages;

import com.microsoft.playwright.Page;

public class NewRepositoryPage extends Header {
    private final Page page;
    private final String repositoryNameInputField = "#repository_name";
    private final String radioPublic = "#repository_visibility_public";
    private final String radioPrivate = "#repository_visibility_private";
    private final String checkboxAddReadme = "#repository_auto_init";
    private final String createRepositoryButton = "div.js-with-permission-fields > button";

    public NewRepositoryPage(Page page) {
        super(page);
        this.page = page;
    }

    public void createRepository(String repositoryName) {
        page.click(repositoryNameInputField);
        page.fill(repositoryNameInputField, repositoryName);
        page.locator(radioPublic).check();
        page.locator(checkboxAddReadme).check();
        page.click(createRepositoryButton);
    }
}
