package com.adamjhowell.bdd.runner;
// The package for the Steps file, and the Tests file, need to be in "Test Sources Root" folder.


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith( Cucumber.class )
@CucumberOptions(
	glue = "com.adamjhowell.bdd.steps",
	features = "classpath:cucumber/calculator.feature" )


public class RunCalculatorTests
{
}
