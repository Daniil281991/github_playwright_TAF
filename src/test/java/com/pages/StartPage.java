package com.pages;

import com.core.ui.elements.Button;
import com.microsoft.playwright.Page;

public class StartPage extends BasePage {

    String loginButtonSelector = "[href='/login']";

    public StartPage(Page page) {
        super(page);
    }

    public void goToLoginPage() {
        Button loginButton = new Button(loginButtonSelector, "Login button", page);
        loginButton.click();
    }
}
