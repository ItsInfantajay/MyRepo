package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends BasePage{

	//constructor
	public Login_page(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//Storing WebElements 
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-password']")WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement	btn_login;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Login_msg;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement btn_logout;
	//Action Methods
	
	public void setUsrname(String username)
	{
		txt_email.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		btn_login.click();
	}
	
	public String LoginMsg()
	{
		String login_msg = Login_msg.getText();
		return login_msg;
	}
	
	public void clickLogout()
	{
		btn_logout.click();
	}


}
