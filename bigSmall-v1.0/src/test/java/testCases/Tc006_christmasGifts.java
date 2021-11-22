package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import pageObjects.christmasGiftscheck;

public class Tc006_christmasGifts extends driverClass{

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void christmas() {
		christmasGiftscheck ch= new christmasGiftscheck(driver);
		ch.selectOption().click();
		ch.selectProduct().click();
		ch.clickOn_cart().click();
		Assert.assertEquals(ch.checkTitle().getText(), prop.getProperty("xmasItem"));
		log.info("Product title verified and successfully added to cart");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
