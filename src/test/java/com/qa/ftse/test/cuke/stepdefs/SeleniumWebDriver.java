package com.qa.ftse.test.cuke.stepdefs;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SeleniumWebDriver {

	@FindBy(xpath = "//*[@id=\"acceptCookie\"]")
	private static WebElement cookieButton;

	private static RemoteWebDriver driver;

	@Before
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Tests have Started");
	}

	@After
	public static void cleanUp() {
		driver.quit();
		System.out.println("The driver has been closed!");
	}

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public static void setDriverOptions(ChromeOptions cOptions) {
		driver.quit();
		driver = new ChromeDriver(cOptions);
	}

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(true);
		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);
		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

	public static void clickCookie() {
		cookieButton.click();
	}

}
