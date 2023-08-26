package week6.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@BeforeTest
	public void setSheet() {
		sheetname = "names";
	}

	@Test(dataProvider = "fetchTData")
	public void runCreate(String cname, String fname, String lname) {		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Leads")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Create Lead")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("createLeadForm_companyName")))).sendKeys(cname);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("createLeadForm_firstName")))).sendKeys(fname);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("createLeadForm_lastName")))).sendKeys(lname);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submitButton")))).click();
	}
}



