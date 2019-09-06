package extentReports3;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.Listeners.TestNgListener3;

public class ExtentTest3 {
    TestNgListener3 testNgListener3 = new TestNgListener3();

    @BeforeClass
    public void beforeClass() {
        System.out.println("checking before class in " + getClass().toString());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Checking after class " + getClass().toString());
    }

    @Test
    public void test1() {
        System.out.println("ff");
        testNgListener3.logWarning("This method is for entering warning message");
        testNgListener3.AssertFailAndContinue(1 == 1, "checking Test1 assertion passed");
        testNgListener3.logInfo("this step is to enter info for information purpose");
    }


    @Test
    public void test2() {
        System.out.println("bb");
        testNgListener3.logInfo("the follwoing step intenationally failed");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 1, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
    }


}
