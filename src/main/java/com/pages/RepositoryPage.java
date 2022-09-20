package com.pages;

import com.microsoft.playwright.Page;

import java.util.Objects;

public class RepositoryPage extends Header {
    private final Page page;

    private final String repositoryLink = "div>strong>a";


    // page constructor
    public RepositoryPage(Page page) {
        super(page);
        this.page = page;
    }

    public Boolean isRepositoryExists(String repositoryName) {
        return Objects.equals(page.innerText(repositoryLink), repositoryName);
    }
}
