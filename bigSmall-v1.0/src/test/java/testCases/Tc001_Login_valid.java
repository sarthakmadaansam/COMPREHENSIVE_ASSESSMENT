package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.dataProvider;
import Utilities.driverClass;
import pageObjects.loginPage;



public class Tc001_Login_valid extends driverClass {
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void clickOnLogin() throws IOException
	{
		loginPage lp= new loginPage(driver);
		dataProvider dp= new dataProvider();
		lp.clickOn_signIn().click();;
		lp.enterUsername().sendKeys(dp.send_Username());
		lp.enterPassword().sendKeys(dp.send_Password());
		lp.clickOn_submit().click();
		Assert.assertTrue(lp.check_myAcc().isDisplayed());
		log.info("Successfully logged in through valid credentials");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
