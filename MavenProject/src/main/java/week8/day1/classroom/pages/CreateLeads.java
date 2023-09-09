package week8.day1.classroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week8.day1.classroom.base.ProjectSpecificMethods;

public class CreateLeads extends ProjectSpecificMethods{
	
	public CreateLeads(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public CreateLeads enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		return new CreateLeads(driver);
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
		return new LeadsPage(driver);
		
	}
}
