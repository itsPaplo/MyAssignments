package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//span[text()='Email']/ancestor::a")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("testemail@gmail1.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		String actualfirstlead = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String actdupltitle = driver.getTitle();
		String expdupltitle = "Duplicate Lead | opentaps CRM";
		
		if(actdupltitle.contentEquals(expdupltitle)) {
			System.out.println("Page title for Duplicate lead is matching" );
		}
		else {
			System.out.println("Page title for Duplicate lead is not matching");
		}
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String actualduplicatename = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText(); 
		if(actualfirstlead.contentEquals(actualduplicatename)) {
			System.out.println("Duplicated Lead name is matching" );
		}
		else {			
			System.out.println("Page title for Duplicate lead is not matching" );
		}
		
		driver.close();
		
	}
}
