package week6.day2.assignment;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static ChromeDriver driver;
	public WebDriverWait wait;
	public String sheetname ="";

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String uname, String pwrd) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username")))).sendKeys(uname);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys(pwrd);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("decorativeSubmit")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("CRM/SFA")))).click();	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Leads']")))).click();
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name="fetchTData")
	public String[][] sendData() throws IOException {
		String[][] excelData = ExcelReader.readExcel(sheetname);
		return excelData;
	}
}
