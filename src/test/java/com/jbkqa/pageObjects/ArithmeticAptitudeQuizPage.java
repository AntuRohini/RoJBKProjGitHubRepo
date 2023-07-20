package com.jbkqa.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArithmeticAptitudeQuizPage {
	
WebDriver ldriver;
	
	public ArithmeticAptitudeQuizPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how=How.XPATH, using ="//a[contains(@href,'#Arithmetic-Aptitude')]")
	WebElement ArithmeticAptitudeTest;
	
	@FindBy(how=How.XPATH, using ="//button[contains(text(),'Next')]")
	WebElement Nextbutton;
	
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'Next')]")
	WebElement NextQuebtn;
	
	@FindBy(how=How.XPATH, using ="//a[@id='qsubmit']")
	WebElement QuizSubmit; 
	
	@FindBy(how=How.XPATH, using ="//button[text()='×']")
	WebElement closeQuizWindow;
	
	
	
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div//h3[text()='Arithmetic Aptitude']/following-sibling::div//a//div"))
    private List<WebElement> elements;

	
	
	public void clickArithmeticAptitudeTest() throws Exception
	{
		Thread.sleep(1500);
		ArithmeticAptitudeTest.click();
	}
	
	public void clickNextButton() throws Exception
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", Nextbutton);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Nextbutton));
        Actions action =new Actions(ldriver);
	    action.moveToElement(Nextbutton).click().build().perform();
	}
	public void clickNextQueBtn() throws Exception
	{
		Thread.sleep(1500);
		NextQuebtn.click();
	}
	
	public void clickQuizSubmit() throws Exception
	{
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", QuizSubmit);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(QuizSubmit));
        
		 
		QuizSubmit.click();
	}
	
	public void closeQuizWindow() throws Exception
	{
		Thread.sleep(1000);
		closeQuizWindow.click();
	}
	
	public void listOfQuiz() throws Exception
	{
		Thread.sleep(1500);
		for(WebElement eachQuizLink:elements)
		{
			//System.out.println(eachQuizLink.getText());
			eachQuizLink.click();
			clickNextButton();
			//closeQuizWindow();
			
	  }
	}

}
