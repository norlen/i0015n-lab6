package tests.remote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import shared.Utility;
import tests.pagemodels.Activity2PageModel;

public class Activity2Remote {
    @DisplayName("Actitime Try Free")
    @ParameterizedTest(name = "Actitime Try Free [{index}] ==> {0}")
    @ValueSource(strings = { BrowserType.CHROME, BrowserType.EDGE, BrowserType.FIREFOX, BrowserType.OPERA })
    public void actitimeTimeTryFree(String browser) throws Exception {
        WebDriver driver = Utility.getRemoteDriver(browser);
        try {
            Activity2PageModel.testTryFree(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }
}
