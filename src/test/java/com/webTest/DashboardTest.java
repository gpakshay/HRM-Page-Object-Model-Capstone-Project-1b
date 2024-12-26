package com.webTest;

import org.testng.annotations.Test;

public class DashboardTest extends BaseClass {
	
	@Test(priority=0)
	public void performLogin()
	  {
		 lpage.doLogin("Admin","admin123");
	  }

	@Test(priority=1)
	public void verifyAdmin() {
		dpage.listOfMenu();
	}
	
	@Test(priority=2)
	public void searchByUserName() {
		dpage.searchEmployeeByUserName("Admin");
	}
	
	@Test(priority=3)
	public void searchByUserRole() {
		dpage.searchEmployeeByUserRole("Admin");
	}
	
	@Test(priority=4)
	public void searchByStatus() {
		dpage.searchEmployeeByStatus("Enabled");
	}
}
