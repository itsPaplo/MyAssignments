package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NykaaCheckoutValidation {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		WebElement brndElem = driver.findElement(By.xpath("//a[text()='brands']"));		
		Actions action = new Actions(driver);
		action.moveToElement(brndElem).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");

		WebElement srchsgsn = driver.findElement(By.xpath("//a[contains(text(),'Oreal')]"));
		action.click(srchsgsn).perform();
		String crntTitle = driver.getTitle();
		System.out.println('\n'+"TC01: After Selecting L'Oreal verify the page redirects to correct page: "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		if(crntTitle.contains("L'Oreal Paris")) {
			System.out.println("The page title:" + '"' + crntTitle +'"' + " matches with Expected title: PASS" + '\n');
		}
		else {
			System.out.println("The page title:" + '"' + crntTitle +'"' + " doesn't match with Expected title: FAIL" + '\n');
		}
		//Applying sort
		action.click(driver.findElement(By.xpath("//span[@class='sort-name']"))).perform();
		action.pause(1000).click(driver.findElement(By.xpath("//span[contains(text(),'top')]"))).perform();

		//Applying Category and click Hair->Click haircare->Shampoo filter		
		action.pause(1000).click(driver.findElement(By.xpath("//span[contains(text(),'Category')]/parent::div//*[name()='svg']//*[local-name()='path']"))).perform();
		action.pause(1000).click(driver.findElement(By.xpath("//span[text()='Hair']/parent::div"))).perform();
		action.pause(1000).click(driver.findElement(By.xpath("//span[contains(@class,'filter') and contains(text(),'Care')]/parent::div//*[name()='svg']//*[local-name()='path']"))).perform();
		action.pause(1000).click(driver.findElement(By.xpath("//span[text()='Shampoo']"))).perform();
		
		//Applying Concern->Color Protection filter
		action.pause(1000).click(driver.findElement(By.xpath("//span[text()='Concern']/parent::div//*[name()='svg']//*[local-name()='path']"))).perform();
		action.click(driver.findElement(By.xpath("//span[@class='title' and contains(text(),'Color')]"))).perform();
		
		//Verifying whether the selected filters are applied
		List<WebElement> fltrsappld = driver.findElements(By.xpath("//div[@id='filters-listing']//span[@class='filter-value']"));
		System.out.println('\n'+"TC02: After applying 2 filters verifying whether the selected filters are applied correctly: "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		System.out.print("The Number of filters applied are: " + "[" + fltrsappld.size()+ "]" + " the applied filters are: " );
		int count=0;
		for (WebElement fltrs : fltrsappld) {
			String fltrnm = fltrs.getText();
			System.out.print('"'+ fltrnm + '"' + " ");
			if(fltrnm.contains("Shampoo") || fltrnm.contains("Color Protection")) {
				count++;
			}			
		}
		if(count==2) {
			System.out.println("The selected 2 filters are applied correctly: PASS");
		}
		else {
			System.out.println("The selected 2 filters are not applied correctly: FAIL");
		}
		
		//Selecting the product in Gallery page
		action.pause(1000).click(driver.findElement(By.xpath("//div[contains(text(),'Paris Colour')]"))).perform();
		
		//Switching to new window
		Set<String> wh = driver.getWindowHandles();
		List<String> whlst = new ArrayList<String>(wh);
		driver.switchTo().window(whlst.get(1));
		
		//Getting the MRP
		action.click(driver.findElement(By.xpath("//span[text()='180ml']"))).perform();
		System.out.println("The Price of the product is: " + '\n'
				+ "MRP: " + driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText().replaceAll("[^a-zA-Z0-9]", ""));
		
		//Add to cart
		action.pause(1000).click(driver.findElement(By.xpath("(//span[contains(text(),'Add to')])[1]"))).perform();
		
		//Shopping cart
		action.pause(1000).click(driver.findElement(By.xpath("//button[@class='css-aesrxy']//*[name()='svg']//*[local-name()='path']"))).perform();		
		Thread.sleep(4000);
		driver.switchTo().frame(0);		
		
		//Getting Grand total
		String cartGrndttl = driver.findElement(By.xpath("//div[contains(@class,'footer')]//span")).getText();		
		System.out.println('\n'+"The Grand total of the product added to the cart is: " + '\n' + "Grand Total: " + cartGrndttl.replaceAll("[^a-zA-Z0-9]", ""));
		action.pause(1000).click(driver.findElement(By.xpath("(//div[contains(@class,'footer')]//*[name()='svg'])[2]//*[local-name()='path']"))).perform();
		driver.switchTo().defaultContent();
		
		//Continuing as guest to Checkout page
		action.pause(1000).click(driver.findElement(By.xpath("//button[contains(text(),'Continue')]"))).perform();
		action.pause(1000).click(driver.findElement(By.xpath("//div[contains(@class,'content-layout')]//span"))).perform();
		
		//Verifying Grand total in Checkout page with Cart page
		String chkoutGrndttl = driver.findElement(By.xpath("(//span[contains(@class,'leading')]/following-sibling::p)[2]")).getText();
		System.out.println('\n'+"TC03: Verify the price of the product in PDP page is same in Cart and Checout pages: "+
				'\n' + "---------------------------------------------------------------------------------------------------");
		if(chkoutGrndttl.contains(cartGrndttl)) {
			System.out.println("The Grand total from Payment page is same as the total in Checkout Page: PASS");
		}
		else {
			System.out.println("The Grand total from Payment page is not same as the total in Checkout Page: FAIL");
		}

		driver.quit();
	}
}
