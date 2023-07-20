package com.jbkqa.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.jbkqa.pageObjects.LoginPage;
import com.jbkqa.pageObjects.TestttttQuizPage;

public class TC_18_TestttttQuizTestForAll_102025QueOptions extends BaseClass{

	@Test
	public void TestttttQuizTest() 
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
			TestttttQuizPage testq = new TestttttQuizPage(driver);
			testq.clickTestttttTest();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
			
			List <WebElement> radio = driver.findElements(By.xpath("//input[@name='count' and @type='radio']"));
		   
			System.out.println("Total number of testtttt quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("testtttt quiz page").assignAuthor("Rohini")
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
				    //String optNum = driver.findElement(By.name("count")).getAttribute("value");
				    int b=0;
				    
				    boolean loopThruNew = true;
				    
				    while(loopThruNew)
				    {	
				    for(int k=b;k<radio.size();k++)
					{
						WebElement button = radio.get(k);
						String value = button.getAttribute("value");
						System.out.println("Value of radio buttons: "+value);
						test.info("testtttt quiz started for "+value+" questions.");
						
						if(value.equalsIgnoreCase("10"))
						 {
							testq.clickNextButton();
						    Thread.sleep(1500);
						    String testttttquiz = quizName.get(i).getText();
						    System.out.println("testtttt QUIZ start for 10 question: "+testttttquiz);
						    test.info("testtttt QUIZ start for 10 question: "+testttttquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+testttttquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,testttttquiz+value+"_testtttt_NoQueFound");
									test.fail("testtttt Quiz test failed for "+testttttquiz);
									testq.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
								 b++;
							     
					                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
					                takeQuizBtn.click();
					                loopThruNew = true;
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+testttttquiz+" testtttt Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   testq.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   testq.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=10)
								       {
									      captureScreenshot(driver,testttttquiz+"_testtttt_10QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("testtttt Quiz submitted for less than 10 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("testtttt quiz Test Pass for all "+queCount+" questions")	;
								       }
								     testq.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
						                takeQuizBtn.click();
						                loopThruNew = true;
//								  ElementNotInteractableException.getMessage();	
								
						    }
						   
					     }
						
						if(value.equalsIgnoreCase("20"))
						 {
							System.out.println("20 questions");
							WebDriverWait waiterr1 = new WebDriverWait(driver, Duration.ofSeconds(10));
							waiterr1.until(ExpectedConditions.elementToBeClickable(button));
							button.click();
							Thread.sleep(1000);
							testq.clickNextButton();
						    Thread.sleep(1500);
						    String testttttquiz = quizName.get(i).getText();
						    System.out.println("testtttt QUIZ start for 20 question: "+testttttquiz);
						    test.info("testtttt QUIZ start for 20 question: "+testttttquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+testttttquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,testttttquiz+value+"_testtttt_NoQueFound");
									test.fail("testtttt Quiz test failed for "+testttttquiz);
									testq.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
								 b++;
							     
					                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
					                takeQuizBtn.click();
					                loopThruNew = true;
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+testttttquiz+" testtttt Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   testq.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   testq.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=20)
								       {
									      captureScreenshot(driver,testttttquiz+"_testtttt_20QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("testtttt Quiz submitted for less than 20 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("testtttt Test Pass for all "+queCount+" questions")	;
								       }
								     testq.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     
								     
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
						                takeQuizBtn.click();
						                loopThruNew = true;
							
//								  ElementNotInteractableException.getMessage();
						               
								
								
						    }
							
					     }
						if(value.equalsIgnoreCase("25"))
						 {
							System.out.println("25 questions");
							WebDriverWait waiterr2 = new WebDriverWait(driver, Duration.ofSeconds(10));
							waiterr2.until(ExpectedConditions.elementToBeClickable(button));
							button.click();
							Thread.sleep(1000);
							testq.clickNextButton();
						    Thread.sleep(1500);
						    String testttttquiz = quizName.get(i).getText();
						    System.out.println("testtttt QUIZ start for 25 question: "+testttttquiz);
						    test.info("testtttt QUIZ start for 25 question: "+testttttquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+testttttquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,testttttquiz+value+"_testtttt_NoQueFound");
									test.fail("testtttt Quiz test failed for "+testttttquiz);
									testq.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+testttttquiz+" testtttt Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   testq.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   testq.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=25)
								       {
									      captureScreenshot(driver,testttttquiz+"_testtttt_25QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("testtttt Quiz submitted for less than 25 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("testtttt Test Pass for all "+queCount+" questions")	;
								       }
								     testq.closeQuizWindow();
								     Thread.sleep(1500);
							
//								  ElementNotInteractableException.getMessage();
						               
								
								
						    }
							
							
					     }
						
						
					}
				    break;
				    
				   } 
				    
				    Thread.sleep(1000);
				    a++;
				     
		                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='testtttt']/following-sibling::div//a//div"));
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
