package week4.day1.assignments;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCheckoutAlert {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		WebElement glryelem = driver.findElement(By.xpath("(//div[@class='owl-item active'])[1]//a"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(glryelem));
		glryelem.click();
		driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys("603201");
		driver.findElement(By.xpath("//div[contains(@class,'_btn')]/input")).click();
		driver.findElement(By.xpath("//button[contains(@id,'product-add')]")).click();
		driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();		
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		Alert chkoutalrt = driver.switchTo().alert();
		System.out.println("The Alert box which is handled is: " + '"'+ chkoutalrt.getText() + '"'); 
		chkoutalrt.accept(); 
		driver.close();		
	}
}
