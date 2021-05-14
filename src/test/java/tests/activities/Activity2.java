package tests.activities;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import shared.Utility;

public class Activity2 {
    private static final String URL = "https://www.actitime.com/";

    @Test
    public void actitimeTimeTryFree() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        driver.get(URL);
        driver.findElement(By.linkText("Try Free")).click();

        // Have to wait for the page to become responsive before filling in. The WebDriverWait does not work
        // for this case for some reason.
        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("hello");
        driver.findElement(By.id("last-name")).sendKeys("world");
        driver.findElement(By.id("email")).sendKeys("helloworld@student.ltu.se");
        driver.findElement(By.id("company")).sendKeys("none");
        driver.quit();
    }
}
