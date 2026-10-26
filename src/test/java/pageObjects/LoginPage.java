package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	// constructor

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	// Locator
	@FindBy(xpath="//input[@id='input-email']") WebElement txtusername;
	@FindBy(xpath="//input[@id='input-password']") WebElement  txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin ;
	
	// Action methods
	
	public void Emailid(String username)
	{
		txtusername.sendKeys(username);
	}
	
	public void Passwordfield(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void LoginButton()
	{
		btnLogin.click();
	}
}
