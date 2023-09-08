package week7.day1.assignment.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {

	public ChromeDriver driver;

	@Given("Browser is launched and is maximised")
	public void launchBrwsr() {
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
	}

	@Then("Enter username")
	public void enterUnm() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}

	@And("Enter password")
	public void enterPwrd() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}

	@When("user clicks on Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("verify successfull login")
	public void verifyLogin() {
		if(driver.getTitle().contains("Leaftaps")){
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed");
		}
	}
}
