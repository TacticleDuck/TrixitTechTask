package pageobjects.account;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverSupporter;

public class ProfileMenu extends AccountHeader {
    private final By myProfile = By.cssSelector("#authenticated-menu > ul > li:nth-child(2)");

    public ProfileMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Select My profile from the menu")
    public void selectMyProfile() {
        WebElement myProfileItem = DriverSupporter.waitForNestedShadowElement(headerShadowHost, profile, myProfile);
        myProfileItem.click();
    }
}
