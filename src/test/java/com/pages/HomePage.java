package com.pages;

import com.core.ui.elements.Element;
import com.microsoft.playwright.Page;
import com.core.ui.elements.Button;
public class HomePage extends Header {
    private final String mainPageHeaderLocator = "main>div.my-3>h1";
    private final String createNewRepositoryButtonSelector = "p~a[href='/new']";
    private final String wrongCredsErrorSelector = "#js-flash-container>div";

    public HomePage(Page page) {
        super(page);
    }

    public void goToCreateRepositoryPage() {
        Button createNewRepositoryButton = new Button(
                createNewRepositoryButtonSelector, "create repository button", page);
        createNewRepositoryButton.click();
    }

    public Boolean isMainPageHeaderPresent() {
        Element header = new Element(mainPageHeaderLocator, "main page header", page);
        return header.isVisible();
    }

    public Boolean isWrongCredsErrorPresent() {
        Element wrongCredsError = new Element(wrongCredsErrorSelector, "wrong credentials Error", page);
        return wrongCredsError.isVisible();
    }
}
