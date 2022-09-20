package com.pages;

import com.microsoft.playwright.Page;

public class Header {
    Page page;

    private final String userProfileButton = ".Header-item:nth-child(7) .Header-link";
    private final String logOutButton = ".logout-form>button";
    private final String repositoriesButton = "a[href$=repositories]";

    public Header(Page page) {
        this.page = page;
    }

    public void logOut() {
        if (page.isVisible(userProfileButton)) {
            page.click(userProfileButton);
            page.click(logOutButton);
        }
    }

    public void goToRepositoriesPage() {
        page.click(userProfileButton);
        page.click(repositoriesButton);
    }
}
