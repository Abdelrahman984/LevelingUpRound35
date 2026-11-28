package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task04FirefoxSearchTest extends BaseTest {
    @Override
    protected String getBrowser() {
        return "firefox";
    }

    @Test
    public void verifyFirefoxFourthResult() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.cssSelector("textarea[name='q']"));
        searchInput.clear();
        searchInput.sendKeys("TestNG", Keys.ENTER);

        By organicResultLinks = By.cssSelector("ol.react-results--main > li[data-layout='organic'] a[data-testid='result-title-a']");
        List<WebElement> results = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(organicResultLinks, 3)
        );

        String fourthResultText = results.get(3).getText();
        Assert.assertEquals(fourthResultText, "TestNG Tutorial");
    }
}