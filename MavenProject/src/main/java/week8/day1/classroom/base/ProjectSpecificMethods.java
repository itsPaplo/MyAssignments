package week8.day1.classroom.base;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {
	
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"url"})
	@BeforeMethod
	public void preCondition(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));	
		wait = new WebDriverWait(driver,Duration.ofSeconds(14));
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
