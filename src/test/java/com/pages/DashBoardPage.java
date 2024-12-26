package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;

public class DashBoardPage {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]//li//a//span")
	List<WebElement> menuItems;

	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
	WebElement unameTxtBox;
	@FindBy(xpath = "(//i[contains(@class,'xd-select-text--arrow')])[1]")
	WebElement userRole;

	@FindBy(xpath = "(//i[contains(@class,'xd-select-text--arrow')])[2]")
	WebElement status;

	@FindBy(xpath = "//div[@role='option']//span")
	List<WebElement> statusOptions;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	List<WebElement> userROptions;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]")
	WebElement msg;

	public void listOfMenu() {
		System.out.println("Total Menu options: " + menuItems.size());

		for (WebElement item : menuItems) {
			System.out.println(item.getText());
			if (item.getText().contains("Admin")) {
				item.click();
				break;
			}
		}
	}

	public void searchEmployeeByUserName(String name) {
		System.out.println("Search Employee by userName");
		unameTxtBox.sendKeys(name);

		searchBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg.getText());
		driver.navigate().refresh();
	}

	public void searchEmployeeByUserRole(String role) {
		System.out.println("Search Employee by UserRole");
		userRole.click();
		for (WebElement i : userROptions) {
			if (i.getText().contains(role)) {
				i.click();
				break;
			}
		}
		searchBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(msg.getText());
		driver.navigate().refresh();
	}

	public void searchEmployeeByStatus(String Status) {
		System.out.println("Search Employee by status");
		status.click();
		for (WebElement ele : statusOptions) {
			if (ele.getText().contains(Status)) {
				ele.click();
				break;
			}
		}
		searchBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(msg.getText());
		
	}

	public void handleAlert() {
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

}
