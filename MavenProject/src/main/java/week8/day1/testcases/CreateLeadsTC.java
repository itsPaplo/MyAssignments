package week8.day1.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week8.day1.classroom.base.ProjectSpecificMethods;
import week8.day1.classroom.pages.LoginPage;

public class CreateLeadsTC extends ProjectSpecificMethods{

	@BeforeTest
	public void setSheet() {
		sheetNm = "CreateLead";
	}
	
	@Test (dataProvider="fetchTestData")
	public void runCreate(String compName, String firstNm, String lastNm, String phone) {
		new LoginPage(driver).enterUsername().enterPassword().clickLogin().clickCRMSFA()
		.clickLead().clickCreateLeads().enterCompanyName(compName).enterFirstName(firstNm).enterLastName(lastNm).enterPhoneNo(phone).clickSubmitBtn();

	}

}
