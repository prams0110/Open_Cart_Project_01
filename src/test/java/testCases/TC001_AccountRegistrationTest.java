package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void Verify_Account_Registration()
	{
		logger.info("******* TC001_AccountRegistrationTest has started the Execution*********");
		// On the homepage it clicks on myaccount and clicks on registration button
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("******* Clicked on the My Account *********");
		hp.clickRegisterButton();
		logger.info("******* Clicked on the Register now button *********");
		
		logger.info("*******Providing the user details *********");
		AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		Arp.setfirstname(randomString().toUpperCase());
		Arp.setlastname(randomString().toUpperCase());
		Arp.setemailid(randomString()+"@gmail.com");
		Arp.settelnumber(randomNumber());
		
		String password = randompassword();
		
		Arp.setpassword(password);
		Arp.setconfirmpassword(password);
		
		Arp.clickcheckbox();
		Arp.clickcontinue();
		
		logger.info("******* Performing the validation*********");
		String confmsg = Arp.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!!");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debugs Logged");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("******* TC001_AccountRegistrationTest has finished the Execution*********");
	}
	

	public String randomString() 
	  { 
		  String generatedstring =RandomStringUtils.randomAlphabetic(5); 
		  return generatedstring; 
	  }
	 
	  public String randomNumber() 
	  { 
		  String generatedNumber =RandomStringUtils.randomNumeric(10); 
		  return generatedNumber; 
	  }
	
	  public String randompassword() 
	  { 
		  String generatedpassword =RandomStringUtils.randomAlphanumeric(10); 
		  return generatedpassword; 
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
