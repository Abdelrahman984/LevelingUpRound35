package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task02DuckDuckGoLogoTest extends BaseTest {
    @Test
    public void verifyDuckDuckGoLogoIsDisplayed() {
        driver.get("https://duckduckgo.com/");
        WebElement logo = driver.findElement(By.cssSelector("img[alt='DuckDuckGo']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
    }
}
