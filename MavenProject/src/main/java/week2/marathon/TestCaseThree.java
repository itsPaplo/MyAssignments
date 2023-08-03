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

		driver.findElement(By.xpath("//div[@class='nav-icon']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Movie Lib')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='City']/parent::div")).click();
		Thread.sleep(400);
		WebElement cityelem = driver.findElement(By.xpath("//select[@name='city']"));
		Select citydd = new Select(cityelem);
		citydd.selectByVisibleText("Chennai");

		driver.findElement(By.xpath("//label[text()='Genre']/parent::div")).click();
		Thread.sleep(400);
		WebElement genrelem = driver.findElement(By.xpath("//select[@name='genre']"));
		Select genrdd = new Select(genrelem);
		genrdd.selectByVisibleText("ANIMATION");

		driver.findElement(By.xpath("//label[text()='Language']/parent::div")).click();
		Thread.sleep(400);
		WebElement langelem = driver.findElement(By.xpath("//select[@name='lang']"));				
		Select langdd = new Select(langelem);
		langdd.selectByVisibleText("ENGLISH");		


		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@class,'movie-wrapper')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();	

		driver.findElement(By.xpath("//label[text()='Movie']/parent::div")).click();
		Thread.sleep(400);

		WebElement cinemelem = driver.findElement(By.xpath("//option[text()='Select Cinema']/parent::select"));
		Select cinemdd = new Select(cinemelem);
		cinemdd.selectByIndex(1);

		driver.findElement(By.xpath("//label[contains(@class,'datepicker')]/parent::div")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("(//div[contains(@class,'calendar-days')]//span[not(contains(@class,'prev-month')) and not(contains(@class,'disabled'))])[1]")).click();

		driver.findElement(By.xpath("//label[contains(text(),'Show Time')]/parent::div")).click();
		Thread.sleep(400);

		WebElement prftimeelem = driver.findElement(By.xpath("(//option[contains(text(),'AM')])[1]/parent::select"));
		Select prftmdd = new Select(prftimeelem);
		prftmdd.selectByIndex(1);

		driver.findElement(By.xpath("//label[contains(text(),'Seats')]/preceding-sibling::input")).sendKeys("2");

		driver.findElement(By.xpath("//label[text()='Name']/preceding-sibling::input")).sendKeys("Philip");

		driver.findElement(By.xpath("//label[text()='Email']/preceding-sibling::input")).sendKeys("testemail@gmail.com");

		driver.findElement(By.xpath("//label[text()='Mobile']/preceding-sibling::input")).sendKeys("8989898989");

		driver.findElement(By.xpath("//label[contains(text(),'F&B')]/parent::div")).click();
		Thread.sleep(400);	

		WebElement fnbelem = driver.findElement(By.xpath("(//option[text()='Yes'])[1]/parent::select"));
		Select fnbdd = new Select(fnbelem);
		fnbdd.selectByIndex(1);

		Thread.sleep(400);
		driver.findElement(By.xpath("//label[contains(text(),'Other')]/preceding-sibling::input")).sendKeys("Other accomodation");

		driver.findElement(By.xpath("//label[contains(@class,'custom-radio')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'SEND REQ')]")).click();
		
		Thread.sleep(600);	
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='×']")).click();

		String pgtitle = driver.getTitle();
		System.out.println("The page title after dismissing pop-up is: " + '"' + pgtitle + '"');

		driver.close();
	}

}
