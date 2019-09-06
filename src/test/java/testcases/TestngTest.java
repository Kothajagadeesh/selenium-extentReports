package testcases;

import org.testng.annotations.Test;
import utils.Listeners.TestNGListeners;


public class TestngTest {

    TestNGListeners testNGListeners = new TestNGListeners();

    @Test
    public void test2() {
        testNGListeners.AssertFailAndContinue(true, "validating true");
        testNGListeners.AssertFailAndContinue(false, "validating false");
        testNGListeners.AssertFailAndContinue(true, "validating true");
    }
}
