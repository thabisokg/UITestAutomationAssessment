package Application.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By productItem = By.xpath("//div[@class='product-item']");
    private By addToCartButton = By.xpath("//button[@class='add-to-cart-button']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        driver.findElement(productItem).click(); // Example, replace with actual logic
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Other methods as needed for products functionality
}
