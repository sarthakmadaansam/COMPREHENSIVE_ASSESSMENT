package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import pageObjects.cartAdd;
import pageObjects.christmasGiftscheck;

public class Tc008_addToCart extends driverClass {

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
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
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
