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
import pageObjects.christmasGiftscheck;

public class Tc006_christmasGifts extends driverClass{

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for christmas")
	public void user_launches_browser_and_opens_url_for_christmas(String url) throws IOException, Throwable
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on the Christmas gifts option and clicks on Christmas socks and adds product to cart")
	public void user_clicks_on_the_christmas_gifts_option_and_clicks_on_christmas_socks_and_adds_product_to_cart() throws IOException, Throwable
	{   
		christmasGiftscheck ch= new christmasGiftscheck(driver);
		ch.selectOption().click();
		ch.selectProduct().click();
		ch.clickOn_cart().click();
		Assert.assertEquals(ch.checkTitle().getText(), prop.getProperty("xmasItem"));
		log.info("Product title verified and successfully added to cart");
	}
	
	@Then("Page is navigated_to My Cart with added item")
	public void tearDown() throws InterruptedException, Throwable
	{   
		Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
