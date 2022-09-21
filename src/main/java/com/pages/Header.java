package com.pages;

import com.microsoft.playwright.Page;

public class Header {
    Page page;

    private final String userProfileButton = ".Header-item summary > img";
    private final String logOutButton = ".logout-form>button";
    private final String repositoriesButton = "a[href$=repositories]";

    public Header(Page page) {
        this.page = page;
    }

    public void logOut() {
        page.click(userProfileButton);
        page.click(logOutButton);
    }

    public void goToRepositoriesPage() {
        page.click(userProfileButton);
        page.click(repositoriesButton);
    }
}
