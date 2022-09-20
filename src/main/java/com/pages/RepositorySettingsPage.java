package com.pages;

import com.microsoft.playwright.Page;

public class RepositorySettingsPage extends Header {
    Page page;

    private final String deleteRepositoryButton = ".Box li:nth-child(4) summary";
    private final String deletingConfirmationTextSelector = "li:nth-child(4) p:nth-child(2) > strong";
    private final String confirmationTextInput = "div.overflow-auto > form > p > input";
    private final String deleteRepositoryButtonSure = " form[action$=delete] > button";

    public void deleteRepository() {
        page.click(deleteRepositoryButton);
        String confirmationText = page.innerText(deletingConfirmationTextSelector);
        page.fill(confirmationTextInput, confirmationText);
        page.click(deleteRepositoryButtonSure);
    }

    public RepositorySettingsPage(Page page) {
        super(page);
        this.page = page;
    }
}
