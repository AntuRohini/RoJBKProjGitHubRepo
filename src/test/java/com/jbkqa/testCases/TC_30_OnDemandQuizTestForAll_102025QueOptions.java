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

public class TC_30_OnDemandQuizTestForAll_102025QueOptions extends BaseClass{
	
	@Test
	public void OnDemandQuizTest() throws Exception
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
			OnDemandTestQuizPage onDemandQuiz = new OnDemandTestQuizPage(driver);
			onDemandQuiz.clickOnDemandTest();
			Thread.sleep(1000);
			int a = 0;
			boolean loopThru = true;
			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//p"));
			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
			
			List <WebElement> radio = driver.findElements(By.xpath("//input[@name='count' and @type='radio']"));
		   
			System.out.println("Total number of On Demand Test quiz are: "+takeQuiz.size());
		
			 ExtentTest test = extent.createTest("On Demand Test quiz page").assignAuthor("Rohini")
					 .assignCategory("Regression Test cases").assignDevice("Mac");
		    
			 
			 while(loopThru)
			 {
				
			     for(int i=a;i<takeQuiz.size();i++)
			      {
			    	 
			    	// WebElement takeQuizBtn = takeQuiz.get(i);
//					    
//					    JavascriptExecutor takeQuejs = (JavascriptExecutor)driver;
//					    //takeQuejs.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
//					    takeQuejs.executeScript("window.scrollBy(0,-2000);", takeQuizBtn);
//					    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//					    wait.until(ExpectedConditions.elementToBeClickable(takeQuizBtn));
//					   // wait.until(ExpectedConditions.visibilityOf(takeQuizBtn));
//	  		         
//	  		            Actions action =new Actions(driver);
//	  		            action.moveToElement(takeQuizBtn).click().build().perform();
////	  		            action.click(takeQuizBtn).click().build().perform();
//	  		         // action.scrollToElement(takeQuizBtn).click().build().perform();
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
				    WebElement takeQuizBtn = takeQuiz.get(i);
				    JavascriptExecutor takeQuejs = (JavascriptExecutor)driver;
//				    //takeQuejs.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
				    takeQuejs.executeScript("window.scrollBy(0,-2000);", takeQuizBtn);
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
						test.info("On Demand Test quiz started for "+value+" questions.");
						
						if(value.equalsIgnoreCase("10"))
						 {
							onDemandQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String onDemandquiz = quizName.get(i).getText();
						    System.out.println("On Demand Test QUIZ start for 10 question: "+onDemandquiz);
						    test.info("On Demand Test QUIZ start for 10 question: "+onDemandquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+onDemandquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,onDemandquiz+value+"_OnDemand_NoQueFound");
									test.fail("On Demand Test Quiz test failed for "+onDemandquiz);
									onDemandQuiz.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
								 b++;
							     
					                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
					                takeQuizBtn.click();
					                loopThruNew = true;
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+onDemandquiz+" On Demand Test.");
								
								for(int j=1;j<=num1-1;j++)
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
									      captureScreenshot(driver,onDemandquiz+"_OnDemand_10QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("On Demand Test Quiz submitted for less than 10 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("On Demand Test quiz Test Pass for all "+queCount+" questions")	;
								       }
								     onDemandQuiz.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
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
							onDemandQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String onDemandquiz = quizName.get(i).getText();
						    System.out.println("On Demand Test QUIZ start for 20 question: "+onDemandquiz);
						    test.info("On Demand Test QUIZ start for 20 question: "+onDemandquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+onDemandquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,onDemandquiz+value+"_OnDemand_NoQueFound");
									test.fail("On Demand Test Quiz test failed for "+onDemandquiz);
									onDemandQuiz.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
								 b++;
							     
					                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
					                takeQuizBtn.click();
					                loopThruNew = true;
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+onDemandquiz+" On Demand Test.");
								
								for(int j=1;j<=num1-1;j++)
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
								     if(numQue!=20)
								       {
									      captureScreenshot(driver,onDemandquiz+"_OnDemand_20QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("On Demand Test Quiz submitted for less than 20 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("On Demand Test Test Pass for all "+queCount+" questions")	;
								       }
								     onDemandQuiz.closeQuizWindow();
								     Thread.sleep(1500);
								     
								     
								     
								     
								     b++;
								     
						                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
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
							onDemandQuiz.clickNextButton();
						    Thread.sleep(1500);
						    String onDemandquiz = quizName.get(i).getText();
						    System.out.println("On Demand Test QUIZ start for 25 question: "+onDemandquiz);
						    test.info("On Demand Test QUIZ start for 25 question: "+onDemandquiz);
						    
						    try
							{
								WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
								WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
								waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
								boolean error = errorscr.isDisplayed();
								test.fail("Captured error text displayed for No Questions Found for "+onDemandquiz);
								
								
								if(error==true)
								{
									captureScreenshot(driver,onDemandquiz+value+"_OnDemand_NoQueFound");
									test.fail("On Demand Test Quiz test failed for "+onDemandquiz);
									onDemandQuiz.closeQuizWindow();
							        Thread.sleep(1500);	
								}
								
							}catch(Exception ElementNotInteractableException)
							{
								
								Thread.sleep(1100);
								WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
								int num1 = Integer.parseInt(value);
								System.out.println("Number of questions: "+num1);
								test.info("Quiz started for "+onDemandquiz+" On Demand Test.");
								
								for(int j=1;j<=num1-1;j++)
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
								     if(numQue!=25)
								       {
									      captureScreenshot(driver,onDemandquiz+"_OnDemand_25QueQuizSubmittedFor_"+queCount+"_que");
									      test.fail("On Demand Test Quiz submitted for less than 25 questions. No of question found: "+queCount);
				  				       }
								     else 
								       {
								          test.pass("On Demand Test Test Pass for all "+queCount+" questions")	;
								       }
								     onDemandQuiz.closeQuizWindow();
								     Thread.sleep(1500);
							
//								  ElementNotInteractableException.getMessage();
						               
								
								
						    }
							
							
					     }
						
						
					}
				    break;
				    
				   } 
				    
				    Thread.sleep(1000);
				    a++;
				     
		                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
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
//			OnDemandTestQuizPage onDemandQuiz = new OnDemandTestQuizPage(driver);
//			onDemandQuiz.clickOnDemandTest();
//			Thread.sleep(1000);
//			int a = 0;
//			boolean loopThru = true;
//			List<WebElement> quizName = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//p"));
//			List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
//			
//			System.out.println("Total number of On Demand Test quiz are: "+takeQuiz.size());
//		
//			 ExtentTest test = extent.createTest("On Demand Test quiz page").assignAuthor("Rohini")
//					 .assignCategory("Regression Test cases").assignDevice("Mac");
//		     
//			while(loopThru)
//			 {
//				
//			     for(int i=a;i<takeQuiz.size();i++)
//			      {
//				    
//			    	 WebElement takeQuizBtn = takeQuiz.get(i);
//				    
//				    JavascriptExecutor takeQuejs = (JavascriptExecutor)driver;
//				    //takeQuejs.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
//				    takeQuejs.executeScript("window.scrollBy(0,-2000);", takeQuizBtn);
//				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//				    wait.until(ExpectedConditions.elementToBeClickable(takeQuizBtn));
//				   // wait.until(ExpectedConditions.visibilityOf(takeQuizBtn));
//  		         
//  		            Actions action =new Actions(driver);
//  		            action.moveToElement(takeQuizBtn).click().build().perform();
////  		            action.click(takeQuizBtn).click().build().perform();
//  		         // action.scrollToElement(takeQuizBtn).click().build().perform();
//				    Thread.sleep(1000);
//				    String optNum = driver.findElement(By.name("count")).getAttribute("value");
//				    Thread.sleep(2000);
//				    onDemandQuiz.clickNextButton();
//				    Thread.sleep(1500);
//				    String onDemandquiz = quizName.get(i).getText();
//				    System.out.println("On Demand Test QUIZ start for: "+onDemandquiz);
//				    test.info("On Demand Test QUIZ start for: "+onDemandquiz);
//				   
//				try
//				{
//					WebElement errorscr = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]"));
//					WebDriverWait waiterr = new WebDriverWait(driver, Duration.ofSeconds(10));
//					waiterr.until(ExpectedConditions.elementToBeClickable(errorscr));
//					boolean error = errorscr.isDisplayed();
//					test.fail("Captured error text displayed for No Questions Found for "+onDemandquiz);
//					
//					
//					if(error==true)
//					{
//						captureScreenshot(driver,onDemandquiz+"_onDemand_NoQueFound");
//						test.fail("On Demand Quiz test failed for "+onDemandquiz);
//						onDemandQuiz.closeQuizWindow();
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
//					test.info("Quiz started for "+onDemandquiz+" On Demand Test.");
//					
//					for(int j=1;j<=num-1;j++)
//					{
//						JavascriptExecutor js = (JavascriptExecutor)driver;
//				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
//					   if(nextBtn.isDisplayed()==true)
//					     {
//				        
//						   onDemandQuiz.clickNextQueBtn();
//					        
//					     }
//					   
//					} 
//					   
//					   
//					   System.out.println("Submit button displayed.");
//					   Thread.sleep(1000);
//					   onDemandQuiz.clickQuizSubmit();
//					   Thread.sleep(1500);
//					   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
//					   int numQue = Integer.parseInt(queCount);
//					     if(numQue!=10)
//					       {
//						      captureScreenshot(driver,onDemandquiz+"_QuizSubmittedFor_"+queCount+"_que");
//						      test.fail("On Demand Test Quiz submitted for less than 10 questions. No of question found: "+queCount);
//	  				       }
//					     else 
//					       {
//					          test.pass("On Demand Test Pass for all "+queCount+" questions")	;
//					       }
//					     onDemandQuiz.closeQuizWindow();
//					     Thread.sleep(1500);
//					     
//					     a++;
//					     
//			                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
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
//                takeQuiz = driver.findElements(By.xpath("//div//h3[text()='On Demand Test']/following-sibling::div//a//div"));
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
