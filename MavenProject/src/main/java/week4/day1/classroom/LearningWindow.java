package week4.day1.classroom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningWindow {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//li[contains(@class,'menu-list')]/a[contains(text(),'FLIG')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whlist = new ArrayList<String>(windowHandles);
		String childtitle = driver.switchTo().window(whlist.get(1)).getTitle();
		System.out.println("The new tab title is: " + childtitle);
		driver.switchTo().window(whlist.get(0)).close();
		
	}

}
