package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class christmasGiftscheck {

	public WebDriver driver;
	By xmas=By.partialLinkText("Christmas Gif");
	By product= By.xpath("//body/div[2]/div[2]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[2]/div[1]");
	By cart= By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");
	By title= By.xpath("//h1[contains(text(),'Christmas Socks')]");
	public christmasGiftscheck(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement selectOption() {
		return driver.findElement(xmas);
	}
	public WebElement selectProduct() {
		return driver.findElement(product);
	}
	public WebElement clickOn_cart() {
		return driver.findElement(cart);
	}
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
}
