package com.qa.ftse.test.cuke;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/cuke",
		glue = "com.qa.ftse.test.cuke.stepdefs")
public class CukeRunner {

}
