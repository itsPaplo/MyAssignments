package week6.day2.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public String shtNm;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String usrnm, String pwrd) {
		driver  = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(14));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='username']")))).sendKeys(usrnm);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='password']")))).sendKeys(pwrd);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class='decorativeSubmit']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Leads']")))).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
		return ExcelReader.readExcel(shtNm);
	}
}
