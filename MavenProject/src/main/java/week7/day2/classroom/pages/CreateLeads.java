package week7.day2.classroom.pages;

import org.openqa.selenium.By;
import  week7.day2.classroom.base.ProjectSpecificMethods;

public class CreateLeads extends ProjectSpecificMethods{
	
	public CreateLeads enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		return new CreateLeads();
	}

	public CreateLeads enterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		return this;
	}
	
	public CreateLeads enterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		return this;
	}
	
	public LeadsPage clickSubmitBtn() {
		driver.findElement(By.name("submitButton")).click();
		return new LeadsPage();
		
	}
}
