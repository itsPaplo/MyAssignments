package week2.day2.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnXpath {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		//Attribute based
		driver.get("https://www.nykaa.com/");
		driver.findElement(By.xpath("//input[@name='search-suggestions-nykaa']"));
	
		//Text based 
		driver.get("https://www.swiggy.com/");
		driver.findElement(By.xpath("//span[text()='FIND FOOD']"));
		
		//Partial attribute based
		driver.get("https://www.axisbank.com/");
		driver.findElement(By.xpath("//div[contains(@class,'loginClk')]"));
		
		//Partial Text based
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//div[contains(@class,'loginClk')]"));
		
	}

}
