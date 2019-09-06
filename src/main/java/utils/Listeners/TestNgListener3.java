package utils.Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.*;
import utils.ExtentHandle.ExtentManager;

public class TestNgListener3 extends ExtentManager implements ITestListener, ISuiteListener, IClassListener {

    public synchronized void onStart(ISuite suite) {
    }

    public synchronized void onFinish(ISuite suite) {
    }

    public synchronized void onTestStart(ITestResult result) {
        childTest = parentTest.createNode(result.getName());
        childTest.log(Status.INFO, "Test Started");
    }

    public synchronized void onTestSuccess(ITestResult result) {
        childTest.log(Status.PASS, result.getName() + " Passed");
        childTest.log(Status.INFO, result.getName() + " Ended");
    }

    public synchronized void onTestFailure(ITestResult result) {
        childTest.log(Status.FAIL, result.getName() + " Failed");
        childTest.log(Status.INFO, result.getName() + " Ended");
    }

    public synchronized void onTestSkipped(ITestResult result) {
        childTest.log(Status.SKIP, result.getName() + " Skipped");
        childTest.log(Status.INFO, result.getName() + " Ended");
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public synchronized void onStart(ITestContext context) {
        extentReports = ExtentManager.getInstance();
    }

    public synchronized void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public synchronized void AssertFailAndContinue(boolean result, String description) {
        try {
            if (result) {
                childTest.log(Status.PASS, description);
            } else {
                childTest.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "/src/main/resources/17.png").build());
                ITestResult result1 = Reporter.getCurrentTestResult();
                result1.setStatus(2);
            }
        } catch (Exception e) {
        }
    }

    public synchronized void logInfo(String info) {
        childTest.log(Status.INFO, info);
        //we can attach screenshot if needed, see AssertFailAndContinue fail case
    }

    public synchronized void logWarning(String info) {
        childTest.log(Status.WARNING, info);
        //we can attach screenshot if needed, see AssertFailAndContinue fail case
    }

    public void onBeforeClass(ITestClass testClass) {
        parentTest = extentReports.createTest(testClass.getName());
    }

    public void onAfterClass(ITestClass testClass) {
    }
}
