package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task03DuckDuckGoFirstResultTest extends BaseTest {
    @Test
    public void VerifyDuckDuckGoFirstResultTest() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.cssSelector("textarea[name='q']"));
        searchInput.clear();
        searchInput.sendKeys("Selenium WebDriver");
        searchInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
        WebElement firstResultLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("ol.react-results--main > li[data-layout='organic'] a[data-testid='result-title-a']")
                )
        );
        String actualUrl = firstResultLink.getDomAttribute("href");
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
