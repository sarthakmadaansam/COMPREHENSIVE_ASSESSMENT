package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	By signIn= By.xpath("//span[contains(text(),'sign in')]");
	By email= By.id("CustomerEmail");
	By password= By.id("CustomerPassword");
	By submit= By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/form[1]/p[1]/input[1]");
	By acc= By.xpath("//h2[contains(text(),'My account')]");
	public loginPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	public WebElement clickOn_signIn() {
		return driver.findElement(signIn);
	}
	public WebElement enterUsername() {
		return driver.findElement(email);
		
	}
	public WebElement enterPassword() {
		return driver.findElement(password);
		
	}
	public WebElement clickOn_submit() {
		return driver.findElement(submit);
		
	}
	public WebElement check_myAcc() {
		return driver.findElement(acc);
		
	}
}
