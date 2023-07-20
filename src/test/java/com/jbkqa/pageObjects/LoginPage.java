package com.jbkqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(@href,'#Testing')]")
	WebElement Testing;
	
	@FindBy(xpath="//div[@id='Testing']//p[contains(text(),'Maven')]")
	WebElement Maven;
	
	@FindBy(id="countbtn")
	WebElement nextbtn;
	
	@FindBy(id="loginmobile")
	WebElement enterMobile;
	
	@FindBy(id="loginbtn")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(@href,'/dashboard')]")
	WebElement dashboard;
	
	@FindBy(xpath="//a[contains(@href,'com/logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUP;
	
	@FindBy(xpath="//button[text()='×']")
	WebElement closeLoginWindow;
	
	public void clickTestingQuiz()
	{
		Testing.click();;
	}
	
	public void clickMavenQuiz() throws Exception
	{
		Thread.sleep(1500);
		Maven.click();;
	}
	
	public void clickNextbtn() throws Exception
	{
		Thread.sleep(2000);
		nextbtn.click();
	}
	public void setUserMobile(String umobile) throws Exception
	{
		Thread.sleep(2000);
		enterMobile.sendKeys(umobile);
	}
	
	public void clickLogin() throws Exception
	{
		Thread.sleep(2000);
		btnLogin.click();
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
	
	public void signUp() throws Exception
	{
		Thread.sleep(2000);
		signUP.click();
	}
	
	public void closeWindow() throws Exception
	{
		Thread.sleep(1500);
		closeLoginWindow.click();
	}

}
