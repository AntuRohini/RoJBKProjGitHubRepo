package com.jbkqa.testCases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.LoginPage;
import com.jbkqa.pageObjects.MyProfilePage;





public class TC_31_ProfileUpdateTest extends BaseClass{
	
	@Test
	public void profileUpdate()
	{
try {
			
			driver.get(baseURL);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickTestingQuiz();
            lp.clickMavenQuiz();
			lp.clickNextbtn();
			lp.setUserMobile(userMobile);
			lp.clickLogin();
			//lp.closeWindow();
			Thread.sleep(1000);
			ExtentTest test = extent.createTest("Profile update test").assignAuthor("Rohini")
					 .assignCategory("Regression Test cases").assignDevice("Mac");
			MyProfilePage mp = new MyProfilePage(driver);
			mp.clickMyAcc();
			mp.clickViewProfile();
			
			captureScreenshot(driver, "ProfilenameBeforeupdate");
			test.info("Screenshot captured before profile update.");
			mp.updateName();
			mp.updateEmail();
			captureScreenshot(driver, "NameupdateText");
			test.info("Screenshot captured before updating profile.");
			mp.clickUpdateBtn();
			captureScreenshot(driver, "ProfilenameAfterupdate");
			test.info("Screenshot captured after profile update.");
			String actUpdateMsg = driver.findElement(By.xpath("//div[@id='msg']")).getText();
			String expUpdateMsg = "Profile successfully updated";
			Assert.assertEquals(actUpdateMsg, expUpdateMsg);
			System.out.println("Profile update test sucessfull.");
			Thread.sleep(1000);
			
			String actUpdatedName = "Welcome Ovee Rohankar,";
			String expUpdatedName = driver.findElement(By.xpath("//span[contains(text(),'Rohankar')]")).getText();
			Assert.assertEquals(actUpdatedName, expUpdatedName,"Profile name field does not updated under welcome message.");
			String actUpdatedemail = "Ovee.Rohankar@gmail.com";
			String expUpdatedemail = driver.findElement(By.xpath("//span[contains(text(),'Ovee.Rohankar@gmail.com')]")).getText();
			Assert.assertEquals(actUpdatedemail, expUpdatedemail,"Profile email field does not updated under welcome message.");
			Thread.sleep(1000);
			captureScreenshot(driver, "ProfilenameFailedupdate");
			test.info("Screenshot captured failed profile update.");
			
			
			 
			
			
		} catch (Exception e) {
			
			
			
			e.printStackTrace();
		}
	}

}
