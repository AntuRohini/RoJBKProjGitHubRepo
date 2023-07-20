package com.jbkqa.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.SignUpPage;
import com.jbkqa.utilities.ExcelUtil;
import java.util.ArrayList;

public class TC_32_SignUpDataDrivenTest extends BaseClass{
  @Test(dataProvider = "jbkSignUpData")
  public void SignUpDataDrivenTest(String name,String email, String mobile) throws Exception {
	    
	    driver.get(baseURL);
	    SignUpPage sp = new SignUpPage(driver);
	    sp.clickplacementPolicy();
	    sp.clickplacementQuiz();
	    sp.clickNextbtn();
	    //Thread.sleep(1500);
	    sp.clickSignUp();
	    driver.switchTo().newWindow(WindowType.WINDOW);
	    driver.get("https://www.qa.jbktest.com/terms-and-conditions");
	    ArrayList<String> tabs = new ArrayList< >(driver.getWindowHandles());
	    System.out.println(tabs.size());
	    //sp.clicktermsConditions();
	    String termsConditions = driver.findElement(By.xpath("//ul[@class='my-5']")).getText();
	    System.out.println("Terms and Conditions Text: ");
	    System.out.println(termsConditions);
	    driver.switchTo().window(tabs.get(1)).close();
	    driver.switchTo().window(tabs.get(0));
	    sp.setName(name);
	    sp.setEmail(email);
	    sp.setMobile(mobile);
	    sp.clickAgree();
	    Thread.sleep(2000);
	    
	    
	   // JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("window.open()");
//	    
		//js.executeScript("arguments[0].scrollIntoView(true);", sp.clicktermsConditions());
	   
	  
	   // driver.navigate().back();
	    sp.clickProceed();
	  
		sp.dashboardPage();
		ExtentTest test = extent.createTest("Launch the browser and website.").assignAuthor("Rohini")
				 .assignCategory("Functional Test cases").assignDevice("Mac");
		 test.info("Capturing the page current URL.");
		 String dashboardURL = driver.getCurrentUrl();
		 test.info("Captured dashboard page URL: "+dashboardURL);
		if(dashboardURL.equalsIgnoreCase("https://www.qa.jbktest.com/dashboard"))
		{
			//captureScreenshot(driver,"LoginPass"+"_"+phone);
			Assert.assertTrue(true);
		 	test.pass("New User get registered and app launched sucessfully. Here is the dashboard URL :"+dashboardURL);
		 	sp.logout();
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

  @DataProvider(name="jbkSignUpData")
	public Object[][] getData() throws Exception 
	{
		String path = "/Users/rohini/Documents/JavaCodes/jbkqaMavenProjV1/src/test/java/com/jbkqa/testData/SignUpTestingData_01.xlsx";
	    ExcelUtil excel = new ExcelUtil(path); 
		int rows = excel.getRowCount(0);
		System.out.println(rows);
		Object[][] signUpdata = new Object[rows][3];
		
		for(int i=0;i<rows;i++)
		{
			
			signUpdata[i][0]=excel.getSignUpData(i, 0);
			signUpdata[i][1]=excel.getSignUpData(i, 1);
			signUpdata[i][2]=excel.getSignUpData(i, 2);
			
		}

		return signUpdata;
		  
	}
  
  @AfterMethod
  public void signUpFailedScreenshot(ITestResult result)
  {
	  ExtentTest test = extent.createTest("SignUp Test Failed").assignAuthor("Rohini")
				 .assignCategory("Regression Test cases").assignDevice("Mac");
	  test.fail("Sign UP test failed.");
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  test.info("Captured SignUp test failed screenshot.");
		  captureScreenshot(driver,"SignUpFailed");
	  }
  }
  
}
