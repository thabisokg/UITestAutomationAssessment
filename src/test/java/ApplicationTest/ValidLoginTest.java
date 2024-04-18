package ApplicationTest;

import Application.Cart.CartPage;
import Application.Checkout.CheckoutPage;
import Application.Confirmation.ConfirmationPage;
import Application.Login.LoginPage;
import Application.Products.ProductsPage;
import Utilities.BrowserUtils;
import Utilities.Credential;
import com.poiji.bind.Poiji;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class ValidLoginTest {
    private static final Logger logger = LogManager.getLogger(InvalidLoginTest.class);
    private WebDriver driver;
    private List<Credential> credentials;

    @BeforeClass
    public void setUp() {
        driver = BrowserUtils.initializeDriver("edge");
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        credentials = loadCredentials("Credentials.xlsx");
    }

    @Test
    public void testLoginAddItemToCart() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(2000);

            loginPage.username(credentials.get(0).getUserName());
            loginPage.password(credentials.get(0).getPassword());
            loginPage.clickLoginButton();
            Thread.sleep(2000);

            logger.info("Logged in successfully.");
            captureScreenshot("login_success");

            ProductsPage productsPage = new ProductsPage(driver);
            productsPage.clickAddToCart();
            Thread.sleep(2000);
            productsPage.clickMenuIcon();
            Thread.sleep(2000);
            productsPage.clickLogoutButton();
            Thread.sleep(2000);

            logger.info("Logged out successfully.");
            captureScreenshot("logout_success");

        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            captureScreenshot("error_" + System.currentTimeMillis());
        }
    }

    @Test
    public void testLoginAddProductCheckOut() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(2000);

            loginPage.username(credentials.get(0).getUserName());
            loginPage.password(credentials.get(0).getPassword());
            loginPage.clickLoginButton();
            Thread.sleep(2000);
            logger.info("Logged in successfully.");

            ProductsPage productsPage = new ProductsPage(driver);
            productsPage.clickAddToBasket();
            Thread.sleep(2000);

            CartPage cartPage = new CartPage(driver);
            cartPage.clickCartIcon();
            Thread.sleep(2000);
            cartPage.clickCheckoutButton();
            logger.info("Added product to cart.");
            captureScreenshot("add_to_cart_success");

        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            captureScreenshot("error_" + System.currentTimeMillis());
        }
    }

    @Test
    public void testCheckout() {
        try {
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            Thread.sleep(6000);

            checkoutPage.enterFirstName();
            checkoutPage.enterLastName("Lebogo");
            checkoutPage.enterZipCode("2090");
            checkoutPage.clickContinue();
            checkoutPage.clickFinish();
            logger.info("Order placed successfully.");
            captureScreenshot("order_placed");
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            captureScreenshot("error_" + System.currentTimeMillis());
        }
    }

    @Test
    public void testConfirmationPage() {
        try {
            ConfirmationPage confirmationPage = new ConfirmationPage(driver);
            Thread.sleep(2000);

            boolean isOrderPlaced = confirmationPage.isOrderConfirmed();
            if (isOrderPlaced) {
                logger.info("Thank you for your order!");
                captureScreenshot("order_confirmation");
            } else {
                logger.error("Thank you for your order! message not displayed.");
                captureScreenshot("order_confirmation_missing");
            }
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            captureScreenshot("error_" + System.currentTimeMillis());
        }
    }

    @AfterClass
    public void tearDown() {
        BrowserUtils.quitDriver(driver);
    }

    private List<Credential> loadCredentials(String excelFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(excelFile);
        assert resource != null;

        return Poiji.fromExcel(new File(resource.getPath()), Credential.class);
    }

     private void captureScreenshot(String screenshotName) {
        BrowserUtils.captureScreenshot(driver, screenshotName);
    }
}
