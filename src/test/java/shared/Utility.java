package shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Utility {
    public final static String GridURL;

    static {
        String url = System.getenv("TEST_URL");
        if (url == null) {
            GridURL = "http://localhost:4444";
        } else {
            GridURL = url;
        }
    }

    public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver = null;
        switch (browser) {
            case BrowserType.CHROME: {
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case BrowserType.FIREFOX: {
                System.setProperty("webdriver.gecko.driver", "./drivers/msedgedriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            case BrowserType.EDGE: {
                System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            }
            case BrowserType.OPERA: {
                throw new Exception("No driver currently available locally for Opera.");
            }
            default: {
                throw new Exception("Browser not supported");
            }
        }
        return driver;
    }

    public static WebDriver getRemoteDriver(String browser) throws Exception {
        URL url = new URL(GridURL);
        WebDriver driver = null;
        switch (browser) {
            case BrowserType.CHROME: {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(url, options);
                break;
            }
            case BrowserType.FIREFOX: {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(url, options);
                break;
            }
            case BrowserType.EDGE: {
                EdgeOptions options = new EdgeOptions();
                driver = new RemoteWebDriver(url, options);
                break;
            }
            case BrowserType.OPERA: {
                // For Grid we currently have the non-blink Opera, which means we cannot use `OperaOptions` as that
                // expects the blink version.
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.OPERA);
                driver = new RemoteWebDriver(url, cap);
                break;
            }
            default: {
                throw new Exception("Browser not supported");
            }
        }
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
