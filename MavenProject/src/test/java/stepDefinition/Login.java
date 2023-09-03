package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass{

	@And("Enter the username as {string}")
	public void enterUsername(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@And("Enter the password as {string}")
	public void enterPassword(String pwrd) {
		driver.findElement(By.id("password")).sendKeys(pwrd);
	}

	@When("user clicks on login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("verify login attempt")
	public void verifyLogin() {
		if(driver.getTitle().contains("Leaftaps")){
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed");
		}
	}

}
