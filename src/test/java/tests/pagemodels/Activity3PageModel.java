package tests.pagemodels;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import pages.AdlibrisPage;
import shared.Utility;

public class Activity3PageModel {
    private final static String searchQuery = "praktisk mjukvarutestning";

    @DisplayName("Adlibris Buy Course Book")
    @Test
    public void adlibrisBuyCourseBook() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        try {
            testAdlibris(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }

    public static void testAdlibris(WebDriver driver) {
        AdlibrisPage startPage = AdlibrisPage.get(driver);
        startPage.inputSearch(searchQuery);
        AdlibrisPage.SearchResultPage resultsPage = startPage.submitSearch();

        AdlibrisPage.ProductPage productPage = resultsPage.clickProduct("Praktisk mjukvarutestning");
        productPage.addToCart();
        productPage.toCheckout();
        driver.quit();
    }
}
