package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PagObjects.Basepage;

public class LoginPage extends Basepage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement myEmail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement myPassword;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement Login;
	
	
	
	public void OpenEmail(String Email)
	{
		myEmail.sendKeys(Email);
	}
	public void OpenPassword(String password)
	{
		myPassword.sendKeys(password);
	}
	public void openaccount()
	{
		Login.click();
	}
	


}
