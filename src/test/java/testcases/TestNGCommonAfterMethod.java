package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestNGCommonAfterMethod {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest extentTest;

    @BeforeClass
    public void setup() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/TestnCommonsAfterMethod.html");
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
        Assert.assertTrue(true);
    }

    @Test(priority = 1)
    public void failedTest() {
        extentTest.log(Status.INFO, "This line is for information purpose");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void flush(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass("Test cases passed");
        }
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            extentTest.fail("Test cases failed");
        }
        extent.flush();
    }

    @AfterClass
    public void disconnect() {
    }
}
