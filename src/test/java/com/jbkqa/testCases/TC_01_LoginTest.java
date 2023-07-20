package com.jbkqa.testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jbkqa.pageObjects.LoginPage;



public class TC_01_LoginTest extends BaseClass{

	@Test
	public void loginTest() throws Exception
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.clickTestingQuiz();
		lp.clickMavenQuiz();
		lp.clickNextbtn();
		
		lp.setUserMobile(userMobile);
		
		lp.clickLogin();
		lp.dashboardPage();

		 ExtentTest test = extent.createTest("Launch the browser and website.").assignAuthor("Rohini")
				 .assignCategory("Functional Test cases").assignDevice("Mac");
		 test.info("Capturing the page current URL.");
		 String dashboardURL = driver.getCurrentUrl();
		 test.info("Captured dashboard page URL: "+dashboardURL);
		if(dashboardURL.equalsIgnoreCase("https://www.qa.jbktest.com/dashboard"))
		{
//			Assert.assertTrue(true);
//			logger.info("Assertion pass for Current URL");
			
			  //test.log(Status.PASS, "User launch to application.");
		 	test.pass("User launch to application is verified and dashboard URL is:"+dashboardURL);
		}
//		if(driver.getTitle().equals("Online Quiz to test your skills in Java,Python,MySQL,Testing"))
//		{
//			Assert.assertTrue(true);
//		}
		else
		{
//			Assert.assertTrue(false);
			captureScreenshot(driver, "LoginFailedScreen");
			  //capcaptureScreenshot(driver,"LoginFailed");
			  test.fail("User is unable to launch application.");
			  //test.addScreenCaptureFromPath(captureScreenshot);
			
		}
//		String actResult = driver.findElement(By.xpath("//a[contains(@href,'/dashboard')]")).getText();
//		String expResult = " My Account";
		
		
		
		
		
	}
}
