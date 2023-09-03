package week7.day2.classroom.pages;

import org.openqa.selenium.By;
import  week7.day2.classroom.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods{

	public CreateLeads clickCreateLeads() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeads();
		
	}
	
	public ViewLeads clickViewLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new ViewLeads();
	}
}
