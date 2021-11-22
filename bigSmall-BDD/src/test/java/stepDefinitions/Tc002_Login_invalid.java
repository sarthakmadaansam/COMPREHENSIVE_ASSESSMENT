package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPage;

public class Tc002_Login_invalid extends driverClass{

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for invalid data")
	public void user_launches_browser_and_opens_url_for_invalid_data(String url) throws IOException, Throwable
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on Log In and enters invalid data")
	public void clickOnLogin() throws IOException, Throwable
	{
		loginPage lp= new loginPage(driver);
		lp.clickOn_signIn().click();
		lp.enterUsername().sendKeys(prop.getProperty("invalid_usr"));
		lp.enterPassword().sendKeys(prop.getProperty("invalid_pwd"));
		lp.clickOn_submit().click();
		Assert.assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
		log.error("Login is unsuccessful");
	}
	
	@Then("The user data is not accepted and error message is displayed")
	public void tearDown() throws InterruptedException, Throwable
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
