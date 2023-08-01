package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundCheckbox {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		//Basic Checkbox
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		
		//Notification
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		
		//Choose your favorite language(s)
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		
		//Tri State Checkbox
		WebElement trichk = driver.findElement(By.xpath("//div[contains(@id,'TriState') and contains(@class,'chkbox')]"));
		trichk.click();
		trichk.click();
		
		//Toggle Switch
		driver.findElement(By.xpath("//div[contains(@class,'slider')]")).click();
		
		//(//div[contains(@class,'selectbooleancheckbox')])[3]//input
		boolean chkbx = driver.findElement(By.xpath("(//div[contains(@class,'selectbooleancheckbox')])[3]//input")).isEnabled();
		if(chkbx==false) {
			System.out.println("Checkbox is disabled");
		}
		else {
			System.out.println("Checkbox is not disabled");
		}
		
		//Select Multiple
		driver.findElement(By.xpath("//div[contains(@class,'multiple')]")).click();
		driver.findElement(By.xpath("//li[contains(@class,'selectcheckboxmenu')]/label[contains(text(),'Paris')]")).click();
		driver.findElement(By.xpath("//li[contains(@class,'selectcheckboxmenu')]/label[contains(text(),'Barcelona')]")).click();
		
	}

}
