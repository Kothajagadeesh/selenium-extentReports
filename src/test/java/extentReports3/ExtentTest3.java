package extentReports3;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestNgListener3;


@Listeners(TestNgListener3.class)
public class ExtentTest3 {
    TestNgListener3 testNgListener3 = new TestNgListener3();

    @Test
    public void test1() {
        System.out.println("ff");
        testNgListener3.AssertFailAndContinue(1 == 1, "checking in build assertion");
    }


    @Test
    public void test2() {
        System.out.println("bb");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 1, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
        testNgListener3.AssertFailAndContinue(1 == 2, "checking in build assertion");
    }


}
