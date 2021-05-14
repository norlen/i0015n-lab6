package tests.pagemodels;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.GoogleSearchPage;
import shared.Utility;

/**
 * Activity 1: Write a class to do a Google Search, for the phrase "Software Testing".
 */
public class Activity1PageModel {
    private final static String SearchString = "Software Testing";

    @DisplayName("Google Search")
    @Test
    public void googleSearch() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        try {
            testSearch(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }

    public static void testSearch(WebDriver driver) throws Exception {
        GoogleSearchPage page = GoogleSearchPage.get(driver);
        if (page.acceptCookiesExists()) {
            page.acceptCookies();
        }
        page.inputSearchQuery(SearchString);
        page.submitSearchQuery();
    }
}
