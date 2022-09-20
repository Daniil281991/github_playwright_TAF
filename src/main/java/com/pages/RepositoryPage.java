package com.pages;

import com.microsoft.playwright.Page;

public class RepositoryPage extends Header {
    Page page;

    public RepositoryPage(Page page) {
        super(page);
        this.page = page;
    }

    private final String settingsTabButton = "#settings-tab";

    public void goToSettingsTab() {
        page.click(settingsTabButton);

    }
}
