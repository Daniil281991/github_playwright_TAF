package com.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.pages.*;
import com.utils.APIHelper;
import org.testng.annotations.*;

import java.nio.file.Paths;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class RepositoriesTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    StartPage startPage;
    NewRepositoryPage newRepositoryPage;
    RepositoriesPage repositoriesPage;
    RepositoryPage repositoryPage;
    RepositorySettingsPage repositorySettingsPage;

    @BeforeClass
    public void setUpMethod() {
        startPage = new StartPage(page);
        startPage.goToLoginPage();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        loginPage = new LoginPage(page);
        loginPage.logInWithCreds(userEmail, userPassword);
    }

    @Test
    public void testUserCanCreateRepository() {
        homePage = new HomePage(page);
        homePage.goToCreateRepositoryPage();

        newRepositoryPage = new NewRepositoryPage(page);
        newRepositoryPage.createRepository("new_repository");

        repositoriesPage = new RepositoriesPage(page);

        page.waitForLoadState();

        assertTrue(repositoriesPage.isRepositoryExists("new_repository"));

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/createRepositoryTest.png")));

        new APIHelper().deleteRepository(userName, repositoryName);
    }

    @Test(dataProvider = "getRepositoryNames")
    public void testUserCanDeleteRepository(String repositoryName) {
        new APIHelper().createRepository(repositoryName);

        homePage = new HomePage(page);
        homePage.goToRepositoriesPage();

        repositoriesPage = new RepositoriesPage(page);

        repositoriesPage.goToRepositoryPage(repositoryName);

        repositoryPage = new RepositoryPage(page);
        repositoryPage.goToSettingsTab();

        repositorySettingsPage = new RepositorySettingsPage(page);
        repositorySettingsPage.deleteRepository(userName, repositoryName);

        page.waitForLoadState();

        repositoriesPage = new RepositoriesPage(page);
        assertFalse(repositoriesPage.isRepositoryExists(repositoryName));

        page.screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get(screenshotsFolderPath + "/createRepositoryTest.png")));

        new APIHelper().deleteRepository(userName, repositoryName);
    }

    @DataProvider
    public Object[][] getRepositoryNames() {
        return new Object[][] {
                {"first_repository"},
                {"second_repository"},
                {"third_repository"}
        };
    }

    @AfterClass
    public void tearDownMethod() {
        homePage.logOut();
    }
}
