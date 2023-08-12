package week4.day1.classroom;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningFrames {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String ptxt = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(ptxt);		
	}
}
