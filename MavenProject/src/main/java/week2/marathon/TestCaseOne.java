package week2.marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseOne {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
		//Selecting Starting point
		driver.findElement(By.xpath("//ul[contains(@class,'main-nav-pills')]//a[contains(@class,'nav-link') and contains(text(),'Bus')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Leaving')]/preceding-sibling::input[contains(@id,'source')]")).sendKeys("Chennai");
		Thread.sleep(300);		
		driver.findElement(By.xpath("//ul[contains(@class,'autocomplete ')]/li[text()='Chennai']")).click();
		
		//Selecting Destination point
		driver.findElement(By.xpath("//label[contains(text(),'Going')]/preceding-sibling::input[contains(@class,'autocomplete')]")).sendKeys("Bangalore");
		Thread.sleep(300);		
		driver.findElement(By.xpath("//ul[contains(@class,'autocomplete ')]/li[text()='Bangalore']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'pt-2')])[3]//input")).click();
		Thread.sleep(400);
		
		//Interacting with Date picker
		//updated to select only second [tomorrow's] selectable date 
		driver.findElement(By.xpath("(//td[not(contains(@class,'unselectable')) and not(contains(@class,'disabled'))])[2]")).click();
		
		//Initiating search
		driver.findElement(By.xpath("//a[text()='Search']")).click();		
		
		//Returning the First lead result
		String firstelem = driver.findElement(By.xpath("(//div[contains(@class,'search-column1')]/h2)[1]")).getText();
		System.out.println("The First resulting bus is : " + firstelem);	
		
		//Selecting Sleeper filter
		driver.findElement(By.xpath("//p[contains(text(),'SLEEP')]/parent::li")).click();
		Thread.sleep(400);
		
		//Fetching available seats after filter
		String availseats = driver.findElement(By.xpath("(//p[contains(@class,'AvailSts')])[1]")).getText();
		System.out.println("The Seats available are : " + availseats);		
		driver.findElement(By.xpath("(//span[contains(@class,'book')]/parent::a[contains(@class,'seatselect')])[1]")).click();
		Thread.sleep(400);
		
		//Selecting only the first available seat and printing its details
		//updated logic to get only available seats
		driver.findElement(By.xpath("(//li[contains(@class,'available') and not(contains(@class,'unavailable'))]/a)[1]")).click();		
		String seatnm = driver.findElement(By.xpath("//span[@id='seatnos']")).getText();
		System.out.println("The Seats number is : " + seatnm);		
		String fare = driver.findElement(By.xpath("//span[@id='ticketfare']")).getText();
		System.out.println("The Seats fare is : " + fare);	
		
		//Handling Boarding point dropdown
		WebElement bpelem = driver.findElement(By.xpath("//select[@id='boardingpoint_id']"));
		Select bpdd = new Select(bpelem);
		bpdd.selectByIndex(1);
		
		//Handling Dropping point dropdown
		WebElement drpelem = driver.findElement(By.xpath("//select[@id='droppingpoint_id']"));
		Select drpdd = new Select(drpelem);
		drpdd.selectByIndex(1);
		
		//Printing page title
		String pagetitle = driver.getTitle();
		System.out.println("The page title is : " + '"' + pagetitle + '"' );
		
		driver.close();	
		
	}
	
}
