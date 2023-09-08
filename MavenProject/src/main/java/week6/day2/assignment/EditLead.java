package week6.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
	
	@BeforeTest
	public void setExcel() {
		shtNm = "EditLead";
	}

	@Test
	public void runEdit(String phn, String nwCmpnm) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Find Leads")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='phoneNumber']")))).sendKeys(phn);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]//a)[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Edit']")))).click();
		WebElement compNmElm = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'companyName')]"))));
		compNmElm.clear();
		compNmElm.sendKeys(nwCmpnm);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submitButton")))).click();
		String updtCmpnm = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")))).getText().replaceAll("^[a-zA-Z]", "");
		if(updtCmpnm.contains(nwCmpnm)) {
			System.out.println("The company name was updated correctly");
		}else
			System.out.println("The company name was not updated");
	}
}
