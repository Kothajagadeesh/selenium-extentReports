package utils;

import com.aventstack.extentreports.Status;
import org.testng.*;

public class TestNgListener3 extends ExtentManager implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
    }

    public void onFinish(ISuite suite) {
    }

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.INFO, "Test Started");
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, result.getName() + " Passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, result.getName() + " Failed");
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getName() + " Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        extentReports = ExtentManager.getInstance();
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public void AssertFailAndContinue(boolean result, String description) {
        try {
            if (result) {
                extentTest.log(Status.PASS, description);
            } else {
                extentTest.log(Status.FAIL, description);
                ITestResult result1= Reporter.getCurrentTestResult();
                result1.setStatus(2);
            }
        } catch (Exception e) {
        }
    }
}
