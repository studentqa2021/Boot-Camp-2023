package com.cucumber.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"json:target/cucumber.json"},
		features ={"./src/main/resources/GoogleSearch.feature"},
		glue = {"com.cucumber.test"},
		tags = {"@Smoke"},
		//optional
		monochrome = true,
		strict = true,// check stepdef
		dryRun = false // feature file
		
		
		
		
		)
public class RunnerFile extends AbstractTestNGCucumberTests{
	
	//hook = testng 
	

}
