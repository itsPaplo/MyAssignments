package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

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
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf1");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Paplo");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("C");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Philip");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("TestDept1");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("TestDescription1: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testemail1@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "View Lead | opentaps CRM";
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Create Lead form works and redirects on View Leads page post creation");
		}
		else {
			System.out.println("Create Lead button not redirecting to expected page");
		}
		driver.close();
		
	}
	
}
