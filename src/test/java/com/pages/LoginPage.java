package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	//initialize driver
	public LoginPage(WebDriver driver)//Base class
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//by locator way
	@FindBy (name="username")
	WebElement unameTxtBox;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	public void doLogin(String userName,String pwd)
	{
		unameTxtBox.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	public String getAppTitle() {
		return driver.getTitle();
	}
	
	public String getAppURL() {
		return driver.getCurrentUrl();
	}
	
}
