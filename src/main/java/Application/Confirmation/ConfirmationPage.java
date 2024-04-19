package Application.Confirmation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private final WebDriver driver;

    // Locators
    private final By confirmationMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to verify order confirmation
    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}
