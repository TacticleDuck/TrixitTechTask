package pageobjects.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverSupporter;

public class EmailAddress {
    private WebDriver driver;

    private final By email = By.id("email");
    private final By emailLoginBtn = By.cssSelector("button#login-email");

    public EmailAddress(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill email: {user}")
    public void fillEmail(String user) {
        DriverSupporter.waitUntilVisible(email);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(user);
    }

    @Step("Confirm email")
    public void confirmEmail() {
        DriverSupporter.waitUntilVisible(emailLoginBtn);
        driver.findElement(emailLoginBtn).click();
    }
}
