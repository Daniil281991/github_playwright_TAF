package com.pages;

import com.microsoft.playwright.Page;

import java.util.Objects;

public class RepositoriesPage extends Header {
    private final Page page;

    private final String repositoryLink = "div>strong>a";
    private final String repositoryLinkSelectorPattern = "a[href$=%s]";

    public RepositoriesPage(Page page) {
        super(page);
        this.page = page;
    }

    public Boolean isRepositoryExists(String repositoryName) {
        String repositoryLinkSelector = String.format(repositoryLinkSelectorPattern, repositoryName);
        return page.isVisible(repositoryLinkSelector);
    }

    public void goToRepositoryPage(String repositoryName) {
        page.click(String.format(repositoryLinkSelectorPattern, repositoryName));
    }
}
