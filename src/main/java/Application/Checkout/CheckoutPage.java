package Application.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private final WebDriver driver;

    // Locators
    private final By firstNameInput = By.xpath("//*[@id=\"first-name\"]");
    private final By lastNameInput = By.xpath("//*[@id=\"last-name\"]");
    private final By zipCodeInput = By.xpath("//*[@id=\"postal-code\"]");
    private final By continueButton = By.xpath("//input[@type='submit']");
    private final By finishButton = By.xpath("//*[@id=\"finish\"]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to enter personal details and continue
    public void enterFirstName() {
        WebElement firstNameElement = driver.findElement(firstNameInput);
        firstNameElement.sendKeys("Tumelo");
    }
    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameInput);
        lastNameElement.sendKeys("Lebogo");
    }

    public void enterZipCode(String zipCode) {
        WebElement zipCodeElement = driver.findElement(zipCodeInput);
        zipCodeElement.sendKeys("2090");
    }

    public void clickContinue() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        continueButtonElement.click();
    }

    public void clickFinish() {
        WebElement finishButtonElement = driver.findElement(finishButton);
        finishButtonElement.click();
    }
}
