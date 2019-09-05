package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class SampleTest {


    public static void main(String[] args) throws IOException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/sample.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("my sample test", "sample desc");
        test.log(Status.INFO, "this step shows");
        test.info("this step shows usage of info");
        test.pass("script passed");
        extent.flush();
        ExtentTest test1 = extent.createTest("my sample test", "sample desc");
        //one way of attaching a screenshot from fail
        test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("sc.png").build());
        // second way of attachind screenshot
        //test1.addScreenCaptureFromPath("sc.png");
        extent.flush();
    }

}
