package Application.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    private final By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    private final By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartIcon(){ driver.findElement(cartIcon).click();}
    public void clickCheckoutButton(){ driver.findElement(checkoutButton).click(); }
    // Other methods as needed for cart functionality
}
