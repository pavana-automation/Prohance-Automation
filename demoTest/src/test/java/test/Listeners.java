package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.RetryAnalyzer;

public class Listeners  extends TestListenerAdapter implements ITestListener {

	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	RetryAnalyzer retry = new RetryAnalyzer();

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---------------pass "+result.getMethod().getRetryAnalyzerClass());
		extentTest.get().log(Status.PASS, "Successfull");

	}
	
	public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		File file = new File(destpath);
		FileUtils.copyFile(source, file);
		return destpath;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		//WebDriver driver;
			extentTest.get().fail(result.getThrowable());
			/*Object testObject = result.getInstance();
			Class clazz = result.getTestClass().getRealClass();
			try {
				driver = (WebDriver) clazz.getDeclaredField("driver").get(testObject);
			} catch (Exception e) {
			}
			try {
				extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver),
						result.getMethod().getMethodName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();*/
			}

	public void testStepDescription(String Message) 
	{
		extentTest.get().log(Status.INFO, Message);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus() == ITestResult.SKIP)
		{
			if(result.wasRetried())
				extent.removeTest(test);
		}
		extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getName());
		test.skip(result.getThrowable());
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSkipped(result);
		// test.skip(null)
		// test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		// long endTime= System.currentTimeMillis();
		// System.out.println("Inform all the suite have finished execution at"+
		// endTime);
		extent.flush();
	}

}
