package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.dataProvider;
import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPage;

public class Tc001_Login_valid extends driverClass {
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches chrome browser and opens URL {string}")
    public void goToURL(String url) throws IOException, Throwable 
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
		}
	
	@When("User clicks on Log In and enters valid data")
	public void clickOnLogin() throws IOException, Throwable
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
	
	@Then("The user data is accepted and user is redirected to My Account page")
	public void tearDown() throws InterruptedException, Throwable
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
