package com.jbkqa.testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.LoginPage;
import com.jbkqa.utilities.ExcelUtil;

public class TC_02_LoginDataDrivenTest extends BaseClass{
  @Test(dataProvider = "jbkLoginData")
  public void LoginDataDrivenTest(String phone) throws Exception {
	    
	    driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.clickTestingQuiz();
		lp.clickMavenQuiz();
		lp.clickNextbtn();
		lp.setUserMobile(phone);
		lp.clickLogin();
		lp.dashboardPage();
		ExtentTest test = extent.createTest("Launch the browser and website.").assignAuthor("Rohini")
				 .assignCategory("Functional Test cases").assignDevice("Mac");
		 test.info("Capturing the page current URL.");
		 String dashboardURL = driver.getCurrentUrl();
		 test.info("Captured dashboard page URL: "+dashboardURL);
		if(dashboardURL.equalsIgnoreCase("https://www.qa.jbktest.com/dashboard"))
		{
			//captureScreenshot(driver,"LoginPass"+"_"+phone);
			Assert.assertTrue(true);
		 	test.pass("User launch to application is verified and dashboard URL is:"+dashboardURL);
		 	lp.logout();
		 	driver.switchTo().defaultContent();
		}
		
		else 
		{
			
//			String error = driver.findElement(By.xpath("//div[@id='loginerr']")).getText();
//		    System.out.println(error);
//			captureScreenshot(driver,"LoginFailed"+"_"+phone);
//			lp.signUp();
			Assert.assertTrue(false);
			test.info("User is not registered.");
		}
		


  }

  @DataProvider(name="jbkLoginData")
	public Object[][] getData() throws Exception 
	{
		String path = "/Users/rohini/Documents/JavaCodes/jbkqaMavenProjV1/src/test/java/com/jbkqa/testData/SigninDetailsTestData.xlsx";
	    ExcelUtil excel = new ExcelUtil(path); 
		int rows = excel.getRowCount(0);
		System.out.println(rows);
		Object[][] logindata = new Object[rows][1];
		
		for(int i=0;i<rows;i++)
		{
			//logindata[i][0]=excel.getData(0, i, 0);
			logindata[i][0]=excel.getSignUpData(i, 0);
			
		}

		return logindata;
		  
	}
  
  @AfterMethod
  public void loginFailedScreenshot(ITestResult result)
  {
	  ExtentTest test = extent.createTest("Login Test Failed").assignAuthor("Rohini")
				 .assignCategory("Regression Test cases").assignDevice("Mac");
	  test.fail("Login test failed.");
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  test.info("Captured test failed screenshot.");
		  captureScreenshot(driver,"LoginFailed");
	  }
  }
  
}
