package com.jbkqa.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.LoginPage;
import com.jbkqa.pageObjects.PlacementPolicyQuizPage;

public class TC_03_PlacementQuizTest extends BaseClass{

	@Test
	public void PlacementQuizTest() 
	{
		try {
			
			driver.get(baseURL);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickTestingQuiz();
            lp.clickMavenQuiz();
			lp.clickNextbtn();
			lp.setUserMobile(userMobile);
			lp.clickLogin();
			lp.closeWindow();
			Thread.sleep(1500);
			PlacementPolicyQuizPage ppq = new PlacementPolicyQuizPage(driver);
			
			ppq.clickPlacementPolicyQuiz();
			ppq.clickPlacementQuiz();
			String optNum = driver.findElement(By.name("count")).getAttribute("value");
			ppq.clickNextButton();
			Thread.sleep(1500);
			ExtentTest test = extent.createTest("Placememnt quiz window").assignAuthor("Rohini")
					 .assignCategory("Functional Test cases").assignDevice("Mac");
			 
			boolean nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]")).isDisplayed();
			test.info("Next button is dispalyed");
			
			if(nextBtn==true)
			{
				test.pass("Quiz started.");
				Assert.assertTrue(true);
				int num = Integer.parseInt(optNum);
				
				for(int i=1;i<=num-1;i++)
				{
					WebElement next = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true);", next);
					Thread.sleep(1500);
					next.click();
					
				}
				ppq.clickQuizSubmit();
				Thread.sleep(1500);
				ppq.closeQuizWindow();
				
			}
			else
			{
				Assert.assertTrue(false);
				test.info("Capturing the text for error on Placement Quiz start.");
				String errorText = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]")).getText();
				if(errorText=="Sorry!!! No Questions Found ")
				{
				captureScreenshot(driver,"NoQueFound");
				test.fail("Quiz test failed.");
				
				}
				ppq.closeQuizWindow();
			}
			
			
			 
			
			
		} catch (Exception e) {
			
			
			
			e.printStackTrace();
		}
	}
}
