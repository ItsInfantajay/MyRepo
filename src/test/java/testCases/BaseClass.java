package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{

	WebDriver driver;

	@BeforeClass
	void setup()
	{
		//Webdriver initialization
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}
	
	@AfterClass
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
		
		
		
}
