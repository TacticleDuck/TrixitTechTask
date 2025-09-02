package pageobjects.myprofile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverSupporter;

public class UserInformation {
    private WebDriver driver;

    private final By correspondenceEmail = By.cssSelector("#correspondenceEmail");
    private final By userInfoLanguage = By.id("userInfoLanguage");
    private final By editUserInfoLanguage = By.cssSelector("#editUserInfoLanguage");

    public UserInformation(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get Correspondence email: {return}")
    public String getCorrespondenceEmail() {
        DriverSupporter.waitUntilVisible(correspondenceEmail);
        return driver.findElement(correspondenceEmail).getText();
    }

    @Step("Get Correspondence language: {return}")
    public String getCorrespondenceLanguage() {
        DriverSupporter.waitUntilVisible(userInfoLanguage);
        return driver.findElement(userInfoLanguage).getText();
    }

    @Step("Click Change correspondence language icon")
    public void clickChangeCorrespondenceLanguage() {
        DriverSupporter.waitUntilVisible(editUserInfoLanguage);
        driver.findElement(editUserInfoLanguage).click();
    }
}
