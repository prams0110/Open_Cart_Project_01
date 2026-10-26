package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage{

	// constructor

		public AccountsPage(WebDriver driver)
		{
			super(driver);
		}
		
		
		// Locators
		
		@FindBy(xpath="//h2[text()='My Account']") WebElement MyAccountText;
		
		@FindBy(xpath="(//a[text()='Logout'])[2]") WebElement lnk_logout_btn;
		
		// Action Methods
		
		public boolean MyAccountTextExists()
		{
			try
			{
				return(MyAccountText.isDisplayed());
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public void Logoutbutton()
		{
			lnk_logout_btn.click();
		}
}
