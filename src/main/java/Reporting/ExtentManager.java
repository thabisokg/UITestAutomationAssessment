package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("src/main/java/Reporting/spark.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        spark.config().setDocumentTitle("Extent Reports - Test Automation");
        spark.config().setReportName("Test Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;
    }
}
