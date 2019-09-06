package utils;

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


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance(System.getProperty("user.dir") + "/reports/html/extent3.html");
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Genentec-reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Genentec-Selenium-Reports");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
