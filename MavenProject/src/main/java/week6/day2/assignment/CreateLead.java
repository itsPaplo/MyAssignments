package week6.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{

	@BeforeTest
	public void setExcel() {
		sheetname = "CreateLead";
	}

	@Test(dataProvider = "fetchTData")
	public void runCreate(String cmpnm, String fnm, String lnm, String phn) {	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Create Lead']")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'companyName')]")))).sendKeys(cmpnm);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'firstName')]")))).sendKeys(fnm);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")))).sendKeys(lnm);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'primaryPhoneNumber')]")))).sendKeys(phn);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submitButton")))).click();	
	}
}
