package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	public ChromeDriver driver;
	
	@Given("Browser launched and is maximised and is in Login page")
	public void browserLaunch() {		
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));		
	}
	
	@And("Enter the correct username")
	public void enterUsername() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}
	
	@And("Enter the correct password")
	public void enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	
	@When("user clicks on login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("verify login attempt is successfull")
	public void verifyLogin() {
		if(driver.getTitle().contains("Leaftaps")){
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed");
		}
	}
	

	
}
