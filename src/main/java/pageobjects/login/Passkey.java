package pageobjects.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverSupporter;

public class Passkey {
    private WebDriver driver;

    private final By maybeLater = By.id("register-passkey-left-button");

    public Passkey(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Remind later")
    public void clickRemindLater() {
        DriverSupporter.waitUntilVisible(maybeLater);
        driver.findElement(maybeLater).click();
    }
}