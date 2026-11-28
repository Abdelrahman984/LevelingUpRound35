package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task05DuckDuckGoSecondResultTest extends BaseTest {
    @Test
    public void verifyDuckDuckGoSecondResult() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.cssSelector("textarea[name='q']"));
        searchInput.clear();
        searchInput.sendKeys("Cucumber IO", Keys.ENTER);

        By organicResultLinks = By.cssSelector("ol.react-results--main > li[data-layout='organic'] a[data-testid='result-title-a']");
        List<WebElement> results = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(organicResultLinks, 1)
        );

        String secondResultLink = results.get(1).getDomAttribute("href");
        Assert.assertTrue(
                secondResultLink != null && secondResultLink.contains("https://www.linkedin.com"),
                "Expected second result link to contain 'https://www.linkedin.com', but found: " + secondResultLink
        );
    }
}