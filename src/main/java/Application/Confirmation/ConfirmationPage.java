package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;
    private By orderSuccessMessage = By.id("Add Confirmation message id");
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccessful(){
        return driver.findElement(orderSuccessMessage).isDisplayed();
    }

        //Add more methods for order confirmation as needed
}
