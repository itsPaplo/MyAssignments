package week8.day1.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week8.day1.classroom.base.ProjectSpecificMethods;
import week8.day1.classroom.pages.LoginPage;

public class LoginTC extends ProjectSpecificMethods{

	@Test
	public void runLogin() {
		new LoginPage(driver).enterUsername().enterPassword().clickLogin().clickCRMSFA();
		if(driver.getTitle().contains("My Home")) {
			System.out.println("Successfully logged in and langed in Home page");
		}
		else {
			System.out.println("Login failed or landed in wrong page");
		}		
	}
}
