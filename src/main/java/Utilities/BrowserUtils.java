package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class BrowserUtils {

    public static WebDriver initializeDriver(String browserType) {
        WebDriver driver = null;
        switch (browserType.toLowerCase()) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Unsupported browser type!");
        }
        return driver;
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = "src/main/java/Screenshots/" + screenshotName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            System.out.println("Screenshot captured: " + screenshotName);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver closed.");
        }
    }
}
