package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//All page object classes should be Extended from Base Page(Because Base page consists of Constructor)
public class AccountRegistrationPage extends BasePage 
{

	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);// refering to the driver variable present in BasePage class(Inheritance)
	}
	
	
	//Web Elements
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_fName;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txt_lName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_phno;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Pword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_Cnf_Pword;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_bx;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Reg;
	@FindBy(xpath="//div[@id='content']//h1") WebElement reg_msg;


	//Action Methods
	public void setFirstName(String fname)
	{
		txt_fName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_lName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPhno(String phno)
	{
		txt_phno.sendKeys(phno);
	}
	
	public void setPassword(String pwd)
	{
		txt_Pword.sendKeys(pwd);
	}
	
	public void setCnf_Password(String pwd)
	{
		txt_Cnf_Pword.sendKeys(pwd);
	}
	
	public void clickPolicy()
	{
		chk_bx.click();
	}
	
	public void clickReg() 
	{
		btn_Reg.click();
	}

	public String getConfirmationMsg()
	{
		try 
		{
			String Conf_Message = reg_msg.getText();
			return Conf_Message;
			
		} catch (Exception e) 
		{
			return(e.getMessage());
		}
		 
	}


	
}
