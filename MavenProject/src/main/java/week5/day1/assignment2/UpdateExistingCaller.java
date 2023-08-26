package week5.day1.assignment2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class UpdateExistingCaller extends SnowBaseClass {
	
	@Test
	public void updateCaller() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']"))).sendKeys("Callers");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='Callers']/parent::span"))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));	
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//div[@class='input-group']/input"))).sendKeys(firstName,Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//table[@id='sys_user_table']/tbody/tr/td[3]/a"))).click();		
		WebElement bsnsPhone = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_user.phone']")));
		bsnsPhone.clear();		
		bsnsPhone.sendKeys(newbsnPhone);
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[@id='sysverb_update']"))).click();
		String ltsbsPhn = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//table[@id='sys_user_table']/tbody/tr/td[5]"))).getText().replaceAll("[^0-9]", "");
		if(ltsbsPhn.contains(newbsnPhone)) {
			System.out.println("New Business Phone number should be reflected: PASS");
		}
		else {
			System.out.println("New Business Phone number should be reflected: FAIL");
		}
	}

}
