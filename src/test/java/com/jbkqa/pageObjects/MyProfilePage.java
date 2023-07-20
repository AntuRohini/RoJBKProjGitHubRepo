package com.jbkqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

WebDriver ldriver;
	
	public MyProfilePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(@href,'/dashboard')]")
	WebElement myAcc;
	
	@FindBy(xpath="//a[contains(@href,'/profile')]")
	WebElement viewProfile;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='updatebtn']")
	WebElement updateBtn;
	
//	@FindBy(xpath="//div[@id='msg']")
//	WebElement updateMsg;
	
	public void clickMyAcc()
	{
		myAcc.click();
	}
	
	public void clickViewProfile()
	{
		viewProfile.click();
	}
	
//	public void updateName()
//	{
//		name.clear();
//		name.sendKeys("Roh Rohankar");
//	}
	
	public void updateName()
	{
		name.clear();
		name.sendKeys("Ovee Rohankar");
	}
	
//	public void updateEmail()
//	{
//		email.clear();
//		email.sendKeys("Roh.Rohankar@gmail.com");
//	}
	
	public void updateEmail()
	{
		email.clear();
		email.sendKeys("Ovee.Rohankar@gmail.com");
	}
	
	public void updateMobile()
	{
		mobile.clear();
		mobile.sendKeys("8856789026");
	}
	
	public void clickUpdateBtn()
	{
		updateBtn.click();
	}
	
	
	
}
