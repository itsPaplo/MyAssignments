package week6.day2.assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{

	

	@BeforeTest
	public void setExcel() {
		sheetname = "EditLead";		
	}
	

	@Test(dataProvider = "fetchTData")
	public void runEdit(String phn, String nwCmpnm) {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phn);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")))).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement compNmElm = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@id,'companyName')]"))));
		compNmElm.clear();
		compNmElm.sendKeys(nwCmpnm);
		driver.findElement(By.name("submitButton")).click();
		String updtCmpnm = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().replaceAll("^[a-zA-Z]", "");
		if(updtCmpnm.contains(nwCmpnm)) {
			System.out.println("The company name was updated correctly " + updtCmpnm);
		}else
			System.out.println("The company name was not updated " + updtCmpnm);
	}
}
