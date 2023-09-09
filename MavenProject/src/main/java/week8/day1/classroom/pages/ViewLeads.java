package week8.day1.classroom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week8.day1.classroom.base.ProjectSpecificMethods;

public class ViewLeads extends ProjectSpecificMethods{
	
	public ViewLeads(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public ViewLeads clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")).click();
		return this;
	}
	
	public ViewLeads enterPhoneNo() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
		return this;
	}

	public ViewLeads clickFindLeadsBtn() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("Click find button happened");
		return this;
	}
	
	public String returnStoredFLId() {
		System.out.println("Return method called:" +  driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText());
		return driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
	}
	
	public ViewLeads clickFirstLeadId() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
	}
	
	public LeadsPage clickDeleteBtn() {
		driver.findElement(By.linkText("Delete")).click();		
		return new LeadsPage(driver);
	}
	
	public ViewLeads sendLeadID(String leadId) {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		return this;
	}
}
