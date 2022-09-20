package com.pages;

import com.microsoft.playwright.Page;

public class HomePage extends Header {
    Page page;

    private final String mainPageHeaderLocator = "main>div.my-3>h1";
    private final String createNewRepositoryButton = "article:nth-child(3) div:nth-child(1) > a";
    private final String wrongCredsError = "#js-flash-container>div";

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    public void goToCreateRepositoryPage() {
        page.click(createNewRepositoryButton);
    }

    public Boolean isMainPageHeaderPresent() {
        return page.isVisible(mainPageHeaderLocator);
    }

    public Boolean isWrongCredsErrorPresent() {
        return page.isVisible(wrongCredsError);
    }
}
