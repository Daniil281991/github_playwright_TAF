package com.tests;

import java.nio.file.Paths;
import static org.testng.AssertJUnit.assertTrue;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.pages.*;
import com.utils.APIHelper;
import com.utils.EnvVariablesManager;
import com.utils.PropertiesReader;
import org.testng.annotations.*;

public class HomeTest {
    PlaywrightFactory pf;
    Page page;
    LoginPage loginPage;
    StartPage startPage;
    HomePage homePage;
    NewRepositoryPage newRepositoryPage;
    RepositoryPage repositoryPage;
    PropertiesReader propertiesReader;
    private String userName, repositoryName, userEmail, userPassword, screenshotsFolderPath;


    @BeforeTest
    public void setup() {
        propertiesReader = new PropertiesReader();
        userName = propertiesReader.getProperties("USER_NAME");
        repositoryName = propertiesReader.getProperties("REPOSITORY_NAME");
        userEmail = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_EMAIL");
        userPassword = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_PASSWORD");
        screenshotsFolderPath = propertiesReader.getProperties(
                "SCREENSHOT_FOLDER_PATH");

        pf =new PlaywrightFactory();
        page = pf.initBrowser("chromium");
        page.context().clearCookies();
    }

    @BeforeMethod
    public void setUpMethod() {
        startPage = new StartPage(page);
        startPage.goToLoginPage();
        loginPage = new LoginPage(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        loginPage.logInWithCreds(userEmail, userPassword);
    }

    @Test
    public void testUserCanCreateRepository() {
        homePage = new HomePage(page);
        homePage.goToCreateRepositoryPage();

        newRepositoryPage = new NewRepositoryPage(page);
        newRepositoryPage.createRepository("new_repository");

        repositoryPage = new RepositoryPage(page);

        assertTrue(repositoryPage.isRepositoryExists("new_repository"));

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/createRepositoryTest.png")));

        new APIHelper().deleteRepository(userName, repositoryName);
    }

    @Test
    public void testUserCanDeleteRepository() {
        new APIHelper().createRepository("New_api_made_project");

        homePage = new HomePage(page);




        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/createRepositoryTest.png")));

        new APIHelper().deleteRepository(userName, "New_api_made_project");
    }

    @AfterMethod
    public void tearDownMethod() {
        homePage.logOut();
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
