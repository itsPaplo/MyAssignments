package week2.day2.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		WebElement iddElem = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select idd = new Select(iddElem);
		idd.selectByIndex(1);
		WebElement ownddElem = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select owdd = new Select(ownddElem);
		owdd.selectByValue("OWN_SCORP");
		
		
	}
}
	
	
