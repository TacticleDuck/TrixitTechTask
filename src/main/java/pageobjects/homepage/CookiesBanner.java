package pageobjects.homepage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverSupporter;

public class CookiesBanner {
    private WebDriver driver;

    private final By shadowHost = By.cssSelector("#usercentrics-root");
    private final By acceptCookies = By.cssSelector("#bottom-layer-focus-lock div[data-testid='uc-buttons-container'] > button[data-testid='uc-accept-all-button']");

    public CookiesBanner(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Accept all cookies")
    public void acceptAll() {
        DriverSupporter.waitUntilPresenceOfElementLocated(shadowHost);

        WebElement acceptAllCookies = DriverSupporter.waitForNestedShadowElement(shadowHost, acceptCookies);
        acceptAllCookies.click();
    }
}
