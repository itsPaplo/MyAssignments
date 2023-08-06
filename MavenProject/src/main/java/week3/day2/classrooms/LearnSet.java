package week3.day2.classrooms;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnSet {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones",Keys.ENTER);	
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Set<String> priceset = new LinkedHashSet<String>();
		for(int i =0;i<pricelist.size();i++) {
			priceset.add(pricelist.get(i).getText());
		}
		
		for (String item : priceset ){
			
			System.out.println(item);
			
		}
		
		
	}

}
