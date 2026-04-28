package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{

	WebDriver driver;

	@BeforeClass(groups= {"Sanity","Functional","Regression"})
	void setup()
	{
		//Webdriver initialization
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Functional","Regression"})
	void tearDown()
	{
		//Close WebPage
		driver.close();
	}
	
	//user defined function for Email
		@SuppressWarnings("deprecation") //@SuppressWarnings is not a test Annotation it is because of the method
		public String randomString()
		{
			 String random_Str = RandomStringUtils.randomAlphabetic(8);
			 return random_Str;
		}
		
		
		//user defined function for Phone number
		@SuppressWarnings("deprecation")
		public String randomNum()
		{
			
			 String random_Num = RandomStringUtils.randomNumeric(10);
			 return random_Num;
		}
		
		
		//user defined function for password 
		@SuppressWarnings("deprecation")
		public String randomAlphaNumeric()
		{
			String random_Str = RandomStringUtils.randomAlphabetic(4);
			String random_Num = RandomStringUtils.randomNumeric(4);
			return(random_Str+"@"+random_Num);
		}
		
		
		//user defined function to capture Screenshot
		public String captureScreen(String test_name) // Method name
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.ss").format(new Date()); // Time stamp for File name
			
			TakesScreenshot ts = (TakesScreenshot)driver; // TakesScreenShot is a Predefined class - Initializing object for the class
			
			File sourcefile = ts.getScreenshotAs(OutputType.FILE);// Initializing an Empty File
			
			String targetfilepath = System.getProperty("user.dir")+"\\screenshots\\"+test_name+"__"+timeStamp; //Path and Name of the Screenshot in String
			
			File Target_File = new File(targetfilepath);// Creating the file with the path and name 
			
			sourcefile.renameTo(Target_File); //replacing the Screenshot with the empty File 
			
			return targetfilepath; // returning the File name and path
			
		}
		
		
		
}
