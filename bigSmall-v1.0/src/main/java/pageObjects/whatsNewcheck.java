package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class whatsNewcheck {

	public WebDriver driver;
	By button= By.linkText("What's New");
	By title=By.xpath("//h1[contains(text(),\"What's new\")]");
	
	public whatsNewcheck(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement clickButton() {
		return driver.findElement(button);
	}
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
}
