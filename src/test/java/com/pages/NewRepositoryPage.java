package com.pages;

import com.core.ui.elements.Button;
import com.core.ui.elements.Checkbox;
import com.core.ui.elements.Input;
import com.core.ui.elements.Radio;
import com.microsoft.playwright.Page;

public class NewRepositoryPage extends Header {
    private final String repositoryNameInputSelector = "#repository_name";
    private final String radioPublicSelector = "#repository_visibility_public";
    private final String radioPrivateSelector = "#repository_visibility_private";
    private final String checkboxAddReadmeSelector = "#repository_auto_init";
    private final String createRepositoryButtonSelector = "div.js-with-permission-fields > button";

    public NewRepositoryPage(Page page) {
        super(page);
    }

    public void createRepository(String repositoryName) {
        Input repositoryNameInput = new Input(repositoryNameInputSelector, "repositoryName input", page);
        repositoryNameInput.click();
        repositoryNameInput.type(repositoryName);

        Radio radioPublic = new Radio(radioPublicSelector, "radio public", page);
        radioPublic.check();

        Checkbox checkboxAddReadme = new Checkbox(checkboxAddReadmeSelector, "checkbox 'Add README'", page);
        checkboxAddReadme.check();

        Button createRepositoryButton = new Button(
                createRepositoryButtonSelector, "Button 'Create repository'", page);
        createRepositoryButton.click();
    }
}
