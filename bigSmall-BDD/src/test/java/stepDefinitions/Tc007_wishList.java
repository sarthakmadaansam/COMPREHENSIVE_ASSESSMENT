package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.searchItems;
import pageObjects.wishlistAdd;

public class Tc007_wishList extends driverClass{
	
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for wishlist")
	public void user_launches_browser_and_opens_url_for_wishlist(String url) throws IOException
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on the search box and types {string} and clicks Enter and selects Harry Potter playing cards and adds it to wishlist")
	public void addToWishlist(String product) throws IOException{
		searchItems s= new searchItems(driver);
		s.clickOn_search().sendKeys(product);
		s.clickOn_search().sendKeys(Keys.ENTER);
		
		wishlistAdd ad= new wishlistAdd(driver);
		ad.clickProduct().click();
		ad.addTowishlist().click();
		ad.clickOnwishlist().click();
		Assert.assertEquals(prop.getProperty("wishlist"), "Remove");
		log.info("Product title verified and successfully added to wishlist");
	}
	
	@Then("Page is navigated to My Wishlist with added item")
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
