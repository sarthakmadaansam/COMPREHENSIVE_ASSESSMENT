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
import pageObjects.checkGiftCards;

public class Tc009_giftCards extends driverClass{
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for giftcards")
	public void user_launches_browser_and_opens_url_for_giftcards(String url) throws IOException
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	@When("User clicks on the option Gift cards from top-right corner of the page and selects a gift card of Rs 1000 and adds it to cart")
	public void clickOnGift() {
		checkGiftCards gc= new checkGiftCards(driver);
		gc.clickOn_Gift().click();
		gc.clickOn_Cash().click();
		Assert.assertTrue(gc.checkTitle().isDisplayed());
		gc.clickOn_Cart().click();
		log.info("Gift card verified and added to Cart successfully.");
	}
	
	@Then("Page is navigated to My Cart with added item")
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}

}
