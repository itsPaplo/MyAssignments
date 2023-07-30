package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutPage {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//label[text()='Password:']/following-sibling::input")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//a[@class='btn bg-warning']/preceding-sibling::button")).click();
		String expectedpagetitle = "ACME System 1";
		String actualpagetitle = driver.getTitle();
		
		if(actualpagetitle.contains(expectedpagetitle)) {
			System.out.println("Landing Page Title is: [" + actualpagetitle + "] matching");
		}else
			System.out.println("Landing Page Title is not matching");
		
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		driver.close();
		
	}
}
