package com.pages;

import com.microsoft.playwright.Page;

public class StartPage {
    Page page;

    String loginPageButton = "[href='/login']";

    // page constructor
    public StartPage(Page page) {
        this.page = page;
    }

    public void goToLoginPage() {
        page.click(loginPageButton);
    }

    public String getHomePageURL() {
        return page.url();
    }

}
