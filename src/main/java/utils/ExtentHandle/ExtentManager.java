package utils.ExtentHandle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;
    public ExtentReports extentReports;
    public static String currentDir = System.getProperty("user.dir");
    public static String reportDir = "/reports/";
    public static String fileName = "extent3_";

    private static String generateHtml() {
        return Long.toString(System.currentTimeMillis());
    }


    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(currentDir + reportDir + fileName + ".html");
        }
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM); // chart location - top, bottom
        htmlReporter.config().setTheme(Theme.STANDARD); // theme - standard, dark
        htmlReporter.config().setDocumentTitle("Automation-reports"); // report title
        htmlReporter.config().setEncoding("UTF-8"); //// encoding, default = UTF-8
        htmlReporter.config().setReportName("Selenium-Reports");
        htmlReporter.config().setProtocol(Protocol.HTTPS); // protocol (http, https)
        //htmlReporter.setAppendExisting(true); //To apped reports to existing html file
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
