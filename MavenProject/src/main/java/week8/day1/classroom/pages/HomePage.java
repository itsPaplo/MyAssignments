package week8.day1.classroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week8.day1.classroom.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public LeadsPage clickLead() {
		driver.findElement(By.linkText("Leads")).click();
		return new LeadsPage(driver);
	}

}
