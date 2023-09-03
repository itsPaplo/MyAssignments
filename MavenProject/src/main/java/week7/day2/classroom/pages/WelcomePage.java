package week7.day2.classroom.pages;

import org.openqa.selenium.By;
import  week7.day2.classroom.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods{
	
	public HomePage clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage();
	}

}
