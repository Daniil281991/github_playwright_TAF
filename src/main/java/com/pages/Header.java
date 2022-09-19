package com.pages;

import com.microsoft.playwright.Page;

public class Header {
    Page page;

    private final String userProfileButton = ".Header-item:nth-child(7) .Header-link";
    private final String logOutButton = ".logout-form>button";

    public Header(Page page) {
        this.page = page;
    }

    public void logOut() {
        if (page.isVisible(userProfileButton)) {
            page.click(userProfileButton);
            page.click(logOutButton);
        }
    }


}
