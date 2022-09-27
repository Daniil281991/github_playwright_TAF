package com.tests;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.utils.EnvVariablesManager;
import com.utils.PropertiesReader;
import org.testng.annotations.*;
import com.pages.StartPage;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
//    StartPage startPage;
    PropertiesReader propertiesReader;
    protected final String screenshotsFolderPath = "src/test/resources/screenshots";
    protected String userName;
    protected String repositoryName;
    protected String userEmail;
    protected String userPassword;

    @BeforeClass
    public void setup() {
        propertiesReader = new PropertiesReader();
        userName = propertiesReader.getProperties("USER_NAME");
        repositoryName = propertiesReader.getProperties("REPOSITORY_NAME");
        userEmail = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_EMAIL");
        userPassword = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_PASSWORD");

        pf = new PlaywrightFactory();
        page = pf.initBrowser("chromium");
    }


    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }
}
