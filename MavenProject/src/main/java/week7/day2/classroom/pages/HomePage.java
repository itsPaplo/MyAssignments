package week7.day2.classroom.pages;

import org.openqa.selenium.By;
import  week7.day2.classroom.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public LeadsPage clickLead() {
		driver.findElement(By.linkText("Leads")).click();
		return new LeadsPage();
	}

}
