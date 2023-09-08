package week7.day1.assignment.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/main/java/week7/day1/assignment/feature/TC001_Login.feature"},glue="week7.day1.assignment.stepDefinition",
		monochrome=true, dryRun=true)

public class RunnerClass extends AbstractTestNGCucumberTests{
	
}
