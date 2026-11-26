package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task02DuckDuckGoLogoTest extends BaseTest {

    @Test
    public void verifyDuckDuckGoLogoIsDisplayed() {
        driver.get("https://duckduckgo.com/");

        // Targets <svg aria-label="DuckDuckGo"> nested inside <a aria-label="Learn about DuckDuckGo">.
        By logoLocator = By.cssSelector("a[aria-label='Learn about DuckDuckGo'] svg[aria-label='DuckDuckGo']");

        // Wait up to 10 seconds for all responsive logo variants to load into the DOM
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(logoLocator));

        // Verify that at least one of the matched SVG variants (inline or horizontal) is visible on screen
        boolean isAnyLogoDisplayed = logos.stream().anyMatch(WebElement::isDisplayed);

        Assert.assertTrue(isAnyLogoDisplayed, "DuckDuckGo logo is not displayed");
    }
}