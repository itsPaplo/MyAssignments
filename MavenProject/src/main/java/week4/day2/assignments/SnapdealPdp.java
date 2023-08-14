package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealPdp {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		WebElement topCtgry = driver.findElement(By.xpath("//span[contains(@class,'cat') and contains(text(),'Men')]"));
		WebElement subCtgry = driver.findElement(By.xpath("(//div[contains(@class,'leftData')])[1]//span[contains(text(),'Sports')]"));
		Actions act = new Actions(driver);
		act.moveToElement(topCtgry).click(subCtgry).perform();

		System.out.println('\n'+"The Total number of Men's Sports Shoes in stock are: " + driver.findElement(By.xpath("//div[contains(text(),'Sports Shoes')]/following-sibling::div")).getText());
		act.click(driver.findElement(By.xpath("//div[contains(text(),'Running')]"))).perform();
		act.pause(600).click(driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]/i"))).perform();
		act.pause(500).click(driver.findElement(By.xpath("(//ul[contains(@class,'sort')]/li)[2]"))).perform();

		Thread.sleep(4000);
		List<WebElement> prclst = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		Set<String> prcvalset = new LinkedHashSet<String>();
		for(WebElement pl : prclst) {
			prcvalset.add(pl.getText().replaceAll("[^0-9]", ""));
		}
		List<String> nwprclst = new ArrayList<String>(prcvalset);
		int s=1, count=0;
		int frstPrc=0;
		int scndPrc=0;
		for(int i=0;i<nwprclst.size();i++) {
			if(s<nwprclst.size()) {
				frstPrc = Integer.parseInt(nwprclst.get(i));
				scndPrc = Integer.parseInt(nwprclst.get(s));
				if(frstPrc<scndPrc) {
					count++;s++;
				}
				else {
					break;
				}
			}
		}
		System.out.println('\n'+"TC01: After applying Sort by Low to High Price verifying if the Products are sorted properly "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		if(count==nwprclst.size()-1) {
			System.out.println("The products in gallery page are sorted in lowest to highest price order: PASS");
		}
		else {
			System.out.println("The products in gallery page are not sorted properly in lowest to highest price order: FAIL");
		}

		WebElement minPrc = driver.findElement(By.xpath("//input[@name='fromVal']"));
		minPrc.clear();
		minPrc.sendKeys("900",Keys.ENTER);
		WebElement maxPrc = driver.findElement(By.xpath("//input[@name='toVal']"));
		maxPrc.clear();
		maxPrc.sendKeys("1200",Keys.ENTER);
		Thread.sleep(2000);
		act.pause(1000).click(driver.findElement(By.xpath("(//button[contains(@class,'viewMoreFilter')])[1]"))).perform();
		act.pause(1000).click(driver.findElement(By.xpath("(//a[contains(text(),'Navy')])[1]"))).perform();
		Thread.sleep(3000);
		List<WebElement> appldFltrs = driver.findElements(By.xpath("(//div[@class='filters'])[1]//a"));
		System.out.println('\n'+"TC02: After applying two filters verifying whether the selected filters are applied correctly: "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		System.out.print("The Number of filters applied are: " + "[" + appldFltrs.size()+ "]" + " the applied filters are: " );
		int fltSize=0;
		for (WebElement fl : appldFltrs) {
			String flnm = fl.getText();
			System.out.print('"'+ flnm + '"' + " ");
			if((flnm.contains("900") && (flnm.contains("1200"))) || flnm.contains("Navy")) {
				fltSize++;
			}			
		}
		if(fltSize==2) {
			System.out.println('\n'+"The Selected two filters were applied correctly: PASS");
		}
		else {
			System.out.println('\n'+"The Selected two filters are not applied correctly: FAIL");
		}

		act.moveToElement(driver.findElement(By.xpath("(//p[@class='product-title'])[1]"))).perform();
		act.click(driver.findElement(By.xpath("(//div[contains(text(),'Quick')])[1]"))).perform();		
		Thread.sleep(3000);
		String mrpPrc = driver.findElement(By.xpath("//div[contains(@class,'product-desc-price')]/span")).getText();
		String dscntPrcnt = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println('\n'+ "The Original Cost of the product is: " + '"'+ mrpPrc + '"' + " current discount percentage is: " + '"'+ dscntPrcnt+ '"');

		File scrnsht = driver.getScreenshotAs(OutputType.FILE);
		File destn = new File("./snap/pic.jpg");
		FileUtils.copyFile(scrnsht, destn);	
		
		driver.findElement(By.xpath("//div[contains(@class,'close1')]")).click();
		driver.close();
	}
}
