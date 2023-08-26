package week5.day1.assignment2;

import java.time.Duration;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SnowBaseClass {

	public ChromeDriver driver;
	public Shadow shadow ;
	public WebDriverWait wait;
	public String firstName = "fname1";
	public String newbsnPhone = "8187898877";
	public String kBase = "IT";
	public String ctgry = "Android"; 
	public String nwCtgry = "java";
	public String shrtDesc = "Test Article 1";
	public String artclTxt = "Issues of connecting android devices";	


	@BeforeMethod
	public void preCondition() {

		driver = new ChromeDriver();
		driver.get("https://dev140901.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mgs@1plosnad");
		driver.findElement(By.id("sysverb_login")).click();

		shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//div[text()='All']"))).click();
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}


}
