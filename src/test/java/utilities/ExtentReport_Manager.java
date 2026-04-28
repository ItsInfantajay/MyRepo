package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;


public class ExtentReport_Manager implements ITestListener
{
	
	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extent; //populate common info on the report
	public ExtentTest test; //creating test case entries in the report and update status of the test methods
	
	String Report_name;
	
	public void onStart(ITestContext context) 
	{
		
		SimpleDateFormat Df = new SimpleDateFormat("yyyy/MM.dd.HH.mm.ss");
		Date Dt = new Date();
		String currentDatetimeStamp = Df.format(Dt);
		//String currentDatetimeStamp_ = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		
		
	Report_name = "Test-Report-"+currentDatetimeStamp+".html"; //creating the report name with time stamp
	sparkReporter=new ExtentSparkReporter (System.getProperty("user.dir")+"\\reports\\"+Report_name);
	sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
	sparkReporter.config().setReportName("Functional Testing"); // name of the report
	sparkReporter.config().setTheme (Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter (sparkReporter);


	extent.setSystemInfo("Computer Name","localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("Tester Name", "Infant Ajay");
	extent.setSystemInfo("OS", "Windows10");
	extent.setSystemInfo("Browser name", "Chrome");
	
	}

	
	public void onTestSuccess(ITestResult result)
	{

	test = extent.createTest(result.getName()); // create a new enty in the report
	test.log(Status.PASS, "Test case PASSED is:" + result.getName());
	
	}


	public void onTestFailure(ITestResult result) 
	{

	test = extent.createTest(result.getName());
	test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
	test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	
	try 
	{
		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		
	}catch (Exception e) {
		e.printStackTrace();
	}

	}
	

	public void onTestSkipped(ITestResult result) 
	{

	test = extent.createTest(result.getName());
	test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	
	}
	
	public void onFinish(ITestContext context) 
	{
		System.out.println("Test Execution is Completed");
		extent.flush();
	}

}
