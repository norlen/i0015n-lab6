package tests.remote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import shared.Utility;
import tests.pagemodels.Activity3PageModel;

public class Activity3Remote {
    @DisplayName("Adlibris checkout book")
    @ParameterizedTest(name = "Adlibris checkout book [{index}] ==> {0}")
    @ValueSource(strings = { BrowserType.CHROME, BrowserType.EDGE, BrowserType.FIREFOX, BrowserType.OPERA })
    public void adlibrisBuyCourseBook(String browser) throws Exception {
        WebDriver driver = Utility.getRemoteDriver(browser);
        try {
            Activity3PageModel.testAdlibris(driver);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw e;
        }
    }
}
