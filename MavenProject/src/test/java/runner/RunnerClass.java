package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.BaseClass;

@CucumberOptions(features={"src/test/java/features/TC001_Login.feature"}, glue="stepDefinition",
	monochrome=true,
	publish=true,
	dryRun=true)

public class RunnerClass extends BaseClass{

}	
