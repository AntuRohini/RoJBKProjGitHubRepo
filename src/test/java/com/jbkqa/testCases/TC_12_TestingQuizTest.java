package com.jbkqa.testCases;

import com.jbkqa.pageObjects.LoginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.TestingQuizPage;
import org.openqa.selenium.interactions.Actions;

public class TC_12_TestingQuizTest extends BaseClass{
	
	@Test
	public void TestingQuizTest() throws Exception
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
				TestingQuizPage TestingQuiz = new TestingQuizPage(driver);
				TestingQuiz.clickTestingTest();
				Thread.sleep(1000);
				int a = 0;
				boolean loopThru = true;
				List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='Testing']/following-sibling::div//a//p"));
				List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Testing']/following-sibling::div//a//div"));
				
				System.out.println("Total number of Testing quiz are: "+takeQuiz.size());
				
				ExtentTest test = extent.createTest("Testing quiz page").assignAuthor("Rohini")
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
					   // takeQuizBtn.click();
					    String optNum = driver.findElement(By.name("count")).getAttribute("value");
					    //Thread.sleep(1500);
					    TestingQuiz.clickNextButton();
					    Thread.sleep(1500);
					    String testingquiz = quizName.get(i).getText();
					    System.out.println("Testing QUIZ start for: "+testingquiz);
					    test.info("Testing QUIZ start for: "+testingquiz);
					    
					try
					{
						WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
						WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
						waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
						boolean error = errorscr.isDisplayed();
						test.fail("Captured error text displayed for No Questions Found");
						
						
						if(error==true)
						{
							captureScreenshot(driver,testingquiz+"_Testing_NoQueFound");
							test.fail("Testing Quiz test failed.");
							TestingQuiz.closeQuizWindow();
					        Thread.sleep(1500);	
						}
						
					}catch(Exception ElementNotInteractableException)
					{
						
						Thread.sleep(1100);
						WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
						int num = Integer.parseInt(optNum);
						System.out.println("Number of questions: "+num);
						test.info("Quiz started for "+testingquiz+" Testing Test.");
						
						for(int j=1;j<=num-1;j++)
						{
							JavascriptExecutor js = (JavascriptExecutor)driver;
					        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
						   if(nextBtn.isDisplayed()==true)
						     {

							   TestingQuiz.clickNextQueBtn();
						        
						     }
						   
						} 
						   
						   
						   System.out.println("Submit button displayed.");
						   Thread.sleep(1000);
						   TestingQuiz.clickQuizSubmit();
						   Thread.sleep(1500);
						   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
						   int numQue = Integer.parseInt(queCount);
						     if(numQue!=10)
						       {
							      captureScreenshot(driver,testingquiz+"_QuizSubmittedFor_"+queCount+"_que");
							      test.fail("Testing Quiz submitted for less than 10 questions. No of question found: "+queCount);
		  				       }
						     else 
						       {
						          test.pass("Testing Test Pass for all "+queCount+" questions")	;
						       }
						     TestingQuiz.closeQuizWindow();
						     Thread.sleep(1500);
						     
						     a++;
						     
				                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Testing']/following-sibling::div//a//div"));
				                loopThru = true;
				
						  ElementNotInteractableException.getMessage();
						
						
				    }
					
					a++;
				     
	                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Testing']/following-sibling::div//a//div"));
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
