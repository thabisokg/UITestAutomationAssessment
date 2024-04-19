package Application.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private final WebDriver driver;
    private final By addToCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");

    private final By addToBasketButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");

    private final By menuIcon = By.id("react-burger-menu-btn");

    private final By logoutButton = By.id("logout_sidebar_link");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickAddToBasket(){ driver.findElement(addToBasketButton).click(); }


    public void clickMenuIcon() {
        driver.findElement(menuIcon).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}