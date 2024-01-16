package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationpage extends BasePage{
	public WebDriver driver;

	public AccountRegistrationpage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(name="email")
	WebElement Email;
	@FindBy(name="password") 
	WebElement password1;
	@FindBy(name="agree")
	WebElement agree;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnctn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement text;
	
	public void Setfstname(String name)
	{
		firstname.sendKeys(name);
	}
	public void Setlstname(String name)
	{
		lastname.sendKeys(name);
	}
	public void SetEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void SetPassword(String password)
	{
		password1.sendKeys(password);
	}
	public void Agree()
	{
		agree.click();
	}
	public void con()
	{
		btnctn.click();
	}
	
	public String checktext()
	{
		try
		{
		 return (text.getText());
	}
	catch(Exception e)
	{
		return e.getMessage();
	}	}

	

}
