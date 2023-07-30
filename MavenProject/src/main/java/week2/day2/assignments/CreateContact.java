package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();		
		driver.findElement(By.linkText("Contacts")).click();	
		driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();	
		driver.findElement(By.id("firstNameField")).sendKeys("TestFname1");
		driver.findElement(By.id("lastNameField")).sendKeys("TestLname1");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("TestFLname1");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("TestLLname1");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("TestDept1");
		driver.findElement(By.id("createContactForm_description")).sendKeys("TestDescription1: Loren ipsum");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testemail1@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select statedd = new Select(state);
		statedd.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Cleared Description field...");
		driver.findElement(By.xpath("//tr//input[@value='Update']")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "View Contact |";
		if(actualTitle.contains(expectedTitle)) {
			System.out.println("Contact details Description updated and landed on View contact page successfully");
		}else
			System.out.println("Title doesnt match after clicking update button");		
		
	}
}
