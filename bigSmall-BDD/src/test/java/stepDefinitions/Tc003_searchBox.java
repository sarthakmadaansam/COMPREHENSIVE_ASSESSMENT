package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.searchItems;

public class Tc003_searchBox extends driverClass{

	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	
	@Given("User launches chrome browser and_opens URL {string}")
	public void goToURL(String url) throws IOException, Throwable
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@When("User clicks on search box and enters {string}")
	public void clickOnSearch(String product) throws IOException, Throwable
	{   searchItems s= new searchItems(driver);
		s.clickOn_search().sendKeys(product);
		s.clickOn_search().sendKeys(Keys.ENTER);
		s.checkProduct().click();
		Assert.assertEquals(s.checkTitle().getText(), "Decorative Star String Lights" );
		s.clickOnCart().click();
		log.info("Product title verified and successfully added to cart");
	}
	
    @Then("User gets redirected to another page displaying Home Decor products")
	public void tearDown() throws InterruptedException, Throwable
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}
}
