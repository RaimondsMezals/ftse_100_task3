package com.qa.ftse.test.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FtseStepDefs {

	private static RemoteWebDriver driver;
	private static WebElement targ;

	// Riser

	@Given("I can access {string}")
	public void i_can_access(String string) {
		SeleniumWebDriver.setDriverOptions(SeleniumWebDriver.chromeCfg());
		driver = SeleniumWebDriver.getDriver();
		driver.get(string);
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\'acceptCookie\\']")));
		SeleniumWebDriver.clickCookie();
		driver.manage().window().maximize();
	}
	
	
	@When("I navigate to the risers")
	public void i_navigate_to_the_risers() throws InterruptedException {
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a")));
		targ = driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a"));
		
		targ.click();
	}

	@Then("I should see the largest riser within the list")
	public void i_should_see_the_largest_riser_within_the_list() {
		targ = driver.findElement(By.xpath("//*[@id=\"ls-row-SMDS-L\"]/td[1]"));
		String result = targ.getText();
		assertEquals("SMDS", result);
	}

	// Faller

	@When("I navigate to the fallers")
	public void i_navigate_to_the_fallers() throws InterruptedException {
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view-constituents\"]/ul/li[3]/a")));

		targ = driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/ul/li[3]/a"));
		targ.click();
	}

	@Then("I should see the largest faller within the list")
	public void i_should_see_the_largest_faller_within_the_list() {
		targ = driver.findElement(By.xpath("//*[@id=\"ls-row-HIK-L\"]/td[1]"));
		String result = targ.getText();
		assertEquals("HIK", result);
	}

}
