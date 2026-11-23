package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task01_DuckDuckGoTitleTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void verifyDuckDuckGoPageTitle(){
        driver.get("https://duckduckgo.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null)
            driver.quit();
    }
}
