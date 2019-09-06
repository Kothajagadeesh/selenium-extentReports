package utils.ExtentHandle;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentManagerLoadXml {

    private static ExtentReports extent;
    public static ExtentTest test;
    public ExtentReports rep;
    public static String currentDir = System.getProperty("user.dir");
    public static String reportDir = "/reports/";
    public static String fileName = "extent2_";

    private static String generateHtml() {
        return Long.toString(System.currentTimeMillis());
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports(currentDir + reportDir + fileName + generateHtml() + ".html", false, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(currentDir + "/src/main/resources/ReportsConfig.xml"));
        }
        return extent;
    }
}
