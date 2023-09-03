package week7.day2.classroom.testcases;

import org.testng.annotations.Test;

import  week7.day2.classroom.base.ProjectSpecificMethods;
import week7.day2.classroom.pages.LoginPage;

public class Login extends ProjectSpecificMethods{

	@Test	
	public void runLogin() {
		LoginPage lp = new LoginPage();
		lp.enterUsername().enterPassword().clickLogin();
		if(driver.getTitle().contains("My Home")) {
			System.out.println("Successfully logged in and langed in Home page");
		}
		else {
			System.out.println("Login failed or landed in wrong page");
		}
	}
}
