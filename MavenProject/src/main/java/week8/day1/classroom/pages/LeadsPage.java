package week8.day1.classroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week8.day1.classroom.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods{

	public LeadsPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public CreateLeads clickCreateLeads() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeads(driver);
		
	}
	
	public ViewLeads clickViewLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new ViewLeads(driver);
	}
}
