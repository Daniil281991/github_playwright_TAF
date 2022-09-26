package com.pages;

import com.core.ui.elements.Button;
import com.microsoft.playwright.Page;

public class RepositoryPage extends Header {
    public RepositoryPage(Page page) {
        super(page);
    }

    private final String settingsTabButton = "#settings-tab";

    public void goToSettingsTab() {
        Button settingsButton = new Button(settingsTabButton, "Settings button", page);
        settingsButton.click();
    }
}
