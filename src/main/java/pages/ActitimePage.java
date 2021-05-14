package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page model for the Actitime start page.
 */
public class ActitimePage {
    private WebDriver driver;

    // URL to the page.
    private static final String URL = "https://www.actitime.com/";

    // Anchor to the try free page.
    private By byTryFreeNav = By.linkText("Try Free");

    /**
     * Creates a new page model for the Actitime website.
     * @param driver The driver to use.
     */
    public ActitimePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to the page and returns an instance of the Acititime Page.
     * @param driver The driver to use.
     * @return Returns an instance of the Actitime page.
     */
    public static ActitimePage get(WebDriver driver) {
        driver.get(URL);
        return new ActitimePage(driver);
    }

    /**
     * Navigates to the Try Free page.
     * @return Instance of the Try Free page model.
     */
    public TryFreePage navigateTryFree() {
        driver.findElement(byTryFreeNav).click();
        return new TryFreePage(driver);
    }

    public class TryFreePage {
        private WebDriver driver;

        private By byFirstName = By.id("first-name");
        private By byLastName = By.id("last-name");
        private By byEmail = By.id("email");
        private By byCompany = By.id("company");

        /**
         * Creates a page model for the Try Free page.
         * @param driver The driver to use.
         */
        public TryFreePage(WebDriver driver) {
            this.driver = driver;
        }

        /**
         * Fills out the form with the supplied first name.
         * @param firstName The first name to input into the form.
         */
        public void setFirstName(String firstName) {
            driver.findElement(byFirstName).sendKeys(firstName);
        }

        /**
         * Fills out the form with the supplied last name.
         * @param lastName The last name to input into the form/
         */
        public void setLastName(String lastName) {
            driver.findElement(byLastName).sendKeys(lastName);
        }

        /**
         * Fills out the form with the supplied email.
         * @param email The email to input into the form.
         */
        public void setEmail(String email) {
            driver.findElement(byEmail).sendKeys(email);
        }

        /**
         * Fills out the form with the supplied company.
         * @param company The company name to input into the form.
         */
        public void setCompany(String company) {
            driver.findElement(byCompany).sendKeys(company);
        }
    }
}
