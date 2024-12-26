package com.webTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lpage;
	public DashBoardPage dpage;
  
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lpage=new LoginPage(driver);
		dpage=new DashBoardPage(driver);
		 
	}
	
//	@BeforeClass
//	public void pageSetup()
//	{
//		System.out.println("Login Test");
//		lpage.doLogin("Admin","admin123");
//		
//	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
