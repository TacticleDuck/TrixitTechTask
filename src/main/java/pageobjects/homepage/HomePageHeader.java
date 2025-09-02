package pageobjects.homepage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverSupporter;

public class HomePageHeader {
    private WebDriver driver;

    private final By headerShadowHost = By.cssSelector("swisspost-internet-header");
    private final By loginButton = By.cssSelector(".main-navigation-controls post-klp-login-widget");

    public HomePageHeader(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        WebElement loginButtonElem = DriverSupporter.waitForNestedShadowElement(headerShadowHost, loginButton);
        loginButtonElem.click();
    }
}
