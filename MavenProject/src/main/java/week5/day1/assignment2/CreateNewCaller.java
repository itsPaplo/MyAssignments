package week5.day1.assignment2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateNewCaller extends SnowBaseClass {
	
	@Test
	public void createCaller() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']"))).sendKeys("Callers");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='Callers']/parent::span"))).click();		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[text()='New']"))).click();	
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.first_name']"))).sendKeys(firstName);
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.last_name']"))).sendKeys("lname1");
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.title']"))).sendKeys("title1");
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.email']"))).sendKeys("testemail1@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.phone']"))).sendKeys("9988776655");
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.mobile_phone']"))).sendKeys("9900778866");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[contains(@class,'form_action_button')]"))).click();
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//div[@class='input-group']/input"))).sendKeys(firstName,Keys.ENTER);
		String clrdID = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//table[@id='sys_user_table']/tbody/tr/td[4]"))).getText();
		if(clrdID.contains(firstName)) {
			System.out.println("New Caller should be created with right values: PASS");
		}
		else {
			System.out.println("New Caller should be created with right values: FAIL");
		}
	}

}
