package tests.activities;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shared.Utility;

public class Activity3 {
    private final static String URL = "https://adlibris.com/se/";
    private final static String searchQuery = "praktisk mjukvarutestning";

    @Test
    public void adlibrisBuyCourseBook() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        driver.get(URL);
        WebElement searchBox = driver.findElement(By.id("q"));
        searchBox.sendKeys(searchQuery);
        searchBox.submit();
        driver.findElement(By.linkText("Praktisk mjukvarutestning")).click();
        driver.findElement(By.className("product__add-to-cart")).click();
        driver.findElement(By.className("page-header__toggler--cart")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Till kassan")));
        driver.findElement(By.linkText("Till kassan")).click();
        driver.quit();
    }
}
