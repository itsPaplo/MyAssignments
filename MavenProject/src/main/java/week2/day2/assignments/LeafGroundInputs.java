package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundInputs {

	public static String convertMonth(String m) {
		String month = m.toLowerCase();
		if (month.contains("jan")) {
			return "01"; 
		}
		if (month.contains("feb")) { 
			return "02"; 
		}
		if (month.contains("mar")) { 
			return "03";
		}
		if (month.contains("apr")) {
			return "04"; 
		}
		if (month.contains("may")) {
			return "05";
		}
		if (month.contains("jun")) { 
			return "06"; 
		}
		if (month.contains("jul")) { 
			return "07"; 
		}
		if (month.contains("aug")) {
			return "08"; 
		}
		if (month.contains("sep")) { 
			return "09"; 
		}
		if (month.contains("oct")) { 
			return "10";
		}
		if (month.contains("nov")) { 
			return "11"; 
		}
		if (month.contains("dec")) {
			return "12";
		}
		return "";
	}

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		//Type your name
		driver.findElement(By.xpath("(//div[@class='col-12']/input)[1]")).sendKeys("Testname1");

		//Append Country to this City
		driver.findElement(By.xpath("(//div[@class='col-12']/input)[2]")).sendKeys(" India");

		//Verify if text box is disabled
		boolean enabled = driver.findElement(By.xpath("(//div[@class='col-12']/input)[3]")).isEnabled();
		System.out.println('\n' + "TC01: Verify if text box is disabled:" + '\n' + "-------------------------------------------------------------------------");
		if(enabled == false) {
			System.out.println("This input field is disabled: PASS"+ '\n');
		}else
			System.out.println("This input field is enabled: FAIL" + '\n');

		//Retrieve the typed text.
		driver.findElement(By.xpath("(//div[@class='col-12']/input)[4]")).clear();
		String enteredtext = driver.findElement(By.xpath("(//div[@class='col-12']/input)[5]")).getAttribute("value");
		System.out.println('\n' + enteredtext+ '\n');

		//TC02: Type email and Tab. Confirm control moved to next element.
		WebElement emailinput = driver.findElement(By.xpath("(//div[@class='col-12']/input)[6]"));
		String email = emailinput.getAttribute("placeholder");
		emailinput.sendKeys("testmail@gmail.com");
		emailinput.sendKeys(Keys.TAB);
		WebElement typeinput = driver.findElement(By.tagName("textarea"));
		String tabinput = typeinput.getAttribute("placeholder");		
		String activeelement = driver.switchTo().activeElement().getAttribute("placeholder");
		System.out.println("TC02: Type email and Tab. Confirm control moved to next element." + '\n' + "-------------------------------------------------------------------------");	
		if((email != activeelement) && (tabinput.contains(activeelement))) {
			System.out.println("Focus moved to next eleement: PASS"+ '\n');
		}
		else {
			System.out.println("Tab focus is not moved: FAIL"+ '\n');
		}

		//Type about yourself
		typeinput.sendKeys("Short self description: Lorem ipsum dolor sit amet, consectetur adipiscing elit");

		//TC03: Just Press Enter and confirm error message
		driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-8']/input")).sendKeys(Keys.ENTER);
		String actualerrormsg = driver.findElement(By.xpath("(//div[@role='alert']//span)[2]")).getText();
		String exptderrormsg = "Age is mandatory";
		System.out.println("TC03: Just Press Enter and confirm error message" + '\n' + "-------------------------------------------------------------------------");	
		if(actualerrormsg.contentEquals(exptderrormsg)) {
			System.out.println("Error message displayed for blank age input field: PASS"+ '\n');
		}
		else{
			System.out.println("Error message not displayed for blank age input field: FAIL"+ '\n');
		}

		//TC04: Click and Confirm Label Position Changes
		WebElement labelelem = driver.findElement(By.xpath("//label[text()='Username']"));		
		int labelpos = labelelem.getLocation().getY();		
		driver.findElement(By.xpath("//label[text()='Username']/preceding-sibling::input")).sendKeys("a");		
		int newlabelpos = labelelem.getLocation().getY();
		System.out.println("TC04: Click and Confirm Label Position Changes" + '\n' + "-------------------------------------------------------------------------");
		if(labelpos!=newlabelpos) {
			System.out.println("Position of the input label changed: PASS"+ '\n');
		}
		else {
			System.out.println("Position of the label has not changed: FAIL"+ '\n');
		}

		//Type your name and choose the third option
		String nameinp = "testname";
		driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']/input")).sendKeys(nameinp);
		driver.findElement(By.xpath("//li[text()='3']")).click();	 

		//TC05: Type your DOB (mm/dd/yyyy) and confirm date chosen
		String dobinp = "11/26/1990";	    
		WebElement datepickr = driver.findElement(By.xpath("//span[contains(@class,'p-datepicker')]/input"));
		datepickr.sendKeys(dobinp);
		String actualdd = driver.findElement(By.xpath("//a[contains(@class,'ui-state-active')]")).getText();	    
		String fullmm = driver.findElement(By.xpath("//span[contains(@class,'month')]")).getText();
		String actualmm = convertMonth(fullmm);
		String actualyy = driver.findElement(By.xpath("//span[contains(@class,'year')]")).getText();
		String actualdob = actualmm +"/"+ actualdd + "/" + actualyy;
		System.out.println("TC05: Type your DOB (mm/dd/yyyy) and confirm date chosen" + '\n' + "-------------------------------------------------------------------------");
		if(dobinp.contentEquals(actualdob)) {
			System.out.println("Entered date is matching with Datepicker: PASS"+ '\n');
		}
		else {
			System.out.println("Entered date is not matching with Datepicker: FAIL"+ '\n');
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'datepicker')]")).click();

		//TC06: Type number and spin to confirm value changed
		//TC06.1: Type number and spin up to confirm value changed
		WebElement spinner = driver.findElement(By.xpath("//span[contains(@class,'spinner')]/input"));
		String spinrval = "25";
		spinner.sendKeys(spinrval);	    
		driver.findElement(By.xpath("(//a[contains(@class,'spinner')])[1]")).click();	    
		String aftrupspin = spinner.getAttribute("aria-valuenow");
		System.out.println("TC06.1: Type number and spin up to confirm value changed" + '\n' + "-------------------------------------------------------------------------");
		if(spinrval!=aftrupspin) {
			System.out.println("After clicking Spinner-up the entered value changeed successfully from: " + spinrval + " to: " + aftrupspin +" : PASS"+ '\n');
		}
		else {
			System.out.println("After clicking Spinner-up the entered value failed to change: FAIL"+ '\n');
		}
		
		//TC06.2: Type number and spin down once to confirm value reverted to original
		WebElement spinrdwn = driver.findElement(By.xpath("(//a[contains(@class,'spinner')])[2]"));
		spinrdwn.click();
		String afteronedwnspin = spinner.getAttribute("aria-valuenow");
		System.out.println("TC06.2: Type number and spin down once to confirm value reverted to original" + '\n' + "-------------------------------------------------------------------------");
		if(afteronedwnspin.contains(spinrval)) {
			System.out.println("After clicking Spinner-down once the changed value reverted back successfully to: " + spinrval + " from: " + aftrupspin +" : PASS"+ '\n');
		}
		else {
			System.out.println("After clicking Spinner-down once the changed value failed to revert back to entered value: FAIL"+ '\n');
		}
		
		//TC06.3: Type number and spin down second time to confirm value reverted to original
		spinrdwn.click();	    
		String aftertwodwnspin = spinner.getAttribute("aria-valuenow");
		System.out.println("TC06.3: Type number and spin down second time to confirm value reverted to original" + '\n' + "-------------------------------------------------------------------------");
		if(aftertwodwnspin != spinrval) {
			System.out.println("After clicking Spinner-down twice the changed value changed successfully to: " + aftertwodwnspin + " from: " + afteronedwnspin +" : PASS"+ '\n');
		}
		else {
			System.out.println("After clicking Spinner-down twice the changed value failed to reduce correctly: FAIL"+ '\n');
		}
		

		//TC07: Type random number (1-100) and confirm slider moves correctly	    
		String sliderinp = "48";
		driver.findElement(By.xpath("(//div[contains(@class,'slider')])[1]/preceding-sibling::input")).sendKeys(sliderinp);	   
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@class,'slider-handle')]")).click();
		String sliderwidth = driver.findElement(By.xpath("//div[contains(@class,'slider-range')]")).getAttribute("style");
		System.out.println("TC07: Type random number (1-100) and confirm slider moves correctly" + '\n' + "-------------------------------------------------------------------------");
		if(sliderwidth.contains(sliderinp)) {
			System.out.println("The Slider position moved as per the provided input successfully: PASS"+ '\n');
		} 
		else {
			System.out.println("The Slider position didn't move as per the provided input: FAIL"+ '\n'); 
		}    
		
		//TC08: Click and Confirm Keyboard appears
		driver.findElement(By.xpath("//input[contains(@class,'keyboard-input')]")).click();	   
		boolean kbvisible = driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]")).isDisplayed();
		System.out.println("TC08: Click and Confirm Keyboard appears" + '\n' + "-------------------------------------------------------------------------");
		if(kbvisible == true) {
			System.out.println("Keyboard pop-up displayed after clicking input field: PASS"+ '\n');
		}
		else {
			System.out.println("Keyboard pop-up displayed was not displayed after clicking input field: FAIL"+ '\n');
		}
		driver.close();
	}

}
