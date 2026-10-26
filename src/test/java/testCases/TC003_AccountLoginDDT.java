package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_AccountLoginDDT extends BaseClass {

	@Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class, groups="DataDriven")
	public void Verify_LoginDDT(String email,String pwd,String expres)
	{
	     logger.info("****** Test Execution of TC003_AccountLoginDDT Started");
		// Home Page 
		try 
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLoginButton();
		
		// Login Page
		
		LoginPage lp = new LoginPage(driver);
		
		lp.Emailid(email);
		lp.Passwordfield(pwd);
		lp.LoginButton();
		
		// My Account page 
		
		AccountsPage ap = new AccountsPage(driver);
		
		boolean targetpage = ap.MyAccountTextExists();
		
// valid data	-- login successful - test passed
//		           login unsuccessful - test failed
// Invalid data -- login successful- test failed
//		           login unsuccessful - test passed
		
		if(expres.equalsIgnoreCase("valid"))
		{
			// login successful on valid data enter to my accounts page
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				ap.Logoutbutton();
			}
			// login unsuccessful on valid data  
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expres.equalsIgnoreCase("invalid"))
		{
			// login successful on invalid data enter to my accounts page
			if(targetpage==true)
			{
				Assert.assertTrue(false);
				ap.Logoutbutton();
			}
			// login unsuccessful on invalid data 
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****** Test Execution of TC003_AccountLoginDDT Finished");
	
	}
}
