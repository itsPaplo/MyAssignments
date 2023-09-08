package week7.day2.classroom.base;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethods {
	
	public static ChromeDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));	
		wait = new WebDriverWait(driver,Duration.ofSeconds(14));
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
