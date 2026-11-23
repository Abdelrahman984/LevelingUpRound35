package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task01_DuckDuckGoTitleTest extends BaseTest {
    @Test
    public void verifyDuckDuckGoPageTitle(){
        driver.get("https://duckduckgo.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }
}
