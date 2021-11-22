package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import pageObjects.searchItems;

public class Tc003_searchBox extends driverClass{

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void clickOnSearch() throws IOException{
		searchItems s= new searchItems(driver);
		s.clickOn_search().sendKeys("Home Decor");
		s.clickOn_search().sendKeys(Keys.ENTER);
		s.checkProduct().click();
		Assert.assertEquals(s.checkTitle().getText(), prop.getProperty("searchProduct"));
		s.clickOnCart().click();
		log.info("Product title verified and successfully added to cart");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
