package week2.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseTwo {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Initiating a search with keyword 'Bags' and selecting the bags for boys suggestion
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		Thread.sleep(400);		
		driver.findElement(By.xpath("//span[contains(text(),'boys')]/parent::div[contains(@class,'suggestion')]")).click();
		
		//printing total matching results and the search term
		String srchrslt = driver.findElement(By.xpath("(//span[contains(text(),'bags for')])[1]/preceding-sibling::span[contains(text(),'result')]")).getText();
		String srchtxt = driver.findElement(By.xpath("(//span[contains(text(),'bags for')])[1]")).getText();
		System.out.println("The total number of matching results are: " + srchrslt + " " + srchtxt);

		//selecting the first two Brands
		driver.findElement(By.xpath("(//div[contains(@id,'brand')]//input)[1]/parent::label")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[contains(@id,'brand')]//input)[2]/parent::label")).click();
		Thread.sleep(300);
		
		//Handing sort dropdown
		driver.findElement(By.xpath("//label[contains(@class,'dropdown')]/parent::span")).click();
		Thread.sleep(300);	
		
		//Selecting Newest option from dropdown
		driver.findElement(By.xpath("//a[contains(text(),'Newest')]")).click();
		Thread.sleep(400);
		
		//Getting the details of first leading result after sort
		String firstresnm = driver.findElement(By.xpath("((//div[contains(@class,'instructions')])[1]//span)[2]")).getText();
		System.out.println("The Name of the first product in newest arrivals is: " + '"' + firstresnm + '"');
		String firstresprice = driver.findElement(By.xpath("(//span[contains(@class,'price-whole')])[1]")).getText();
		System.out.println("The Price of the first product in newest arrivals is: " + '"' + firstresprice + '"');
		
		//Printing current page title
		String gptitle = driver.getTitle();
		System.out.println("The current Gallery page title is: " + '"' +gptitle + '"');
		
		driver.close();

	}

}
