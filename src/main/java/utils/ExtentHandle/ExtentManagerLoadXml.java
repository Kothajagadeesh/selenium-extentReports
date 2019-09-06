package utils.ExtentHandle;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentManagerLoadXml {

    private static ExtentReports extent;
    public static ExtentTest test;
    public ExtentReports rep;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") + "/reports/html/extent.html", false, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/ReportsConfig.xml"));
        }
        return extent;
    }
}
