package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartAdd {

	public WebDriver driver;
	By btn= By.xpath("//body/div[@id='CartDrawer']/form[1]/div[1]/div[2]/button[1]/*[1]");
	By cart= By.xpath("//header/div[2]/div[2]/div[4]/div[1]/div[1]/a[4]");
	By title= By.xpath("//body[1]/div[5]/form[1]/div[1]/div[1]");
	By ctd_shop= By.xpath("//a[contains(text(),'Continue shopping')]");
	public cartAdd(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
	
	public WebElement continueShopping() {
		return driver.findElement(ctd_shop);
	}
	
	public WebElement clickClose() {
		return driver.findElement(btn);
	}
	
	public WebElement clickOnCart() {
		return driver.findElement(cart);
	}
}
