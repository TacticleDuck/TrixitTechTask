package pageobjects.account;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverSupporter;

public class AccountPage {
    private WebDriver driver;

    private final By welcome = By.cssSelector("#os_content .cockpit--welcome");

    public AccountHeader accountHeader;
    public ProfileMenu profileMenu;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.accountHeader = new AccountHeader(driver);
        this.profileMenu = new ProfileMenu(driver);
    }

    @Step("Check successful login")
    public boolean isSuccessfullyLoggedIn() {
        return isWelcomeMessageVisible();
    }

    private boolean isWelcomeMessageVisible() {
        accountHeader.waitForAuthenticated();
        DriverSupporter.waitUntilVisible(welcome);

        return driver.findElement(welcome).isDisplayed();
    }
}
