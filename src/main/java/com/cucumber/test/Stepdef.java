package com.cucumber.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import com.util.Constans;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.page.object.model.GoogleSearchPage;

public class Stepdef {
	private static Logger logger = LoggerFactory.getLogger(Stepdef.class);
	WebDriver driver;
	SoftAssert sf = new SoftAssert();
	//hook = @Before & @After
	@Given("open a browser")
	public void open_a_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("go to google")
	public void go_to_google() {
		driver.navigate().to(Constans.URL);
		// implicit= optional
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	}

	@When("search for iphone13")
	public void searchforiphone13() {
		// search
				WebElement search = driver.findElement(GoogleSearchPage.search);
				// search.isDisplayed()
				
				sf.assertTrue(search.isDisplayed());

				search.sendKeys(Constans.testData);
				// search options

				
	}

	@Then("search option should visible only iphone13")
	public void searchoptionshouldvisibleonlyiphone13() {
		List<WebElement> searchOptions = driver.findElements(GoogleSearchPage.searchOptions);
		// handle list of webelement in selenium ==> Java list & loop
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("List count = " + searchOptions.size());

		for (int i = 0; i < searchOptions.size(); i++) {
			// each object from a java list==>searchOptions.get(index)
			// how to read each object/ webelemnt inside value or text==> each
			// webelemnt.getText()
			logger.info("Search drop down options =" + searchOptions.get(i).getText());
			logger.info("Condition =" + searchOptions.get(i).getText().contains("13"));
			if (searchOptions.get(i).getText().contains("13")) {
				logger.info("Good");
				sf.assertTrue(searchOptions.get(i).getText().contains("13"));

			} else {
				logger.info("Bad");
				sf.assertTrue(searchOptions.get(i).getText().contains("13"));
			}

		}
		sf.assertAll();// never work
	}

}
