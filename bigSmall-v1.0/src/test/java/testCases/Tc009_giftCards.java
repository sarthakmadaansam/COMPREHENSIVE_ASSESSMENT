package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import pageObjects.checkGiftCards;

public class Tc009_giftCards extends driverClass{
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void clickOnGift() {
		checkGiftCards gc= new checkGiftCards(driver);
		gc.clickOn_Gift().click();
		gc.clickOn_Cash().click();
		Assert.assertTrue(gc.checkTitle().isDisplayed());
		gc.clickOn_Cart().click();
		log.info("Gift card verified and added to Cart successfully.");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}

}
