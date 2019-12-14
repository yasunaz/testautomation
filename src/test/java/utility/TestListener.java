package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

   // These are private fields that is responsible
   // for holding report creatinog object
   private ExtentReports extent;             // desk
   private ExtentHtmlReporter htmlReporter;  // paper
   private ExtentTest test;                  // pen

   // ===== ABOUT TEST ===============//
   public void onStart(ITestContext iTestContext) {
      extent = new ExtentReports();

      // preparing report paper
      String reportPath = System.getProperty("user.dir") + "/src/test/resources/reports/Result.html";
      htmlReporter = new ExtentHtmlReporter(reportPath);
      htmlReporter.config().setDocumentTitle("Innovation Agile Test Execution Result");
      htmlReporter.config().setReportName("Test Automation");
      htmlReporter.config().setTheme(Theme.STANDARD);

      // paper is done, put it on the test
      extent.attachReporter(htmlReporter);
   }

   public void onFinish(ITestContext iTestContext) {
      extent.flush();
   }


   // ===== ABOUT TEST CASES ===============//
   public void onTestStart(ITestResult testcase) {
      String name = testcase.getName();
      test =  extent.createTest(name);
   }

   public void onTestSuccess(ITestResult result) {
      // test case execution was success
      test.log(Status.PASS, "Test Case Has Passed!");
   }

   public void onTestFailure(ITestResult result) {
      // test case execution was failure
      test.log(Status.FAIL, "Test Case Has Failed!");
   }

   public void onTestSkipped(ITestResult result) {
      // test case execution was skipped
      test.log(Status.SKIP, "Test Case Has Failed!");
   }

   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
      // TO-DO: do not implement
   }

}
