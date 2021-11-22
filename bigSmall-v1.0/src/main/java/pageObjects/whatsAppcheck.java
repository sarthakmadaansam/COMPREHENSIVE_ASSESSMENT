package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class whatsAppcheck {

	public WebDriver driver;
	By icon= By.id("wa-chat-btn-root");
	
	public whatsAppcheck(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement selectIcon() {
		return driver.findElement(icon);
	}
}
