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
import pageObjects.cartAdd;
import pageObjects.christmasGiftscheck;

public class Tc008_addToCart extends driverClass {

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for cart")
	public void user_launches_browser_and_opens_url(String url) throws IOException
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on Christmas socks from Christmas gifts and adds product to cart")
	public void addToCart() {
		christmasGiftscheck ch= new christmasGiftscheck(driver);
		ch.selectOption().click();
		ch.selectProduct().click();
		ch.clickOn_cart().click();
		log.info("Product is added to cart.");
		cartAdd ac= new cartAdd(driver);
		ac.clickClose().click();
		ac.clickOnCart().click();
		Assert.assertEquals(ac.checkTitle().getText(), prop.getProperty("cartTitle"));
		ac.continueShopping().click();
		log.info("Product is present in cart. Continue Shopping.");
	}
	
	@Then("Added product is visible in My Cart with option to check out")
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
