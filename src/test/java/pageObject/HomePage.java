package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//All page object classes should be Extended from Base Page(Because Base page consists of Constructor)
public class HomePage extends BasePage
{

		//constructor
		public HomePage(WebDriver driver) 
		{
			super(driver);
		}
	
		//Web Elements 
		@FindBy(xpath="//a[@title='My Account']") WebElement link_myAccount;
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement link_Register;
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement link_login;
		
		
		//Action Methods
		public void clickmyAccount()
		{
			link_myAccount.click();
		}
		
		public void clickRegister()
		{
			link_Register.click();
		}
		
		public void clickLogin()
		{
			link_login.click();
		}

}
