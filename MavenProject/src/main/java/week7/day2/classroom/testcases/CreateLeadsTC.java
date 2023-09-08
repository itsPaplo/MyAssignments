package week7.day2.classroom.testcases;

import org.testng.annotations.Test;

import week7.day2.classroom.base.ProjectSpecificMethods;
import week7.day2.classroom.pages.LoginPage;

public class CreateLeadsTC extends ProjectSpecificMethods{
	
	@Test
	public void runCreate() {
		LoginPage lp = new LoginPage();
		lp.enterUsername().enterPassword().clickLogin().clickCRMSFA();
		
	}

}
