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
import com.jbkqa.pageObjects.Angular8QuizPage;

public class TC_25_Angular8QuizTestForAll_102025QueOptions extends BaseClass{
	
	@Test
	public void Angular8QuizTest()
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
			Angular8QuizPage angularQuiz = new Angular8QuizPage(driver);
			angularQuiz.clickAngular8Test();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
			
			List <WebElement> radio = driver.findElements(By.xpath("//input[@name='count' and @type='radio']"));
		   
			System.out.println("Total number of Angular-8 quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("Angular-8 quiz page").assignAuthor("Rohini")
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
						test.info("Angular-8 quiz started for "+value+" questions.");
						
						if(value.equalsIgnoreCase("10"))
						 {
							angularQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String angular8quiz = quizName.get(i).getText();
						    System.out.println("Angular-8 QUIZ start for 10 question: "+angular8quiz);
						    test.info("Angular-8 QUIZ start for 10 question: "+angular8quiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+angular8quiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,angular8quiz+value+"_Angular8_NoQueFound");
									test.fail("Angular-8 Quiz test failed for "+angular8quiz);
									angularQuiz.closeQuizWindow();
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
								test.info("Quiz started for "+angular8quiz+" Angular-8 Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   angularQuiz.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   angularQuiz.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=10)
								       {
									      captureScreenshot(driver,angular8quiz+"_Angular8_10QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("Angular-8 Quiz submitted for less than 10 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("Angular-8 quiz Test Pass for all "+queCount+" questions")	;
								       }
								     angularQuiz.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
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
							angularQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String angular8quiz = quizName.get(i).getText();
						    System.out.println("Angular-8 QUIZ start for 20 question: "+angular8quiz);
						    test.info("Angular-8 QUIZ start for 20 question: "+angular8quiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+angular8quiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,angular8quiz+value+"_Angular8_NoQueFound");
									test.fail("Angular-8 Quiz test failed for "+angular8quiz);
									angularQuiz.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
								 b++;
							     
					                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
					                takeQuizBtn.click();
					                loopThruNew = true;
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+angular8quiz+" Angular-8 Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   angularQuiz.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   angularQuiz.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=20)
								       {
									      captureScreenshot(driver,angular8quiz+"_Angular8_20QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("Angular-8 Quiz submitted for less than 20 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("Angular-8 Test Pass for all "+queCount+" questions")	;
								       }
								     angularQuiz.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     
								     
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
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
							angularQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String angular8quiz = quizName.get(i).getText();
						    System.out.println("Angular-8 QUIZ start for 25 question: "+angular8quiz);
						    test.info("Angular-8 QUIZ start for 25 question: "+angular8quiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+angular8quiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,angular8quiz+value+"_Angular8_NoQueFound");
									test.fail("Angular-8 Quiz test failed for "+angular8quiz);
									angularQuiz.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+angular8quiz+" Angular-8 Test.");
								
								for(int j=1;j<=num1-1;j++)
								{
									JavascriptExecutor js = (JavascriptExecutor)driver;
							        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
								   if(nextBtn.isDisplayed()==true)
								     {
							        
									   angularQuiz.clickNextQueBtn();
								        
								     }
								   
								} 
								   
								   
								   System.out.println("Submit button displayed.");
								   Thread.sleep(1000);
								   angularQuiz.clickQuizSubmit();
								   Thread.sleep(1500);
								   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
								   int numQue = Integer.parseInt(queCount);
								     if(numQue!=25)
								       {
									      captureScreenshot(driver,angular8quiz+"_Angular8_25QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("Angular-8 Quiz submitted for less than 25 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("Angular-8 Test Pass for all "+queCount+" questions")	;
								       }
								     angularQuiz.closeQuizWindow();
								     Thread.sleep(1500);
							
//								  ElementNotInteractableException.getMessage();
						               
								
								
						    }
							
							
					     }
						
						
					}
				    break;
				    
				   } 
				    
				    Thread.sleep(1000);
				    a++;
				     
		                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
		                loopThru = true;
				    
			      }
			     
			     break;

			 }
		}		
		 catch(Exception e)
		 {
			e.getStackTrace(); 
		 }
		
//		try {
//			driver.get(baseURL);
//		    LoginPage lp = new LoginPage(driver);
//		    lp.clickTestingQuiz();
//            lp.clickMavenQuiz();
//			lp.clickNextbtn();
//			lp.setUserMobile(userMobile);
//			lp.clickLogin();
//			lp.closeWindow();
//			Thread.sleep(1500);
//			Angular8QuizPage angularQuiz = new Angular8QuizPage(driver);
//			angularQuiz.clickAngular8Test();
//			Thread.sleep(1000);
//			int a = 0;
//			boolean loopThru = true;
//			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//p"));
//			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
//			
//			System.out.println("Total number of Angular-8 quiz are: "+takeQuiz.size());
//		
//			 ExtentTest test = extent.createTest("Angular-8 quiz page").assignAuthor("Rohini")
//					 .assignCategory("Regression Test cases").assignDevice("Mac");
//		    
//			 
//			while(loopThru)
//			 {
//				
//			     for(int i=a;i<takeQuiz.size();i++)
//			      {
//				    WebElement takeQuizBtn = takeQuiz.get(i);
//				    
//				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//  		            wait.until(ExpectedConditions.elementToBeClickable(takeQuizBtn));
//  		            Actions action =new Actions(driver);
//				    action.moveToElement(takeQuizBtn).click().build().perform();
//				    String optNum = driver.findElement(By.name("count")).getAttribute("value");
//				    angularQuiz.clickNextButton();
//				    Thread.sleep(1500);
//				    String angular8quiz = quizName.get(i).getText();
//				    System.out.println("Angular-8 QUIZ start for: "+angular8quiz);
//				    test.info("Angular-8 QUIZ start for: "+angular8quiz);
//				   
//				try
//				{
//					WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
//					WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
//					waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
//					boolean error = errorscr.isDisplayed();
//					test.fail("Captured error text displayed for No Questions Found for "+angular8quiz);
//					
//					
//					if(error==true)
//					{
//						captureScreenshot(driver,angular8quiz+"_Angular8_NoQueFound");
//						test.fail("Angular-8 Quiz test failed for "+angular8quiz);
//						angularQuiz.closeQuizWindow();
//				        Thread.sleep(1500);	
//					}
//					
//				}catch(Exception ElementNotInteractableException)
//				{
//					
//					Thread.sleep(1100);
//					WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
//					int num = Integer.parseInt(optNum);
//					System.out.println("Number of questions: "+num);
//					test.info("Quiz started for "+angular8quiz+" Angular-8 Test.");
//					
//					for(int j=1;j<=num-1;j++)
//					{
//						JavascriptExecutor js = (JavascriptExecutor)driver;
//				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
//					   if(nextBtn.isDisplayed()==true)
//					     {
//				        
//						   angularQuiz.clickNextQueBtn();
//					        
//					     }
//					   
//					} 
//					   
//					   
//						   System.out.println("Submit button displayed.");
//						   Thread.sleep(1000);
//						   angularQuiz.clickQuizSubmit();
//					   Thread.sleep(1500);
//					   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
//					   int numQue = Integer.parseInt(queCount);
//					     if(numQue!=10)
//					       {
//						      captureScreenshot(driver,angular8quiz+"_QuizSubmittedFor_"+queCount+"_que");
//						      test.fail("Angular-8 Quiz submitted for less than 10 questions. No of question found: "+queCount);
//	  				       }
//					     else 
//					       {
//					          test.pass("Angular-8 Test Pass for all "+queCount+" questions")	;
//					       }
//					     angularQuiz.closeQuizWindow();
//					     Thread.sleep(1500);
//					     
//					     a++;
//					     
//			                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
//			                loopThru = true;
//				
//					  ElementNotInteractableException.getMessage();
//			               
//					
//					
//			    }
//				
//				a++;
//			     
//                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Angular-8']/following-sibling::div//a//div"));
//                loopThru = true;
//			}
//			     
//			break;     
//	   }	
//			
//	 }		
//	 catch(Exception e)
//	 {
//		e.getStackTrace(); 
//	 }
	}

}
