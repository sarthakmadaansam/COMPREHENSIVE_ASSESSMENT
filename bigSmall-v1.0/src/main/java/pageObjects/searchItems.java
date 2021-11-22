package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchItems {
	public WebDriver driver;
	By search_bar= By.xpath("//header/div[2]/div[2]/div[3]/form[1]/input[2]");
	By product= By.xpath("//span[contains(text(),'Decorative Star String Lights')]");
	
	//Harry Potter Playing Cards
	By title= By.xpath("//h1[contains(text(),'Decorative Star String Lights')]");
	By cart= By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");
	public searchItems(WebDriver driver)
	{
		this.driver = driver;	
	}
    public WebElement clickOn_search() {
    	return driver.findElement(search_bar);
    }
    public WebElement checkProduct() {
    	return driver.findElement(product);
    }
    public WebElement checkTitle() {
    	return driver.findElement(title);
    }
    public WebElement clickOnCart() {
    	return driver.findElement(cart);
    }
}
