package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/ExtentReport.html");

            // Report Customization
            spark.config().setReportName("OrangeHRM Automation Execution Report");
            spark.config().setDocumentTitle("Automation Test Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            // System Information
            extent.setSystemInfo("Tester", "Priya");
            extent.setSystemInfo("Project", "OrangeHRM");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        }

        return extent;
    }
}