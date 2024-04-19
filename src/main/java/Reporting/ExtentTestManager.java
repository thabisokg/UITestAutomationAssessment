package Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestManager {
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
    private static final ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return extentTestThreadLocal.get();
    }

    public static synchronized void startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestThreadLocal.set(test);
    }

    public static synchronized void logInfo(String message) {
        getTest().log(Status.INFO, message);
    }

    public static synchronized void logPass(String message) {
        getTest().pass(message);
    }

    public static synchronized void logFail(String message) {
        getTest().fail(message);
    }

    public static synchronized void endTest() {
        extent.flush();
    }
}