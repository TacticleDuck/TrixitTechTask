package pageobjects.homepage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.enums.Nationals;

public class HomePage {
    private final WebDriver driver;

    private final String url = "https://www.post.ch/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open localized: " + url)
    public void goToSwissPost(Nationals preferredLanguage) {
        driver.get(url + preferredLanguage.toLowerCase());
    }
}
