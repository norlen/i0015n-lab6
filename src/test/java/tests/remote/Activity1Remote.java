package tests.remote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import shared.Utility;
import tests.pagemodels.Activity1PageModel;

public class Activity1Remote {
    @DisplayName("Google Search")
    @ParameterizedTest(name = "Google Search [{index}] ==> {0}")
    @ValueSource(strings = { BrowserType.CHROME, BrowserType.EDGE, BrowserType.FIREFOX, BrowserType.OPERA })
    public void googleSearch(String browser) throws Exception {
        WebDriver driver = Utility.getRemoteDriver(browser);
        try {
            Activity1PageModel.testSearch(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }
}
