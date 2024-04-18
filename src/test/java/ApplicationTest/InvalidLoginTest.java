package ApplicationTest;

import Application.Login.LoginPage;
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

public class InvalidLoginTest {
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
    public void execute() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(2000);

            loginPage.username(credentials.get(1).getUserName());
            loginPage.password(credentials.get(1).getPassword());
            loginPage.clickLoginButton();
            Thread.sleep(2000);

            // Add logging for successful login attempt
            logger.info("Logged in with invalid credentials.");

            // Capture screenshot for the login attempt
            captureScreenshot("invalid_login_attempt");
        } catch (Exception e) {
            // Add logging for any exceptions during login attempt
            logger.error("Error: " + e.getMessage());

            // Capture screenshot for the error scenario
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
