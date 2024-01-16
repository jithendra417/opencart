package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountpage;
import TestBase.BaseClass;

public class TC_002_loginaccount extends BaseClass {
	@Test(groups= {"sanity","master"})
	public void LoginTest()
	{
		try {
		logger.info("***Starting test login***");
		HomePage hp=new HomePage(driver);
		logger.info("***myaccount***");
		hp.clickmyacc();
		logger.info("***login***");
		hp.clicklogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("***set Email***");
		lp.OpenEmail("jithendra.417@gmail.com");
		//lp.OpenEmail(pro.getProperty("email"));
		logger.info("***set password***");
		lp.OpenPassword("jith.417");
		//lp.OpenPassword(pro.getProperty("password"));
		logger.info("***open account***");
		lp.openaccount();
		MyAccountpage myacc=new MyAccountpage(driver);
		logger.info("***validationg account***");
		boolean confmsg=myacc.myaccount();
		Assert.assertEquals(confmsg, true);
		myacc.logoutaccount();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Login test finished***");
	}

}
