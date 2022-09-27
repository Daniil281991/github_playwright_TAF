package com.pages;

import com.core.ui.elements.Button;
import com.core.ui.elements.Input;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final String loginInputFieldSelector = "#login_field";
    private final String passwordInputFieldSelector = "#password";
    private final String signInButtonSelector = " input.js-sign-in-button";

    public LoginPage(Page page) {
        super(page);
    }

    public void logInWithCreds(String email, String password) {
        Input loginInputField = new Input(loginInputFieldSelector, "Login input field", page);
        Input passwordInputField = new Input(passwordInputFieldSelector, "password input field", page);
        Button signInButton = new Button(signInButtonSelector, "Sign In Button", page);
        loginInputField.click();
        loginInputField.type(email);
        passwordInputField.click();
        passwordInputField.type(password);
        signInButton.click();
    }
}
