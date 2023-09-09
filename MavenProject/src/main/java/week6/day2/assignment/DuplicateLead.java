package week6.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	
	@BeforeTest
	public void setExcel() {
		sheetname = "Phone";
	}

	@Test(dataProvider = "fetchTData")
	public void runDuplicate(String phn) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Find Leads")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='phoneNumber']")))).sendKeys(phn);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]//a)[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Duplicate Lead")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submitButton")))).click();
	}
}
