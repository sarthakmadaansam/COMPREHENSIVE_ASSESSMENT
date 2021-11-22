package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkGiftCards {
	
	public WebDriver driver;
	By giftOption= By.xpath("//header/div[2]/div[2]/div[4]/div[1]/div[1]/a[3]");
	By cash= By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/fieldset[1]/div[2]/label[1]");
	By title= By.xpath("//h1[contains(text(),'Gift Card')]");
	By cart= By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");
    public checkGiftCards(WebDriver driver) {
    	this.driver=driver;
    }
    public WebElement clickOn_Gift() {
		return driver.findElement(giftOption);
	}
    public WebElement clickOn_Cash() {
		return driver.findElement(cash);
	}
    public WebElement clickOn_Cart() {
		return driver.findElement(cart);
	}
    public WebElement checkTitle() {
		return driver.findElement(cart);
	}
}
