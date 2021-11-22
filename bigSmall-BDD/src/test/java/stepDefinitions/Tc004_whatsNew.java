package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.whatsNewcheck;

public class Tc004_whatsNew extends driverClass{
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches browser and opens URL {string} for new")
	public void user_launches_browser_and_opens_url_for_new(String url) throws IOException
	{
		driver= initializeDriver();
		driver.get(url);
		log.info("HomePage gets displayed successfully.");
	}
	
	@When("User clicks on the What's New option")
	public void user_clicks_on_the_what_s_new_option() throws IOException
	{
		whatsNewcheck w=new whatsNewcheck(driver);
		w.clickButton().click();
		Assert.assertEquals(w.checkTitle().getText(),prop.getProperty("whatsNew"));
		log.info("What's New page gets displayed successfully.");
	}
	
	@Then("User gets redirected to another page displaying latest products available")
	public void user_gets_redirected_to_another_page_displaying_latest_products_available() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}