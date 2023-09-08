package week7.day2.classroom.testcases;

import org.testng.annotations.Test;

import week7.day2.classroom.base.ProjectSpecificMethods;
import week7.day2.classroom.pages.*;

public class DeleteLeadsTC extends ProjectSpecificMethods{

	@Test
	public void runDelete() {
		new LoginPage().enterUsername().enterPassword().clickLogin().clickCRMSFA().clickLead().clickViewLeads().clickPhoneTab().enterPhoneNo().clickFindLeadsBtn();
		ViewLeads vl = new ViewLeads();
		String strdLead = vl.returnStoredFLId();
		System.out.println("strdLead" + strdLead);
		vl.clickFirstLeadId().clickDeleteBtn().clickViewLeads().sendLeadID(strdLead).clickFindLeadsBtn();
	}
}
