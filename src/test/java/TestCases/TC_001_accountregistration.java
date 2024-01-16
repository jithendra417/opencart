package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.AccountRegistrationpage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_accountregistration extends BaseClass{
	@Test(groups= {"regression","master"})
	public void accountreg() throws InterruptedException
	{
		logger.info("****Starting TC_001_accountregistration***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickmyacc();
		logger.info("****Clicked on myaccount***");
		hp.Register();
		logger.info("****Clicked on register***");
		AccountRegistrationpage accpage=new AccountRegistrationpage(driver);
		accpage.Setfstname(randomString());
		logger.info("****set first name***");
		accpage.Setlstname(randomString());
		logger.info("*** set last name***");
		accpage.SetEmail(randomString()+"@gmail.com");
		logger.info("****set email***");
		accpage.SetPassword(randomString());
		logger.info("****set password***");
		Thread.sleep(3000);
		accpage.Agree();
		Thread.sleep(3000);
		accpage.con();
		logger.info("****Clicked on continue***");
		String confmsg=accpage.checktext();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("****account registered***");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			e.getMessage();
			Assert.fail();
		}
		logger.info("***Finished TC_001***");
	}
	
	

}
