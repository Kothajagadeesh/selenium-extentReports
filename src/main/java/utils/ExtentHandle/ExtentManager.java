package utils.ExtentHandle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentTest extentTest;
    public ExtentReports extentReports;
    public static String currentDir = System.getProperty("user.dir");
    public static String reportDir = "/reports/";
    public static String fileName = "extent3_";

    private static String generateHtml() {
        return Long.toString(System.currentTimeMillis());
    }


    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(currentDir + reportDir + fileName + generateHtml() + ".html");
        }
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation-reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Selenium-Reports");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
