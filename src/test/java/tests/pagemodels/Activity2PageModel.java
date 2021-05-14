package tests.pagemodels;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.ActitimePage;
import shared.Utility;

public class Activity2PageModel {

    @DisplayName("Actitime Try Free")
    @Test
    public void actitimeTimeTryFree() throws Exception {
        WebDriver driver = Utility.getDriver(BrowserType.CHROME);
        try {
            testTryFree(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }

    public static void testTryFree(WebDriver driver) throws InterruptedException {
        ActitimePage startPage = ActitimePage.get(driver);
        ActitimePage.TryFreePage page = startPage.navigateTryFree();

        // Have to wait for the page to become responsive before filling in. The WebDriverWait does not work for this
        // case for some reason.
        Thread.sleep(2000);

        page.setFirstName("hello");
        page.setLastName("world");
        page.setEmail("helloworld@student.ltu.se");
        page.setCompany("none");
        driver.quit();
    }
}
