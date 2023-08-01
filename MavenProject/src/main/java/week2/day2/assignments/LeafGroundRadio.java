package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundRadio {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		driver.findElement(By.xpath("//label[contains(text(),'Chrome')]")).click();
		
		WebElement unslcradio = driver.findElement(By.xpath("//label[contains(text(),'Bengaluru')]"));
		unslcradio.click();
		unslcradio.click();
		boolean isslctd = unslcradio.isSelected();
		if(isslctd==false) {
			System.out.println('\n' + unslcradio.getText() + " radion button unselected successfully" + '\n');
		}
		else {
			System.out.println('\n' + unslcradio.getText() + " radion button was not unselected"+ '\n');
		}
		
		//Find the default select radio button
		List<WebElement> dfltslct = driver.findElements(By.xpath("(//div[contains(@class,'col-12')])[5]//div[contains(@class,'radiobutton-box')]"));
		List<WebElement> dfltslctlbl = driver.findElements(By.xpath("(//div[contains(@class,'col-12')])[5]//label"));		
		for(int i=0;i<dfltslct.size();i++) {
			
			String rdclsnm = dfltslct.get(i).getAttribute("class");
			String slctdnm = dfltslctlbl.get(i).getText();
			if(rdclsnm.contains("active")) {
				System.out.println("The default selected radio button is: " + slctdnm+ '\n');
			}
		}
		
		//Select the age group (only if not selected)
		List<WebElement> ntslctd = driver.findElements(By.xpath("(//div[contains(@class,'col-12')])[6]//div[contains(@class,'radiobutton-box')]"));
		List<WebElement> ntslctdlbl = driver.findElements(By.xpath("(//div[contains(@class,'col-12')])[6]//label"));
		for(int i=0;i<ntslctd.size();i++) {
			boolean issltcdrb = ntslctd.get(i).isSelected();
			String ntslctnm = ntslctdlbl.get(i).getText();
			if(issltcdrb == false) {
				System.out.println("This radio button was not selected: " + '"' + ntslctnm + '"' + " and is selected now"+ '\n');
				ntslctd.get(i).click();
			}
		}
	}

}
