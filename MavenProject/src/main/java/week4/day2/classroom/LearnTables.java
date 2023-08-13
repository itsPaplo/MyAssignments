package week4.day2.classroom;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTables {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		WebElement fromelem = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromelem.clear();
		fromelem.sendKeys("MAS",Keys.ENTER);
		WebElement toelem = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toelem.clear();
		toelem.sendKeys("CBE",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'TrainListHeader')]/tbody"));		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		
		for(int i=2;i<rows.size();i++) {
			System.out.println(driver.findElement(By.xpath("//table[contains(@class,'TrainListHeader')]/tbody/tr["+i+"]/td[2]")).getText());			
		}
	}
}
