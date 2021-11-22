package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class birthdayGiftscheck {
	public WebDriver driver;
	By bday= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[10]/a[1]");
	By category= By.xpath("//body/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[2]");
	By title= By.xpath("//h1[contains(text(),'Birthday Gifts for Girls')]");
	public birthdayGiftscheck(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement clickOn_bday() {
		return driver.findElement(bday);
	}
	public WebElement clickOnPath() {
		return driver.findElement(category);
	}
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
}
