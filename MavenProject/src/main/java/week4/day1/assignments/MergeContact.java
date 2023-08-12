package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge')]")).click();
		String mcwh = driver.getWindowHandle();		
		
		//Clicking From Contacts widget
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		Set<String> whset = driver.getWindowHandles();
		List<String> whlst = new ArrayList<String>(whset);
		driver.switchTo().window(whlst.get(1));		
		
		//Clicking 1st resulting id
		driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a")).click();
		driver.switchTo().window(mcwh);			
		whset.clear();
		whlst.clear();
		
		//Clicking To Contacts widget
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		whset=driver.getWindowHandles();
		whlst.addAll(whset);
		driver.switchTo().window(whlst.get(1));	
		
		//Clicking 2nd resulting id
		driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[3]/a")).click();
		driver.switchTo().window(mcwh);
		
		//Clicking Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Handling Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String crntpage = driver.getTitle();
		
		//Verifying the page title after alert handling
		if(crntpage.contains("View Contact")) {
			System.out.println("Page title after merging contact: " + '"' + crntpage + '"');
			System.out.println("After accepting the alert(Merging contact) the application redirected to view contact page: PASS");
		}
		else {
			System.out.println("Page title after merging contact: " + '"' + crntpage + '"');
			System.out.println("After accepting the alert, the focus got redirected to another page: FAIL");
		}

	}
}
