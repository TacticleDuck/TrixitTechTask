package util;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@UtilityClass
public class DriverSupporter {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return driver;
    }

    public void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilPresenceOfElementLocated(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForNestedShadowElement(By... selectors) {
        return wait.until(d -> {
            SearchContext context = getDriver();
            WebElement elem = null;

            for (int i = 0; i < selectors.length; i++) {
                elem = context.findElement(selectors[i]);

                if (i < selectors.length - 1) {
                    context = elem.getShadowRoot();
                }
            }

            return (elem != null && elem.isDisplayed()) ? elem : null;
        });
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
