package utils.Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.*;
import utils.ExtentHandle.ExtentManager;

public class TestNgListener3 extends ExtentManager implements ITestListener, ISuiteListener {

    public synchronized void onStart(ISuite suite) {
    }

    public synchronized void onFinish(ISuite suite) {
    }

    public synchronized void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.INFO, "Test Started");
    }

    public synchronized void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, result.getName() + " Passed");
    }

    public synchronized void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, result.getName() + " Failed");
    }

    public synchronized void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getName() + " Skipped");
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public synchronized void onStart(ITestContext context) {
        extentReports = ExtentManager.getInstance();
    }

    public synchronized void onFinish(ITestContext context) {
        extentTest.log(Status.INFO, "Test Ended");
        extentReports.flush();
    }

    public synchronized void AssertFailAndContinue(boolean result, String description) {
        try {
            if (result) {
                extentTest.log(Status.PASS, description);
            } else {
                //extentTest.log(Status.FAIL, description);
                extentTest.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "/src/main/resources/17.png").build());
                ITestResult result1 = Reporter.getCurrentTestResult();
                result1.setStatus(2);
            }
        } catch (Exception e) {
        }
    }

    public synchronized void logInfo(String info) {
        extentTest.log(Status.INFO, info);
        //we can attach screenshot if needed, see AssertFailAndContinue fail case
    }

    public synchronized void logWarning(String info) {
        extentTest.log(Status.WARNING, info);
        //we can attach screenshot if needed, see AssertFailAndContinue fail case
    }
}
