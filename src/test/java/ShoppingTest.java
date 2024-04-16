package AddItem;

import Application.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ShoppingTest {

        private WebDriver driver;
        protected HomePage homePage;
            public void setUp() {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Brino\\Idea Projects\\webdriver_java\\src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get("https://shop.demoqa.com/");

                homePage = new HomePage(driver);

            driver.close();
            }
}