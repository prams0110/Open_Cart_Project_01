package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void AccountLoginDetails()
	{
		logger.info("******TC002_AccountLogin Execution Started*****");
		
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLoginButton();
		
		//Loginpage
		LoginPage lp = new LoginPage(driver);
		
		lp.Emailid(p.getProperty("email")); // valid email 
		lp.Passwordfield(p.getProperty("password"));  // valid password
		lp.LoginButton();
		
		
		// MyAccounts page
		
		AccountsPage mcc = new AccountsPage(driver);
		
		boolean targetpage = mcc.MyAccountTextExists();
		
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******TC002_AccountLogin Execution Finished*****");
		
		
	}
}
