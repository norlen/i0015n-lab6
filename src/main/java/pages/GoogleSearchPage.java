package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Initial www.google.com search page.
 */
public class GoogleSearchPage {
    private WebDriver driver;

    // URL to google.
    private final static String URL = "https://www.google.com/";

    // Search box element.
    private By searchBox = By.name("q");

    // Accept policy button.
    private By acceptCookiesButton = By.id("L2AGLb");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the web page and returns the page model.
     * @param driver driver to use.
     * @return constructed page model ready to be used.
     */
    public static GoogleSearchPage get(WebDriver driver) {
        driver.get(URL);
        return new GoogleSearchPage(driver);
    }

    /**
     * Accepts the usage of cookies.
     */
    public void acceptCookies() {
        driver.findElement(acceptCookiesButton).click();
    }

    /**
     * Sends input to the search query box.
     * @param query the string to input into the search query.
     */
    public void inputSearchQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    /**
     * Submits the search query.
     */
    public void submitSearchQuery() {
        driver.findElement(searchBox).submit();
    }

    /**
     * Checks if the accept cookies button exists.
     * @return True if the accept cookie button exists.
     */
    public boolean acceptCookiesExists() {
        return driver.findElements(acceptCookiesButton).isEmpty() == false;
    }
}
