package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends BasePage {

	public MyAccountpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement account;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;
	public boolean myaccount()
	{
		try
		{
		 return true;
	}
	catch(Exception e)
	{
		return false;
	}	}
	public void logoutaccount()
	{
		Logout.click();
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	public boolean ismyAccountpageExists()
	{
		try {
			return (msgHeading.isDisplayed());
		}
		catch(Exception e){
			return(false);
		}
	}
	

}
