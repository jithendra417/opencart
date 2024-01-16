package Utilities;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;
import Testbase.Baseclass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		//String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));//time stamp
		repName ="Test-Report-"+timestamp+".html";
		sparkReporter =new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
		sparkReporter.config().setDocumentTitle("opencart Automation report");//title of report
		sparkReporter.config().setReportName("opencart Functional Testing");//name of report
		sparkReporter.config().setTheme(Theme.DARK);
		extent =new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operationg System", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
		java.util.List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}
	public void onTestSucess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display groups in report
		test.log(Status.PASS, result.getName()+"got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"Test failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try
		{
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"Test Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
