package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.driverClass;
import pageObjects.whatsAppcheck;

public class Tc010_whatsappIcon extends driverClass{
	public static Logger log=LogManager.getLogger(driverClass.class.getName());
	@BeforeTest
	public void goToURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("HomePage gets displayed successfully.");
	}
	@Test
	public void clickWhatsapp() {
		whatsAppcheck w= new whatsAppcheck(driver);
		w.selectIcon().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		Assert.assertEquals(driver.getTitle(), prop.getProperty("whatsapp"));
		log.info("Whatsapp web gets launched successfully.");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(3000);
		driver.quit();
		log.info("Browser closed after termination of test");
	}

}
