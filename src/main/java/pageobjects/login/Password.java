package pageobjects.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverSupporter;

public class Password {
    private WebDriver driver;

    private final By password = By.id("password");
    private final By passwordLoginBtn = By.cssSelector("button#login-password");

    public Password(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill password: {password}")
    public void fillPassword(String pass) {
        DriverSupporter.waitUntilVisible(password);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    @Step("Confirm password")
    public void confirmPassword() {
        DriverSupporter.waitUntilVisible(passwordLoginBtn);
        driver.findElement(passwordLoginBtn).click();
    }
}
