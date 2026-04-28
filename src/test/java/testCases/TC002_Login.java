package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Login_page;

public class TC002_Login extends BaseClass{
	
	HomePage hp;
	Login_page lp;
	
	@Test(priority=1,groups={"Sanity","Regression"})
	public void Login()
	{
		//object for homepage
		hp = new HomePage(driver);
		hp.clickmyAccount(); //clicking myaccount from homepage
		hp.clickLogin(); // clicking login link from Homepage
		
		//object for Login page
		lp = new Login_page(driver);
		
		//enter login ID and Password 
		lp.setUsrname("infantajay15@gmail.com");
		lp.setPassword("qwertyuiop");
		
		//click on login
		lp.ClickLogin();// clicking login button
		
		//getting the Message
		String login_msg = lp.LoginMsg();
		Assert.assertEquals(login_msg, "My Account");
		
	}
	
	@Test(priority=2,dependsOnMethods = "Login")
	public void Logout()
	{
		hp.clickmyAccount();
		lp.clickLogout();
		
	}
	

}
