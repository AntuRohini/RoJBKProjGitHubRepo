package com.jbkqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PlacementPolicyQuizPage {
	
WebDriver ldriver;
	
	public PlacementPolicyQuizPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how=How.XPATH, using ="//a[contains(@href,'#Placement-Policy')]")
	WebElement PlacementPolicy;
	
	@FindBy(how=How.XPATH, using ="//p[contains(text(),'Placement Quiz')]")
	WebElement PlacementQuiz;
	
	@FindBy(how=How.XPATH, using ="//button[contains(text(),'Next')]")
	WebElement Nextbutton;
	
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'Next')]")
	WebElement NextQuebtn;
	
	@FindBy(how=How.XPATH, using ="//a[@id='qsubmit']")
	WebElement QuizSubmit;
	
	@FindBy(how=How.XPATH, using ="//button[text()='×']")
	WebElement closeQuizWindow;
	
//	@FindBy(how=How.XPATH, using ="//input[@value='20']")
//	WebElement clickRadiobtn20que;
	
	
	
	
	public void clickPlacementPolicyQuiz() throws Exception
	{
		Thread.sleep(1500);
		PlacementPolicy.click();
	}
	
	public void clickPlacementQuiz() throws Exception
	{
		Thread.sleep(1500);
		PlacementQuiz.click();
	}
	
	public void clickNextButton() throws Exception
	{
		Thread.sleep(1500);
		Nextbutton.click();
	}
	
	public void clickNextQueBtn() throws Exception
	{
		Thread.sleep(1500);
		NextQuebtn.click();
	}
	
	public void clickQuizSubmit() throws Exception
	{
		Thread.sleep(1500);
		QuizSubmit.click();
	}
	
	public void closeQuizWindow() throws Exception
	{
		Thread.sleep(1500);
		closeQuizWindow.click();
	}
	
//	public void selectQuiz20Que() throws Exception
//	{
//		Thread.sleep(1500);
//		clickRadiobtn20que.click();
//	}

}
