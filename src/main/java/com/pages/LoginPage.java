package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final String loginInputField = "#login_field";
    private final String passwordInputField = "#password";
    private final String signInButtonSelector = " input.js-sign-in-button";
    public String homePageUrl = "";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void logInWithCreds(String email, String password) {
        page.click(loginInputField);
        page.fill(loginInputField, email);
        page.click(passwordInputField);
        page.fill(passwordInputField, password);
        page.click(signInButtonSelector);
        homePageUrl = page.url();
    }
}
