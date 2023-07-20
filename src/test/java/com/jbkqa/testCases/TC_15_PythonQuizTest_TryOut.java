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
import com.jbkqa.pageObjects.PythonQuizPage;


public class TC_15_PythonQuizTest_TryOut extends BaseClass{
	
	@Test
	public void PythonQuizTest() throws Exception
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
			PythonQuizPage pythonQuiz = new PythonQuizPage(driver);
			pythonQuiz.clickPythonTest();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='Python']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Python']/following-sibling::div//a//div"));
			
			System.out.println("Total number of Python quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("Python quiz page").assignAuthor("Rohini")
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
				    pythonQuiz.clickNextButton();
				    Thread.sleep(1500);
				    String pythonquiz = quizName.get(i).getText();
				    System.out.println("Python QUIZ start for: "+pythonquiz);
				    test.info("Python QUIZ start for: "+pythonquiz);
				   
				try
				{
					WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
					WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
					waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
					boolean error = errorscr.isDisplayed();
					test.fail("Captured error text displayed for No Questions Found for "+pythonquiz);
					
					
					if(error==true)
					{
						captureScreenshot(driver,pythonquiz+"_Python_NoQueFound");
						test.fail("Python Quiz test failed for "+pythonquiz);
						pythonQuiz.closeQuizWindow();
				        Thread.sleep(1500);	
					}
					
				}catch(Exception ElementNotInteractableException)
				{
					
					Thread.sleep(1100);
					WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
					int num = Integer.parseInt(optNum);
					System.out.println("Number of questions: "+num);
					test.info("Quiz started for "+pythonquiz+" Python Test.");
					
					for(int j=1;j<=num-1;j++)
					{
						JavascriptExecutor js = (JavascriptExecutor)driver;
				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
					   if(nextBtn.isDisplayed()==true)
					     {
				        
						   pythonQuiz.clickNextQueBtn();
					        
					     }
					   
					} 
					   
					   
						   System.out.println("Submit button displayed.");
						   Thread.sleep(1000);
						   pythonQuiz.clickQuizSubmit();
					   Thread.sleep(1500);
					   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
					   int numQue = Integer.parseInt(queCount);
					     if(numQue!=10)
					       {
						      captureScreenshot(driver,pythonquiz+"_QuizSubmittedFor_"+queCount+"_que");
						      test.fail("Python Quiz submitted for less than 10 questions. No of question found: "+queCount);
	  				       }
					     else 
					       {
					          test.pass("Python Test Pass for all "+queCount+" questions")	;
					       }
					     pythonQuiz.closeQuizWindow();
					     Thread.sleep(1500);
					     
					     a++;
					     
			                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Python']/following-sibling::div//a//div"));
			                loopThru = true;
				
					  ElementNotInteractableException.getMessage();
			               
					
					
			    }
				
				a++;
			     
                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Python']/following-sibling::div//a//div"));
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
