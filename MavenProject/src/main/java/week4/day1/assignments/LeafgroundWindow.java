package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeafgroundWindow {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		//TC01: Click and Confirm new Window Opens
		String prmtitle = driver.getTitle();
		Set<String> whset = driver.getWindowHandles();
		List<String> whlst = new ArrayList<String>(whset);
		String prmrtb = whlst.get(0);
		int intltbs = whset.size();		
		System.out.println('\n'+"TC01: Click and Confirm new Window Opens"+
				'\n'+"------------------------------------------------------------------");
		System.out.println("The initial number of tabs open are: " + '"' + intltbs + '"');
		System.out.println("The current open tab is: " + '"'+ prmtitle + '"' +'\n');
		driver.findElement(By.xpath("//span[text()='Open']/parent::button")).click();
		whset.clear();
		whlst.clear();
		whset=driver.getWindowHandles();
		whlst.addAll(whset);
		int crnttbs = whset.size();
		System.out.println("The current number of tabs open after clicking open button are: " + '"' + crnttbs + '"');		
		driver.switchTo().window(whlst.get(1));		
		System.out.println("The new tab title is: " + '"' + driver.getTitle() + '"');
		System.out.println("The current open tabs are: " + '"'+ prmtitle + '"' + ", " + '"'+ driver.getTitle() + '"'+'\n');
		if(crnttbs>intltbs) {
			System.out.println("Clicking the open button opened new tab: PASS"+'\n');
		}
		else {
			System.out.println("Clicking the open button failed to open new tab: FAIL"+'\n');
		}
		driver.close();
		driver.switchTo().window(prmrtb);

		//TC02: Find the number of opened tabs
		driver.findElement(By.xpath("//span[contains(text(),'Multi')]/parent::button")).click();
		whset.clear();
		whlst.clear();
		whset = driver.getWindowHandles();
		whlst.addAll(whset);
		System.out.println('\n'+"TC02: Find the number of opened tabs"+
				'\n'+"------------------------------------------------------------------");
		System.out.println("The number of tabs opened is: "+ whset.size()+'\n'); 

		for(int i=1;i<whlst.size();i++) {
			driver.switchTo().window(whlst.get(i));
			driver.close();
		}
		driver.switchTo().window(prmrtb);

		//TC03: Close all windows except Primary
		driver.findElement(By.xpath("//span[contains(text(),'Close')]/parent::button")).click();
		whset.clear();
		whlst.clear();
		whset = driver.getWindowHandles();
		whlst.addAll(whset);
		System.out.println('\n'+"TC03: Find the number of opened tabs"+
				'\n'+"------------------------------------------------------------------");
		System.out.println("Total number of open tabs are: "+ whset.size()+'\n'); 
		for(int i=1;i<whlst.size();i++) {
			driver.switchTo().window(whlst.get(i));
			driver.close();
		}
		driver.switchTo().window(prmrtb);

		//TC04: Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[contains(text(),'delay')]/parent::button")).click();
		whset.clear();
		whlst.clear();
		System.out.println('\n'+"TC04: Wait for 2 new tabs to open"+
				'\n'+"------------------------------------------------------------------");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		whset = driver.getWindowHandles();
		whlst.addAll(whset);
		System.out.println("Current number of tabs after waiting for tabs to open are: "+ whset.size()); 

		//close
		driver.quit();

	}
}
