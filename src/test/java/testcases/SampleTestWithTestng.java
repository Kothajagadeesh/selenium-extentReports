package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class SampleTestWithTestng {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest extentTest;

    @BeforeClass
    public void setup() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/extentTestng.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void init(Method method) {
        extentTest = extent.createTest(method.getName());
    }

    @Test(priority = 0)
    public void passedTest() {
        extentTest.log(Status.INFO, "This line is for information purpose");
        extentTest.pass("passed test checkup");
    }

    @Test(priority = 1)
    public void failedTest() {
        extentTest.log(Status.INFO, "This line is for information purpose");
        extentTest.fail("failed test checkup");
    }

    @Test(priority = 2)
    public void failedTestWithScreenshot() throws IOException {
        extentTest.log(Status.INFO, "This line is for information purpose");
        extentTest.fail("failed test with screenshot", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "/17.png").build());
    }

    @AfterMethod
    public void flush() {
        extent.flush();
    }

    @AfterClass
    public void disconnect() {
    }
}
