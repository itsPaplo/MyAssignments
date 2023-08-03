package week2.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseThree {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Interacting with Hamburger menu
		driver.findElement(By.xpath("//div[@class='nav-icon']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Movie Lib')]")).click();
		Thread.sleep(3000);
		
		//Interacting with Choose your preference pop-up
		//Handling City Dropdown 
		driver.findElement(By.xpath("//label[text()='City']/parent::div")).click();
		Thread.sleep(400);
		WebElement cityelem = driver.findElement(By.xpath("//select[@name='city']"));
		Select citydd = new Select(cityelem);
		citydd.selectByVisibleText("Chennai");
		
		//Handling Genre Dropdown 
		driver.findElement(By.xpath("//label[text()='Genre']/parent::div")).click();
		Thread.sleep(400);
		WebElement genrelem = driver.findElement(By.xpath("//select[@name='genre']"));
		Select genrdd = new Select(genrelem);
		genrdd.selectByVisibleText("ANIMATION");
		
		//Handling Language Dropdown 
		driver.findElement(By.xpath("//label[text()='Language']/parent::div")).click();
		Thread.sleep(400);
		WebElement langelem = driver.findElement(By.xpath("//select[@name='lang']"));				
		Select langdd = new Select(langelem);
		langdd.selectByVisibleText("ENGLISH");		

		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		//Waiting for internal load to finish
		Thread.sleep(5000);
		
		//Selecting first lead movie result
		driver.findElement(By.xpath("(//div[contains(@class,'movie-wrapper')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();	
		
		//Filling out the details in Send request page
		//Handling Movie dropdown
		driver.findElement(By.xpath("//label[text()='Movie']/parent::div")).click();
		Thread.sleep(400);
		WebElement cinemelem = driver.findElement(By.xpath("//option[text()='Select Cinema']/parent::select"));
		Select cinemdd = new Select(cinemelem);
		cinemdd.selectByIndex(1);
		
		//Interacting with Date picker to select only first active element(day)
		driver.findElement(By.xpath("//label[contains(@class,'datepicker')]/parent::div")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("(//div[contains(@class,'calendar-days')]//span[not(contains(@class,'prev-month')) and not(contains(@class,'disabled'))])[1]")).click();

		//Handling Show time dropdown
		driver.findElement(By.xpath("//label[contains(text(),'Show Time')]/parent::div")).click();
		Thread.sleep(400);
		WebElement prftimeelem = driver.findElement(By.xpath("(//option[contains(text(),'AM')])[1]/parent::select"));
		Select prftmdd = new Select(prftimeelem);
		prftmdd.selectByIndex(1);
		
		//Entering number of seats
		driver.findElement(By.xpath("//label[contains(text(),'Seats')]/preceding-sibling::input")).sendKeys("2");
		//Entering Name
		driver.findElement(By.xpath("//label[text()='Name']/preceding-sibling::input")).sendKeys("Philip");
		//Entering Email
		driver.findElement(By.xpath("//label[text()='Email']/preceding-sibling::input")).sendKeys("testemail@gmail.com");
		//Entering Phone
		driver.findElement(By.xpath("//label[text()='Mobile']/preceding-sibling::input")).sendKeys("8989898989");
		//Handling F&B Dropdown
		driver.findElement(By.xpath("//label[contains(text(),'F&B')]/parent::div")).click();
		Thread.sleep(400);	
		WebElement fnbelem = driver.findElement(By.xpath("(//option[text()='Yes'])[1]/parent::select"));
		Select fnbdd = new Select(fnbelem);
		fnbdd.selectByIndex(1);
		
		//Entering Other Req
		Thread.sleep(400);
		driver.findElement(By.xpath("//label[contains(text(),'Other')]/preceding-sibling::input")).sendKeys("Other accomodation");
		
		//Interacting with copy to self checkbox
		driver.findElement(By.xpath("//label[contains(@class,'custom-radio')]")).click();
		
		//clicking Send request button
		driver.findElement(By.xpath("//button[contains(text(),'SEND REQ')]")).click();		
		Thread.sleep(600);	
		
		//clicking Cancel in OTP pop-up
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		Thread.sleep(300);
		
		//Dismissing Success band
		driver.findElement(By.xpath("//button[text()='×']")).click();
		
		//Fetching page current title
		String pgtitle = driver.getTitle();
		System.out.println("The page title after dismissing pop-up is: " + '"' + pgtitle + '"');

		driver.close();
	}

}
