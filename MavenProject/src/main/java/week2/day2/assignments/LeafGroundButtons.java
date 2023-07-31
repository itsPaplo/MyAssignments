package week2.day2.assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundButtons {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		//TC01: Click and Confirm title.
		driver.findElement(By.xpath("//span[text()='Click']/ancestor::button")).click();
		String exptitle = "Dashboard";
		String actualtitle = driver.getTitle();
		System.out.println('\n'+"TC01: Click and Confirm title." + '\n' + 
		"----------------------------------------------------------------");
		if(actualtitle.contains(exptitle)) {
			System.out.println("After clicking the button title of the redirected page is matching: PASS"+ '\n');
		}
		else {
			System.out.println("After clicking the button title of the redirected page is not matching: FAIL"+ '\n');
		}
		driver.navigate().back();
		
		//TC02: Confirm if the button is disabled.
		boolean btnstate = driver.findElement(By.xpath("(//div[@class='card'])[2]/button")).isEnabled();
		System.out.println("TC02: Confirm if the button is disabled." + '\n' + 
				"----------------------------------------------------------------");
		if(btnstate == false) {
			System.out.println("Button is in disabled state: PASS"+ '\n');
		}
		else {
			System.out.println("Button is not in disabled state: FAIL" + '\n');
		}
		
		//Find the position of the Submit button
		WebElement posbtn = driver.findElement(By.xpath("(//div[@class='card'])[3]/button"));
		System.out.println("The poisition of the Submit button is: " + posbtn.getLocation() + '\n');
		
		//Find the Save button color
		String svbtnclr = driver.findElement(By.xpath("(//div[@class='card'])[4]/button")).getCssValue("background-color");
		System.out.println("The color of Save button is: " + svbtnclr + '\n');
		
		//Find the height and width of this button
		WebElement dimnsnbtn = driver.findElement(By.xpath("(//div[@class='card'])[5]/button"));
		int btnheight = dimnsnbtn.getSize().getHeight();
		int btnwidth = dimnsnbtn.getSize().getWidth();		
		System.out.println("Height of this button is: " + btnheight+ "|| Width of this button is: " + btnwidth + '\n');
		
		//TC03: Mouse over and confirm the color changed
		WebElement clrbtn = driver.findElement(By.xpath("(//div[@class='card'])[6]//span"));
		String dfltbtnclr = clrbtn.getCssValue("background-color");
		Actions act = new Actions(driver);
		act.moveToElement(clrbtn).build().perform();
		String hvrbtnclr = clrbtn.getCssValue("background-color");
		System.out.println('\n'+"TC03: Mouse over and confirm the color changed" + '\n' + 
				"----------------------------------------------------------------");
		if(hvrbtnclr !=dfltbtnclr) {
			System.out.println("The Color of the button changed on mouse hover action: PASS"+'\n');
		}
		else {
			System.out.println("The Color of the button didn't change on mouse hover action: FAIL"+'\n');
		}
		
		//Click Image Button and Click on any hidden button
		driver.findElement(By.xpath("//div[@class='col-6']/button")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='grid formgrid']/following-sibling::input[@type='hidden']")).click();
		driver.findElement(By.xpath("//div[@class='col-6']/button")).click();
		
		//How many rounded buttons are there?
		List<WebElement> btnlist = driver.findElements(By.xpath("//button"));
		int count=0;
		for(int i=0;i<btnlist.size();i++) {		
			
			String btnbr = btnlist.get(i).getCssValue("border-radius");
			int brds= removeChar(btnbr);
			if(brds>10) {
				count++;
			}				
		}
		System.out.println('\n'+ "There are : " + count + " rounded buttons");	
		
	}
	
	public static int removeChar(String str) {
		char[] chars = str.toCharArray();
		String res = "";
		int val=0;
		
		for(int i=0;i<chars.length;i++) {
			if(Character.isDigit(chars[i])) {
				res = res+chars[i];
			}
		}
		val =Integer.parseInt(res); 
		
		return val;
	}
	
}
