import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.account.AccountPage;
import pageobjects.enums.Nationals;
import pageobjects.homepage.CookiesBanner;
import pageobjects.homepage.HomePage;
import pageobjects.homepage.HomePageHeader;
import pageobjects.login.EmailAddress;
import pageobjects.login.Passkey;
import pageobjects.login.Password;
import pageobjects.myprofile.UserInformation;
import pageobjects.myprofile.useraccountsettings.UserAccountSettings;
import util.DriverSupporter;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import static pageobjects.enums.Nationals.DE;
import static pageobjects.enums.Nationals.EN;

public class MainTest {
    private static WebDriver driver;
    private String user;
    private String pass;
    private Nationals targetLanguage;

    private HomePage homePage;
    private CookiesBanner cookiesBanner;
    private HomePageHeader homePageHeaderLanding;
    private EmailAddress emailAddress;
    private Password password;
    private Passkey passkey;
    private AccountPage accountPage;
    private UserInformation userInformation;
    private UserAccountSettings userAccountSettings;

    @BeforeMethod
    public void setup() {
        driver = DriverSupporter.getDriver();
        user = Utils.getUsername;
        pass = Utils.getPassword;
        targetLanguage = DE;

        homePage = new HomePage(driver);
        cookiesBanner = new CookiesBanner(driver);
        homePageHeaderLanding = new HomePageHeader(driver);
        emailAddress = new EmailAddress(driver);
        password = new Password(driver);
        passkey = new Passkey(driver);
        accountPage = new AccountPage(driver);
        userInformation = new UserInformation(driver);
        userAccountSettings = new UserAccountSettings(driver);
    }


    @Test
    public void testLoginAndLanguageChange() {
        homePage.goToSwissPost(EN);
        cookiesBanner.acceptAll();
        homePageHeaderLanding.clickLoginButton();

        emailAddress.fillEmail(user);
        emailAddress.confirmEmail();
        password.fillPassword(pass);
        password.confirmPassword();
        passkey.clickRemindLater();
        Assert.assertTrue(accountPage.isSuccessfullyLoggedIn(), "Checking successful login.");

        accountPage.accountHeader.clickProfileButton();
        accountPage.profileMenu.selectMyProfile();
        Assert.assertEquals(userInformation.getCorrespondenceEmail(), user, "Checking username/email.");

        userInformation.clickChangeCorrespondenceLanguage();
        userAccountSettings.changeCorrespondenceLanguage(targetLanguage);
        Assert.assertEquals(userInformation.getCorrespondenceLanguage(), targetLanguage.getValue(),
                "Checking changed correspondence language");
    }

    @Test()
    public void testLoginFailureScenario() {
        homePage.goToSwissPost(EN);
        cookiesBanner.acceptAll();
        homePageHeaderLanding.clickLoginButton();

        emailAddress.fillEmail(user);
        Assert.fail();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup(ITestResult result) {
        takeScreenshotOnFailure(result);

        DriverSupporter.quit();
    }

    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String id = UUID.randomUUID().toString().substring(0, 8);
            String fileName = "screenshots/" + id + ".png";

            try {
                Files.createDirectories(new File("screenshots").toPath());
                Files.copy(src.toPath(), new File(fileName).toPath());
                System.out.println("Saved screenshot: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
