package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wishlistAdd {

	public WebDriver driver;
	By product= By.xpath("//span[contains(text(),'Harry Potter Playing Cards')]");
	By wishlist= By.xpath("//span[contains(text(),'Add to Wishlist')]");
	By button= By.xpath("//span[contains(text(),'wish list')]");
	By title= By.xpath("//span[contains(text(),'Remove')]");
	public wishlistAdd(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement clickProduct() {
		return driver.findElement(product);
	}
	public WebElement addTowishlist() {
		return driver.findElement(wishlist);
	}
	public WebElement clickOnwishlist() {
		return driver.findElement(button);
	}
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
	
}
