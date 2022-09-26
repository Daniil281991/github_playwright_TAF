package com.pages;

import com.core.ui.elements.Button;
import com.microsoft.playwright.Page;

public class Header extends BasePage {
    String userProfileButtonSelector = ".Header-item summary > img";
    String logoutButtonSelector = ".logout-form>button";
    String repositoriesButtonSelector = "details-menu>a[href$=repositories]";


    public Header(Page page) {
        super(page);
    }

    public void logOut() {
        Button userProfileButton = new Button(userProfileButtonSelector,
                "user profile button", page);
        userProfileButton.click();
        Button logoutButton = new Button(logoutButtonSelector,
                "logout button", page);
        logoutButton.click();
    }

    public void goToRepositoriesPage() {
        Button userProfileButton = new Button(userProfileButtonSelector,
                "user profile button", page);
        userProfileButton.click();
        Button repositoriesButton = new Button(repositoriesButtonSelector,
                "repositories button", page);
        repositoriesButton.click();
    }
}
