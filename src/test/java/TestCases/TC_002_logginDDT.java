package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagObjects.Homepage;
import PagObjects.LoginPage;
import PagObjects.Myaccountpage;
import PageObjects.MyAccountpage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC_002_logginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_logDDT(String email,String password,String exp)
	{
		logger.info("***StartingTC_002_logginDDT *");
		try
		{
		Homepage hp=new Homepage(driver);
		Thread.sleep(3000);
		hp.clickmyaccount();
		logger.info("click on my account");
		hp.clicklogin();
		logger.info("click on login");
		LoginPage lp=new LoginPage(driver);
		logger.info("providing login details");
		lp.setemail(email);//valid email,config properties files
		lp.setpassword(password);
		lp.clicklogin();
		logger.info("click on login");
		MyAccountpage acc=new MyAccountpage(driver);
		boolean targetpage=acc.ismyAccountpageExists();
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage=true)
			{
				acc.logoutaccount();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);		
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage=true)
			{
				acc.logoutaccount();;
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(true);			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Finished Test_002_loginDDT **");
		
	

	}

}
