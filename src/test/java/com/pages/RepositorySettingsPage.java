package com.pages;

import com.core.ui.elements.Button;
import com.core.ui.elements.Input;
import com.microsoft.playwright.Page;

public class RepositorySettingsPage extends Header {
    private final String deleteRepositoryButtonSelector = "//summary[contains(text(), 'Delete this repository')]";
    private final String deletingConfirmationTextSelector = "li:nth-child(4) p:nth-child(2) > strong";
    private final String confirmationTextInputSelector = "div.overflow-auto > form > p > input";
    private final String deleteRepositoryButtonSureSelector = " form[action$=delete] > button";

    public void deleteRepository(String username, String repositoryNAme) {
        Button deleteRepositoryButton = new Button(
                deleteRepositoryButtonSelector, "Delete repository Button", page);
        deleteRepositoryButton.click();

        String confirmationText = String.format("%s/%s", username, repositoryNAme);

        Input confirmationTextInput = new Input(
                confirmationTextInputSelector, "Confirm Delete repository Input", page);
        confirmationTextInput.type(confirmationText);

        Button deleteRepositoryButtonSure = new Button(
                deleteRepositoryButtonSureSelector, "Confirm Delete repository Button", page);
        deleteRepositoryButtonSure.click();
    }

    public RepositorySettingsPage(Page page) {
        super(page);
    }
}
