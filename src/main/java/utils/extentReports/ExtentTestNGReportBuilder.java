package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ExtentTestNGReportBuilder {

    private static ExtentReports extentReports;
    private static ThreadLocal parentTest = new ThreadLocal();
    private  static ThreadLocal test = new ThreadLocal();

//    @BeforeSuite
    public void beforeSuite(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/extent.html");
        extentReports.attachReporter(htmlReporter);
    }

//    @BeforeClass
    public synchronized void beforeClass(){
        ExtentTest parent = extentReports.createTest(getClass().getName());
        parentTest.set(parent);
    }

//    @BeforeMethod
    public synchronized void beforeMethod(){
//        ExtentTest child = parentTest.get()
    }
}
