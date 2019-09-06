package testcases;

import org.testng.annotations.Test;
import utils.Listeners.TestNGListeners;


public class TestngTest1 {
    TestNGListeners testNGListeners = new TestNGListeners();
    @Test
    public void test3() {
        testNGListeners.AssertFailAndContinue(true,"validating true");
        testNGListeners.AssertFailAndContinue(true,"validating true");
    }

    @Test
    public void test4() {
        testNGListeners.AssertFailAndContinue(true,"validating true");
        testNGListeners.AssertFailAndContinue(true,"validating true");
    }
}
