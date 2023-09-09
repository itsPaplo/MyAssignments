package week8.day1.testcases;

import org.testng.annotations.Test;

import week8.day1.classroom.base.ProjectSpecificMethods;
import week8.day1.classroom.pages.LoginPage;

public class CreateLeadsTC extends ProjectSpecificMethods{

	@Test
	public void runCreate() {
		new LoginPage(driver).enterUsername().enterPassword().clickLogin().clickCRMSFA()
		.clickLead().clickCreateLeads().enterCompanyName().enterFirstName().enterLastName().clickSubmitBtn();

	}

}
