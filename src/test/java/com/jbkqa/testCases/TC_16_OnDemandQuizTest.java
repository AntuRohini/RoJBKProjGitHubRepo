package com.jbkqa.testCases;

import com.jbkqa.pageObjects.LoginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.OnDemandTestQuizPage;

public class TC_16_OnDemandQuizTest extends BaseClass{
	
	@Test
	public void OnDemandQuizTest() throws Exception
	{
//		try {
			driver.get(baseURL);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickTestingQuiz();
            lp.clickMavenQuiz();
			lp.clickNextbtn();
			lp.setUserMobile(userMobile);
			lp.clickLogin();
			lp.closeWindow();
			Thread.sleep(1500);
			OnDemandTestQuizPage onDemandQuiz = new OnDemandTestQuizPage(driver);
			onDemandQuiz.clickOnDemandTest();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
			
			System.out.println("Total number of On Demand Test quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("On Demand Test quiz page").assignAuthor("Rohini")
					 .assignCategory("Regression Test cases").assignDevice("Mac");
		     
			while(loopThru)
			 {
				
			     for(int i=a;i<takeQuiz.size();i++)
			      {
				    
			    	 WebElement takeQuizBtn = takeQuiz.get(i);
				    
				    JavascriptExecutor takeQuejs = (JavascriptExecutor)driver;
				    //takeQuejs.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
				    takeQuejs.executeScript("window.scrollBy(0,-2000);", takeQuizBtn);
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				    wait.until(ExpectedConditions.elementToBeClickable(takeQuizBtn));
				   // wait.until(ExpectedConditions.visibilityOf(takeQuizBtn));
  		         
  		            Actions action =new Actions(driver);
  		            action.moveToElement(takeQuizBtn).click().build().perform();
//  		            action.click(takeQuizBtn).click().build().perform();
  		         // action.scrollToElement(takeQuizBtn).click().build().perform();
				    Thread.sleep(1000);
				    String optNum = driver.findElement(By.name("count")).getAttribute("value");
				    Thread.sleep(2000);
				    onDemandQuiz.clickNextButton();
				    Thread.sleep(1500);
				    String onDemandquiz = quizName.get(i).getText();
				    System.out.println("On Demand Test QUIZ start for: "+onDemandquiz);
				    test.info("On Demand Test QUIZ start for: "+onDemandquiz);
				   
				try
				{
					WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
					WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
					waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
					boolean error = errorscr.isDisplayed();
					test.fail("Captured error text displayed for No Questions Found for "+onDemandquiz);
					
					
					if(error==true)
					{
						captureScreenshot(driver,onDemandquiz+"_onDemand_NoQueFound");
						test.fail("On Demand Quiz test failed for "+onDemandquiz);
						onDemandQuiz.closeQuizWindow();
				        Thread.sleep(1500);	
					}
					
				}catch(Exception ElementNotInteractableException)
				{
					
					Thread.sleep(1100);
					WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
					int num = Integer.parseInt(optNum);
					System.out.println("Number of questions: "+num);
					test.info("Quiz started for "+onDemandquiz+" On Demand Test.");
					
					for(int j=1;j<=num-1;j++)
					{
						JavascriptExecutor js = (JavascriptExecutor)driver;
				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
					   if(nextBtn.isDisplayed()==true)
					     {
				        
						   onDemandQuiz.clickNextQueBtn();
					        
					     }
					   
					} 
					   
					   
					   System.out.println("Submit button displayed.");
					   Thread.sleep(1000);
					   onDemandQuiz.clickQuizSubmit();
					   Thread.sleep(1500);
					   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
					   int numQue = Integer.parseInt(queCount);
					     if(numQue!=10)
					       {
						      captureScreenshot(driver,onDemandquiz+"_QuizSubmittedFor_"+queCount+"_que");
						      test.fail("On Demand Test Quiz submitted for less than 10 questions. No of question found: "+queCount);
	  				       }
					     else 
					       {
					          test.pass("On Demand Test Pass for all "+queCount+" questions")	;
					       }
					     onDemandQuiz.closeQuizWindow();
					     Thread.sleep(1500);
					     
					     a++;
					     
			                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
			                loopThru = true;
				
					  ElementNotInteractableException.getMessage();
			               
					
					
			    }
				
				a++;
			     
                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
                loopThru = true;
			}
			     
			break;     
	   }	
			
//	 }		
//	 catch(Exception e)
//	 {
//		e.getStackTrace(); 
//	 }
	}

}
