package com.pages;

import com.core.ui.elements.Button;
import com.microsoft.playwright.Page;

public class RepositoriesPage extends Header {
    private final String repositoryLink = "div>strong>a";
    private final String repositoryLinkSelectorPattern = "a[href$=%s]";

    public RepositoriesPage(Page page) {
        super(page);
    }

    public Boolean isRepositoryExists(String repositoryName) {
        String repositoryLinkSelector = String.format(repositoryLinkSelectorPattern, repositoryName);

        Button repositoryButton = new Button(repositoryLinkSelector,
                String.format("link to repository %s", repositoryName), page);

        return repositoryButton.isVisible();
    }

    public void goToRepositoryPage(String repositoryName) {
        String repositoryLinkSelector = String.format(repositoryLinkSelectorPattern, repositoryName);

        Button repositoryButton = new Button(repositoryLinkSelector,
                String.format("link to repository %s", repositoryName), page);
        repositoryButton.click();
    }
}
