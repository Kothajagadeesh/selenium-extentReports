package utils.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest extentTest;


    public void setupExtentReports() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
}
