package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountFaceBook {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]/a[contains(text(),'Create')]")).click();
		driver.findElement(By.xpath("//i[contains(@class,'_5dbc')]/preceding-sibling::input")).sendKeys("Philip");
		//driver.findElement(By.xpath("//div[contains(@class,'uiSticky')]/input[@id='u_w_d_FT']")).sendKeys("Cccccc");
		driver.findElement(By.xpath("//input[contains(@name,'last')]")).sendKeys("Cccccc");
		driver.findElement(By.xpath("//div[contains(@class,'uiStickyPlace')]/input[contains(@name,'reg_email')]")).sendKeys("8989898980");
		driver.findElement(By.xpath("//div[contains(text(),'password')]/following-sibling::input[contains(@id,'pass')]")).sendKeys("password@1");
		
		WebElement daydob = driver.findElement(By.xpath("//select[@id='day']"));
		Select daydd = new Select(daydob);
		daydd.selectByIndex(2);
		
		WebElement monthdob = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthdd = new Select(monthdob);
		monthdd.selectByValue("11");
		
		WebElement yeardob = driver.findElement(By.xpath("//select[@id='year']"));
		Select yeardd = new Select(yeardob);
		yeardd.selectByVisibleText("1990");
		
		//driver.findElement(By.xpath("(//label[contains(text(),'Female')]/following-sibling::input")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
	}

}
