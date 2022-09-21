package com.tests;

import java.nio.file.Paths;
import static org.testng.AssertJUnit.assertTrue;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StartPage;
import com.utils.EnvVariablesManager;
import com.utils.PropertiesReader;
import org.testng.annotations.*;

public class LoginTest {
    PlaywrightFactory pf;
    Page page;
    LoginPage loginPage;
    StartPage startPage;
    HomePage homePage;
    private String userEmail, userPassword, wrongEmail, wrongPassword;
    private final String screenshotsFolderPath = "src/test/resources/screenshots";
    PropertiesReader propertiesReader;

    @BeforeTest
    public void setup() {
        pf =new PlaywrightFactory();
        page = pf.initBrowser("chromium");
        page.context().clearCookies();
        propertiesReader = new PropertiesReader();
        userEmail = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_EMAIL");
        userPassword = new EnvVariablesManager().getEnvironmentVariable("TAF_PLAYWRIGHT_GITHUB_USER_PASSWORD");
        wrongEmail = "wrongEmail";
        wrongPassword = "wrongPassword";
    }

    @BeforeMethod
    public void setUpMethod() {
        startPage = new StartPage(page);
        startPage.goToLoginPage();
        loginPage = new LoginPage(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    @Test
    public void testUserCanLogInWithValidCreds() {
        loginPage.logInWithCreds(userEmail, userPassword);

        homePage = new HomePage(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(homePage.isMainPageHeaderPresent());

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/LoginningTest.png")));
    }

    @Test
    public void testUserCanSeeErrorMessageAfterWrongCredsLogging() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        loginPage.logInWithCreds(wrongEmail, wrongPassword);

        homePage = new HomePage(page);
        assertTrue(homePage.isWrongCredsErrorPresent());

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/LoginningTestWrongCreds.png")));
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
