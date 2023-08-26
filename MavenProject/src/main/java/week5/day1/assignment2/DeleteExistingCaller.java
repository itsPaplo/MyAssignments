package week5.day1.assignment2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DeleteExistingCaller extends SnowBaseClass {

	@Test
	public void deleteCaller() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']"))).sendKeys("Callers");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='Callers']/parent::span"))).click();		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));	
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//div[@class='input-group']/input"))).sendKeys(firstName,Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//table[@id='sys_user_table']/tbody/tr/td[3]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[@id='sysverb_delete_bottom']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[@id='ok_button']"))).click();
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//div[@class='input-group']/input"))).sendKeys(firstName,Keys.ENTER);
		String srchMsg = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//div[@class='list2_empty-state-list']"))).getText();
		if(srchMsg.contains("No records")) {
			System.out.println("Deleted caller should not be available: PASS");
		}
		else {
			System.out.println("Deleted caller should not be available: FAIL");
		}
	}
	
}
