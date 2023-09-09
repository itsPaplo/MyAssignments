package week8.day1.classroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week8.day1.classroom.base.ProjectSpecificMethods;

public class CreateLeads extends ProjectSpecificMethods{
	
	public CreateLeads(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public CreateLeads enterCompanyName(String compNm) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compNm);
		return new CreateLeads(driver);
	}

	public CreateLeads enterFirstName(String frstNm) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(frstNm);
		return this;
	}
	
	public CreateLeads enterLastName(String lastNm) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastNm);
		return this;
	}
	
	public CreateLeads enterPhoneNo(String phn) {
		driver.findElement(By.xpath("//input[contains(@id,'primaryPhoneNumber')]")).sendKeys(phn);
		return this;
	}
	
	public LeadsPage clickSubmitBtn() {
		driver.findElement(By.name("submitButton")).click();
		return new LeadsPage(driver);
		
	}
}
