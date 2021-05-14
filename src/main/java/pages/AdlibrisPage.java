package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page model for the Adlibris start page.
 */
public class AdlibrisPage {
    private WebDriver driver;

    // URL to website.
    private final static String URL = "https://adlibris.com/se/";

    // Search box element.
    private By searchBox = By.id("q");

    /**
     * Creates a new Adlibris page model.
     * @param driver The driver to use.
     */
    public AdlibrisPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to page url and returns an instance of the Adlibris page model.
     * @param driver The driver to use.
     * @return Returns an instance of the Adlibris page model.
     */
    public static AdlibrisPage get(WebDriver driver) {
        driver.get(URL);
        return new AdlibrisPage(driver);
    }

    /**
     * Inputs a query into the search box.
     * @param query The product to search for.
     */
    public void inputSearch(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    /**
     * Submits the search query.
     * @return Instance of the search results page.
     */
    public SearchResultPage submitSearch() {
        driver.findElement(searchBox).submit();
        return new SearchResultPage(driver);
    }

    /**
     * Page model for the search results page.
     */
    public class SearchResultPage {
        private WebDriver driver;

        private By productLink = By.cssSelector(".search-result__product__name:nth-child(1)");

        /**
         * Creates a new search result page.
         * @param driver The driver to use.
         */
        SearchResultPage(WebDriver driver) {
            this.driver = driver;
        }

        /**
         * Clicks a link to a product.
         * @param product Which product link to click.
         * @return Instance of the product page for the product which was clicked.
         */
        public ProductPage clickProduct() {
            driver.findElement(productLink).click();
            return new ProductPage(driver);
        }

        /**
         * Clicks a link to a product.
         * @param product Which product link to click.
         * @return Instance of the product page for the product which was clicked.
         */
        public ProductPage clickProduct(String name) {
            driver.findElement(By.linkText(name)).click();
            return new ProductPage(driver);
        }
    }

    /**
     * Page model for the product page.
     */
    public class ProductPage {
        private WebDriver driver;

        private By addToCartButton = By.cssSelector(".product__add-to-cart:nth-child(1)");
        private By toCheckoutButton = By.linkText("Till kassan");

        /**
         * Creates a new product page model.
         * @param driver The driver to use.
         */
        ProductPage(WebDriver driver) {
            this.driver = driver;
        }

        /**
         * Presses the add to cart button.
         */
        public void addToCart() {
            driver.findElement(addToCartButton).click();
        }

        /**
         * Toggles the cart and heads to the checkout page.
         */
        public void toCheckout() {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(toCheckoutButton));

            driver.findElement(toCheckoutButton).click();
        }
    }
}
