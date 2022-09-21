package com.pages;

import com.microsoft.playwright.Page;

public class RepositorySettingsPage extends Header {
    Page page;

    private final String deleteRepositoryButton = "//summary[contains(text(), 'Delete this repository')]";
    private final String deletingConfirmationTextSelector = "li:nth-child(4) p:nth-child(2) > strong";
    private final String confirmationTextInput = "div.overflow-auto > form > p > input";
    private final String deleteRepositoryButtonSure = " form[action$=delete] > button";

    public void deleteRepository(String username, String repositoryNAme) {
        page.click(deleteRepositoryButton);
        String confirmationText = String.format("%s/%s", username, repositoryNAme);
        page.fill(confirmationTextInput, confirmationText);
        page.click(deleteRepositoryButtonSure);
    }

    public RepositorySettingsPage(Page page) {
        super(page);
        this.page = page;
    }
}
