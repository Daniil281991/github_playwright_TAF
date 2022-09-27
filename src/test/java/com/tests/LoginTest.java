package com.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StartPage;
import constants.AppConstants;
import org.testng.annotations.*;

import java.nio.file.Paths;

import static org.testng.AssertJUnit.assertTrue;
public class LoginTest extends BaseTest {
    StartPage startPage;
    LoginPage loginPage;
    HomePage homePage;
    private String wrongEmail, wrongPassword;
    String screenshotsFolderPath = AppConstants.SCREENSHOT_FOLDER_PATH;

    @BeforeClass
    public void setUpLoginTest() {
        startPage = new StartPage(page);
        wrongEmail = "wrongEmail";
        wrongPassword = "wrongPassword";
    }

    @Test
    public void testUserCanLogInWithValidCreds() {
        startPage.goToLoginPage();
        page.waitForLoadState(LoadState.NETWORKIDLE);

        loginPage = new LoginPage(page);
        loginPage.logInWithCreds(userEmail, userPassword);

        homePage = new HomePage(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(homePage.isMainPageHeaderPresent());

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/LoginningTest.png")));

        homePage.logOut();
    }

    @Test
    public void testUserCanSeeErrorMessageAfterWrongCredsLogging() {
        startPage.goToLoginPage();
        page.waitForLoadState(LoadState.NETWORKIDLE);

        loginPage = new LoginPage(page);
        loginPage.logInWithCreds(wrongEmail, wrongPassword);

        homePage = new HomePage(page);
        assertTrue(homePage.isWrongCredsErrorPresent());

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/LoginningTestWrongCreds.png")));

        String mainPageURL = propertiesReader.getProperties("MAIN_PAGE_URL").trim();
        homePage.navigateTo(mainPageURL);
    }
}
