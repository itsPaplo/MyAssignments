package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("testlead");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		String actuatpagetitle = driver.getTitle();
		String exppagetitle = "View Lead | opentaps CRM";
		
		if(actuatpagetitle.contentEquals(exppagetitle)) {
			System.out.println("Page title for view lead is matching" );
		}
		else {
			System.out.println("Page title for view lead is not matching");			
		}	
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		String newcompname = "org.TestLeaf";	
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@name='companyName']")).clear();
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@name='companyName']")).sendKeys(newcompname);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String actualupdtcompname = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();

		if(actualupdtcompname.contains(newcompname)) {
			System.out.println("Company name is updated successfully");
		}
		else {
			System.out.println("Update failed");
		}
		driver.close();
	}
}
