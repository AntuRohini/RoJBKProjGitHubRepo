package com.jbkqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver ldriver;
	
	public SignUpPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(@href,'#Placement-Policy')]")
	WebElement placementPolicy;
	
	@FindBy(xpath="//div[@id='Placement-Policy']//p[contains(text(),'Placement Quiz')]")
	WebElement placementQuiz;
	
	@FindBy(id="countbtn")
	WebElement nextbtn;
	
//	@FindBy(id="//a[@id='signup-tab']")
//	WebElement signUp;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@id='emailbtn']")
	WebElement proceed;

	@FindBy(xpath="//a[contains(@href,'terms-and-conditions')]")
	WebElement termsConditions;
	
	@FindBy(xpath="//a[contains(@href,'/dashboard')]")
	WebElement dashboard;
	
	@FindBy(xpath="//a[contains(@href,'com/logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUP;
	
//	@FindBy(xpath="//button[text()='×']")
//	WebElement closeLoginWindow;
//	
	public void clickplacementPolicy()
	{
		placementPolicy.click();;
	}
	
	public void clickplacementQuiz() throws Exception
	{
		Thread.sleep(1500);
		placementQuiz.click();;
	}
	
	public void clickNextbtn() throws Exception
	{
		Thread.sleep(2000);
		nextbtn.click();
	}
	public void clickSignUp() throws Exception
	{
		Thread.sleep(2000);
		signUP.click();
	}
	
	public void setName(String uName) throws Exception
	{
		Thread.sleep(2000);
		name.sendKeys(uName);
	}
	
	public void setEmail(String uEmail) throws Exception
	{
		Thread.sleep(2000);
		email.sendKeys(uEmail);
	}
	
	public void setMobile(String uMobile) throws Exception
	{
		Thread.sleep(2000);
		mobile.sendKeys(uMobile);
	}
	
	public void clickAgree() throws Exception
	{
		Thread.sleep(2000);
		agree.click();
	}
	
	public void clickProceed() throws Exception
	{
		Thread.sleep(2000);
		proceed.click();
	}
	
	public void clicktermsConditions() throws InterruptedException
	{
		Thread.sleep(1000);
		termsConditions.click();
	}
	public void dashboardPage() throws Exception
	{
		Thread.sleep(2000);
		dashboard.click();
	}
	
	public void logout() throws Exception
	{
		Thread.sleep(2000);
		logout.click();
	}
	
	
	
	

}
