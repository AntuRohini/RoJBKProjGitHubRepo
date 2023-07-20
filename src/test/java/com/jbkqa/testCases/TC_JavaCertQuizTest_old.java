package com.jbkqa.testCases;

import com.jbkqa.pageObjects.LoginPage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbkqa.pageObjects.JavaCertificationQuizPage;

public class TC_JavaCertQuizTest_old extends BaseClass{
	
	@Test
	public void JavaCertQuizTest()
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
				JavaCertificationQuizPage javacQuiz = new JavaCertificationQuizPage(driver);
				javacQuiz.clickJavaCertification();
				Thread.sleep(1000);
				//javacQuiz.listOfQuiz();
				List<WebElement> takeQuiz = driver.findElements(By.xpath("//div//h3[text()='Java Certification']/following-sibling::div//a//div"));
				System.out.println("Total Java Certification quiz are: "+takeQuiz.size());
				Iterator<WebElement> itr = takeQuiz.iterator();
				
				while(itr.hasNext()) 
				 {
				     for(int i=0;i<takeQuiz.size();i++)
				      {
					    WebElement takeQuizBtn = takeQuiz.get(i);
					    takeQuizBtn.click();
					    String optNum = driver.findElement(By.name("count")).getAttribute("value");
					    javacQuiz.clickNextButton();
					    Thread.sleep(1500);
					    ExtentTest test = extent.createTest("Java Certification quiz page").assignAuthor("Rohini")
								 .assignCategory("Regression Test cases").assignDevice("Mac");
					    
					try
					{
						
						boolean errorText = driver.findElement(By.xpath("//h3[contains(text(),'Sorry!!! No Questions Found ')]")).isDisplayed();
						test.fail("Captured error text displayed for No Questions Found");
						//WebElement nextBtn;
//						boolean nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]")).isDisplayed();
//						test.pass("Captured Next button on quiz window isdisplayed");
						if(errorText==true)
						{
							captureScreenshot(driver,"NoQueFound");
							test.fail("Quiz test failed.");
							javacQuiz.closeQuizWindow();
//							
//							nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
//							if(nextBtn.isDisplayed()==true)
//							{
//							test.info("Captured Next button on quiz window isdisplayed");
//							 JavascriptExecutor js = (JavascriptExecutor)driver;
//							 js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
//							 Thread.sleep(1500);
//							 //nextBtn.click();
//							 javacQuiz.clickNextQueBtn(); 
//							 //Thread.sleep(1500);
//							}
//							else
//							{
//								
//								javacQuiz.clickQuizSubmit();
//								
//							}
						}
						
					}catch(Exception ElementNotInteractableException)
					{
						WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
						int num = Integer.parseInt(optNum);
						System.out.println("Number of questions: "+num);
						test.info("Quiz started for java certification.");
						for(int j=1;j<=num-1;j++)
						{
						   if(nextBtn.isDisplayed()==true)
						     {
						        JavascriptExecutor js = (JavascriptExecutor)driver;
						        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
						        Thread.sleep(1000);
						        //nextBtn.click();
						        javacQuiz.clickNextQueBtn();
						        Thread.sleep(1000);
						     }
						} 
						   
						   
							   System.out.println("Submit button displayed.");
							   Thread.sleep(1000);
							   javacQuiz.clickQuizSubmit();
						   Thread.sleep(1500);
						   String queCount = driver.findElement(By.xpath("//p//span[@id='total']")).getText();
						     if(queCount!="10")
						       {
							      captureScreenshot(driver,"QuizSubmittedFor_"+queCount+"_que");
							      test.fail("Quiz submitted for less than 10 questions. No of question found: "+queCount);
		  				       }
						     else 
						       {
						          test.pass("TestPass for all "+queCount+" questions")	;
						       }
						     javacQuiz.closeQuizWindow();
						     
//						     a++;
//				                takeQuiz = driver.findElements(By.xpath(//div//h3[text()='Java Certification']/following-sibling::div//a//div));
//				                loopThru = true;
//						
						   ElementNotInteractableException.getMessage();
						
						
				    }
					
				}	
		   }
				
		 }		
		 catch(Exception e)
		 {
			e.getStackTrace(); 
		 }
	}

}
