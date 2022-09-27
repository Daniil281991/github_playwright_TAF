package com.factory;

import com.microsoft.playwright.*;
import com.utils.PropertiesReader;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    PropertiesReader propertiesReader;

    public Page initBrowser(String browserName) {
        playwright = Playwright.create();
        propertiesReader = new PropertiesReader();

        switch (browserName.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        String mainPageURL = propertiesReader.getProperties("MAIN_PAGE_URL").trim();
        page.navigate(mainPageURL);

        return page;
    }

}
