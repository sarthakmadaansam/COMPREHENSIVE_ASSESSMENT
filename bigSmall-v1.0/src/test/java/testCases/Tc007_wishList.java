package testCases;

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
import pageObjects.searchItems;
import pageObjects.wishlistAdd;

public class Tc007_wishList extends driverClass{
	
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void addToWishlist() throws IOException{
		searchItems s= new searchItems(driver);
		s.clickOn_search().sendKeys("Harry Potter");
		s.clickOn_search().sendKeys(Keys.ENTER);
		
		wishlistAdd ad= new wishlistAdd(driver);
		ad.clickProduct().click();
		ad.addTowishlist().click();
		ad.clickOnwishlist().click();
		Assert.assertEquals(prop.getProperty("wishlist"), "Remove");
		log.info("Product title verified and successfully added to wishlist");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
