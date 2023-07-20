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
import com.jbkqa.pageObjects.GeneralKnowledgeQuizPage;


public class TC_08_GeneralKnowledgeQuizTest extends BaseClass{
	
	@Test
	public void GeneralKnowledgeQuizTest()
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
			GeneralKnowledgeQuizPage gkQuiz = new GeneralKnowledgeQuizPage(driver);
			gkQuiz.clickGeneralKnowledgeTest();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='General Knowledge']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='General Knowledge']/following-sibling::div//a//div"));
			
			System.out.println("Total number of General Knowledge quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("General Knowledge quiz page").assignAuthor("Rohini")
					 .assignCategory("Regression Test cases").assignDevice("Mac");
		    
			 
			while(loopThru)
			 {
				
			     for(int i=a;i<takeQuiz.size();i++)
			      {
				    WebElement takeQuizBtn = takeQuiz.get(i);
				    
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		            wait.until(ExpectedConditions.elementToBeClickable(takeQuizBtn));
  		            Actions action =new Actions(driver);
				    action.moveToElement(takeQuizBtn).click().build().perform();
				    String optNum = driver.findElement(By.name("count")).getAttribute("value");
				    gkQuiz.clickNextButton();
				    Thread.sleep(1500);
				    String gkquiz = quizName.get(i).getText();
				    System.out.println("General Knowledge QUIZ start for: "+gkquiz);
				    test.info("General Knowledge QUIZ start for: "+gkquiz);
				   
				try
				{
					WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
					WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
					waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
					boolean error = errorscr.isDisplayed();
					test.fail("Captured error text displayed for No Questions Found for "+gkquiz);
					
					
					if(error==true)
					{
						captureScreenshot(driver,gkquiz+"_GeneralKnowledge_NoQueFound");
						test.fail("General Knowledge Quiz test failed for "+gkquiz);
						gkQuiz.closeQuizWindow();
				        Thread.sleep(1500);	
					}
					
				}catch(Exception ElementNotInteractableException)
				{
					
					Thread.sleep(1100);
					WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
					int num = Integer.parseInt(optNum);
					System.out.println("Number of questions: "+num);
					test.info("Quiz started for "+gkquiz+" General Knowledge Test.");
					
					for(int j=1;j<=num-1;j++)
					{
						JavascriptExecutor js = (JavascriptExecutor)driver;
				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
					   if(nextBtn.isDisplayed()==true)
					     {
				        
						   gkQuiz.clickNextQueBtn();
					        
					     }
					   
					} 
					   
					   
						   System.out.println("Submit button displayed.");
						   Thread.sleep(1000);
						   gkQuiz.clickQuizSubmit();
					   Thread.sleep(1500);
					   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
					   int numQue = Integer.parseInt(queCount);
					     if(numQue!=10)
					       {
						      captureScreenshot(driver,gkquiz+"_QuizSubmittedFor_"+queCount+"_que");
						      test.fail("General Knowledge Quiz submitted for less than 10 questions. No of question found: "+queCount);
	  				       }
					     else 
					       {
					          test.pass("General Knowledge Test Pass for all "+queCount+" questions")	;
					       }
					     gkQuiz.closeQuizWindow();
					     Thread.sleep(1500);
					     
					     a++;
					     
			                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='General Knowledge']/following-sibling::div//a//div"));
			                loopThru = true;
				
					  ElementNotInteractableException.getMessage();
			               
					
					
			    }
				
				a++;
			     
                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='General Knowledge']/following-sibling::div//a//div"));
                loopThru = true;
			}
			     
			break;     
	   }	
			
	 }		
	 catch(Exception e)
	 {
		e.getStackTrace(); 
	 }
	}

}
