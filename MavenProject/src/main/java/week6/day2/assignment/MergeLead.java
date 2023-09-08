package week6.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MergeLead extends BaseClass {
	
	@BeforeTest
	public void setExcel() {
		shtNm = "MergeLead";
	}

	@Test
	public void runMerge(String fromFnm, String toFnm) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Merge Leads']")))).click();
		String mcwh = driver.getWindowHandle();	

		//Clicking From Contacts widget
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")))).click();
		Set<String> whset = driver.getWindowHandles();
		List<String> whlst = new ArrayList<String>(whset);
		driver.switchTo().window(whlst.get(1));		

		//Clicking 1st resulting id
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='firstName']")))).sendKeys(fromFnm);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		WebElement frstLIDelem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]//a)[1]"))));
		String firstLID = frstLIDelem.getText();
		frstLIDelem.click();
		driver.switchTo().window(mcwh);			
		whset.clear();
		whlst.clear();

		//Clicking To Contacts widget
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")))).click();
		whset=driver.getWindowHandles();
		whlst.addAll(whset);
		driver.switchTo().window(whlst.get(1));	

		//Clicking 2nd resulting id
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='firstName']")))).sendKeys(toFnm);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]//a)[2]")))).click();
		driver.switchTo().window(mcwh);

		//Clicking Merge button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Merge']")))).click();

		//Handling Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Find Leads")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='id']")))).sendKeys(firstLID);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Find Leads']")))).click();
		String srchResult = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='x-paging-info']")))).getText();
		if(srchResult.contains("No records")) {
			System.out.println("Lead id: " + firstLID + " was Merged successfully");
		}
		else {
			System.out.println("Lead id was not Merged");	
		}

	}

}
