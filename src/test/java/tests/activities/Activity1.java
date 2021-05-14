package tests.activities;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import shared.Utility;

/**
 * Activity 1: Write a class to do a Google Search, for the phrase "Software Testing".
 */
public class Activity1 {
    private final static String URL = "https://www.google.com/";
    private final static String SearchString = "Software Testing";

    @Test
    public void googleSearch() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        driver.get(URL);
        driver.findElement(By.id("L2AGLb")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(SearchString);
        searchBox.submit();
        driver.quit();
    }
}
