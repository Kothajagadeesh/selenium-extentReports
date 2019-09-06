package utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import utils.ExtentHandle.ExtentManagerLoadXml;

public class TestNGListeners extends ExtentManagerLoadXml implements ITestListener, ISuiteListener {
    public void onStart(ISuite suite) {
    }

    public synchronized void onFinish(ISuite suite) {
    }

    public synchronized void onTestStart(ITestResult result) {
        test = rep.startTest(result.getName());
        test.log(LogStatus.INFO, result.getName() + " started");
    }

    public synchronized void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getName() + " executed successfully");
        rep.endTest(test);
        rep.flush();
    }

    public synchronized void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Failed with Exception " + result.getThrowable());
        rep.endTest(test);
        rep.flush();
    }

    public synchronized void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " skipped with reason " + result.getThrowable());
        rep.endTest(test);
        rep.flush();
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public synchronized void onStart(ITestContext context) {
        rep = ExtentManagerLoadXml.getInstance();
    }

    public synchronized void onFinish(ITestContext context) {
    }

    public synchronized void AssertFailAndContinue(boolean result, String description) {
        try {
            if (result) {
                test.log(LogStatus.PASS, description);
            } else {
                test.log(LogStatus.FAIL, description);
                test.addScreenCapture(System.getProperty("user.dir")+"/src/main/resources/17.png");
                ITestResult result1 = Reporter.getCurrentTestResult();
                result1.setStatus(2);
            }
        } catch (Exception e) {
        }
    }
}
