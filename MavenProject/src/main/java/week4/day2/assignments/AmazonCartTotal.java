package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonCartTotal {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		WebElement srcBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Actions action = new Actions(driver);
		action.sendKeys(srcBox, "oneplus 9 pro",Keys.ENTER).perform();

		Thread.sleep(4000);
		String fsprdtPrice = driver.findElement(By.xpath("(//span[contains(@class,'price-whole')])[1]")).getText();
		//String rtng = driver.findElement(By.xpath("(//span[contains(text(),'stars')])[1]")).getText();
		String rtng = driver.findElement(By.xpath("(//div[@class='a-row a-size-small'])[1]/span")).getAttribute("aria-label");
		String ttlUsrs = driver.findElement(By.xpath("((//div[@class='a-row a-size-small'])[1]//span)[5]")).getText();
		System.out.println('\n'+"The Price of the first product is: " + fsprdtPrice);
		System.out.println("The Rating for the product is: " + '"' + rtng + '"' + " from total of :" + '"' + ttlUsrs + '"' + " users.");

		action.click(driver.findElement(By.xpath("(//div[@class='aok-relative'])[1]//a"))).perform();
		Set<String> wh = driver.getWindowHandles();
		List<String> whlst = new ArrayList<String>(wh);
		driver.switchTo().window(whlst.get(1));

		File scrns = driver.getScreenshotAs(OutputType.FILE);
		File dstin = new File("./snap/pic2.jpg");
		FileUtils.copyFile(scrns, dstin);	

		action.click(driver.findElement(By.xpath("//input[contains(@id,'cart-button')]"))).perform();
		Thread.sleep(4000);
		String crtPrice = driver.findElement(By.xpath("//span[contains(@id,'cart-subtotal')]")).getText();
		String crtVal = crtPrice.replaceAll("[^0-9]", "");
		String frstPrcval = fsprdtPrice.replaceAll("[^0-9]", "");	
		System.out.println('\n'+"TC01: Verify the price displayed in PDP page is same as in Cart page: "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		if(crtVal.contains(frstPrcval)) {
			System.out.println("The Price displayed in Cart is same as the price in gallery page: PASS");
		}
		else {
			System.out.println("The Price displayed in Cart is not same as the price in gallery page: FAIL");
		}

		driver.quit();
	}
}
