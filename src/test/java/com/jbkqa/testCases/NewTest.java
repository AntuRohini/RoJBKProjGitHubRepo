package com.jbkqa.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class NewTest {
	
	 ExtentReports extent = new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("target/Extentreport.html");
	 
  @Test
  public void f1() {
	  
	  ExtentTest test = extent.createTest("Launch the browser and website.").assignAuthor("Rohini")
			  .assignCategory("Smoke test").assignDevice("chrome");
	  test.log(Status.PASS, "User launch to application.");
	  test.pass("User launch to application is verified.");
  }
  
  @Test
  public void f2() {
	  
	  ExtentTest test = extent.createTest("Verify login.").assignAuthor("Anant")
			  .assignCategory("Sanity test").assignDevice("IE");
	  test.info("Alert displayed.");
	  test.pass("User logged into application.");
	  test.warning("Reset password alert screen.");
  }
  
  @Test
  public void f3() {
	  
	  ExtentTest test = extent.createTest("Verify dashboard.").assignAuthor("Darsh")
			  .assignCategory("Business test").assignDevice("firefox");
	  test.skip("Verify dashboard skipped.");
  }
  
  @Test
  public void f4() {
	  
	  ExtentTest test = extent.createTest("Verify user can update profile.").assignAuthor("Sagar")
			  .assignCategory("Functional test").assignDevice("chrome");
	  test.fail("Unable to send email due to server down time.");
  }
  
  @Test
  public void f5() {
	  
	  ExtentTest test = extent.createTest("Verify user profile reports and analyticws.").assignAuthor("Sagar")
			  .assignCategory("Regression test").assignDevice("IE");
	  test.fail("Reports gettinmg crashed.");
	  
  }
  
  @Test
  public void f6() {
	  
	  ExtentTest test = extent.createTest("User can logout.").assignAuthor("Ashish")
			  .assignCategory("UI test").assignDevice("chrome");
	  test.pass("User logged out to application.");
	  test.info("User is redirected to login page.");
  }
    
  
  @BeforeTest
  public void beforeTest() {
	  
	 
	  extent.attachReporter(spark);

  }
 

  @AfterTest
  public void afterTest() {
	  
	  extent.flush();
  }

}
