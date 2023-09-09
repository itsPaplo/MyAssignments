package week6.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{
	
	@BeforeTest
	public void setExcel() {
		sheetname = "Phone";
	}

	@Test(dataProvider = "fetchTData")
	public void runDelete(String phn) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Find Leads")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='phoneNumber']")))).sendKeys(phn);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		WebElement firstElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]//a)[1]"))));
		String firstLeadId = firstElem.getText();
		firstElem.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Delete']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Find Leads")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='id']")))).sendKeys(firstLeadId);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		String srchResult = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='x-paging-info']")))).getText();
		if(srchResult.contains("No records")) {
			System.out.println("Lead id: " + firstLeadId + " was deleted successfully");
		}
		else {
			System.out.println("Lead id is not deleted");	
		}

	}

}
