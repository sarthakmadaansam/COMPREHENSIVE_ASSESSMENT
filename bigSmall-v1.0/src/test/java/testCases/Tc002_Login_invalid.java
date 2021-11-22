package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.driverClass;
import pageObjects.loginPage;

public class Tc002_Login_invalid extends driverClass{

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
		lp.clickOn_signIn().click();;
		lp.enterUsername().sendKeys(prop.getProperty("invalid_usr"));
		lp.enterPassword().sendKeys(prop.getProperty("invalid_pwd"));
		lp.clickOn_submit().click();
		Assert.assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
		log.error("Login is unsuccessful");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
