package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	@Test(priority=1)
	void Account_Registration()
	{
		//creating Objects for the Page Object Classes
		HomePage Hom_pg = new HomePage(driver);
		AccountRegistrationPage reg_pg = new AccountRegistrationPage(driver);
		
		//click myaccount and click register
		Hom_pg.clickmyAccount();
		Hom_pg.clickRegister();
		
		//Fill the details for Registration 
		reg_pg.setFirstName(randomString().toUpperCase());
		reg_pg.setLastName("Ajay");
		
		//Random Email Generator using userdefined in function 
		reg_pg.setEmail(randomString()+"@gmail.com"); //user defined function
		
		
		//Random Phone number Generator using userdefined in function
		reg_pg.setPhno(randomNum()); //user defined function
		
		
		//Random Password Generator using userdefined in function
		String password = randomAlphaNumeric(); //user defined function
		reg_pg.setPassword(password);
		reg_pg.setCnf_Password(password);
		
		
		
		//clicking on chkbox and Register button
		reg_pg.clickPolicy();
		reg_pg.clickReg();
		
		
		String cnf_message = reg_pg.getConfirmationMsg();
		Assert.assertEquals(cnf_message, "Your Account Has Been Created!");
		
	}
	
	
	
}
