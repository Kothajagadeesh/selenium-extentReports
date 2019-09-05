package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestNgListeners.MyTestListeners;
import utils.base.BaseClass;

import java.lang.reflect.Method;

@Listeners(MyTestListeners.class)
public class UsingITestngListeners extends BaseClass {

    @BeforeClass
    public void setup() {
        setupExtentReports();
    }

    @BeforeMethod
    public void init(Method method) {

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
    public void flush() {

    }

    @AfterClass
    public void disconnect() {
    }
}
