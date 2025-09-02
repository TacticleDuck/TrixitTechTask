package pageobjects.account;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverSupporter;

public class AccountHeader {
    private WebDriver driver;

    final By headerShadowHost = By.cssSelector("app-root > swisspost-internet-header");
    final By profile = By.cssSelector(".main-navigation-controls > post-klp-login-widget");
    final By widgetAuthenticated = By.cssSelector(".klp-widget-authenticated");

    public AccountHeader(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click profile button")
    public void clickProfileButton() {
        DriverSupporter.waitUntilPresenceOfElementLocated(headerShadowHost);
        WebElement profileBtn = DriverSupporter.waitForNestedShadowElement(headerShadowHost, profile);
        profileBtn.click();
    }

    public void waitForAuthenticated() {
        WebElement authenticatedWidgetLogo = DriverSupporter.waitForNestedShadowElement(headerShadowHost, profile, widgetAuthenticated);
        authenticatedWidgetLogo.isDisplayed();
    }
}
