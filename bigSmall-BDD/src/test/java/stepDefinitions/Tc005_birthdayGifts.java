package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.birthdayGiftscheck;

public class Tc005_birthdayGifts extends driverClass {

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for birthday")
	public void user_launches_browser_and_opens_url_for_birthday(String url) throws IOException, Throwable
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on the Bithday Gifts option and selects Birthday gifts for Girls")
	public void clickOnbdayGifts() throws IOException, Throwable
	{
		birthdayGiftscheck b= new birthdayGiftscheck(driver);
		b.clickOn_bday().click();
		b.clickOnPath().click();
		Assert.assertEquals(b.checkTitle().getText(),prop.getProperty("bdayTitle"));
		log.info("Birthday Gifts for Girls gets displayed successfully.");
	}
	
	@Then("User gets redirected to another page displaying related products")
	public void tearDown() throws InterruptedException, Throwable
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
