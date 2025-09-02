package pageobjects.myprofile.useraccountsettings;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.enums.Nationals;
import util.DriverSupporter;

public class UserAccountSettings {
    private WebDriver driver;

    private final By languages = By.id("languages");
    private final By confirm = By.id("confirm");

    public UserAccountSettings(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Change Correspondence language to: {language}")
    public void changeCorrespondenceLanguage(Nationals language) {
        DriverSupporter.waitUntilVisible(languages);

        Select languageSelect = new Select(driver.findElement(languages));
        languageSelect.selectByValue(language.toString());

        DriverSupporter.waitUntilVisible(languages);
        driver.findElement(confirm).click();
    }
}
