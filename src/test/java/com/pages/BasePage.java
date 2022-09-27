package com.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public abstract class BasePage {
    Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public ElementHandle getElement(String selector) {
        return page.waitForSelector(selector);
    }

    public Page navigateTo(String url) {
        page.navigate(url);
        return page;
    }

    public Boolean isVisible(String selector) {
        return page.isVisible(selector);
    }
}
