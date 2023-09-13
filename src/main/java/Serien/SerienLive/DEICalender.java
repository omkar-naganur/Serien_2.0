package Serien.SerienLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class DEICalender extends abstractReusable{

	WebDriver driver;
	public DEICalender(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameTextFiled;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	public void serienLogin (String Username, String password) throws Throwable
	{
		userNameTextFiled.sendKeys(Username);
		Password.sendKeys(password);
		Thread.sleep(1000);
		LoginButton.click();
	}
		
	public void gotoLoginPage ()
	{
		driver.get("https://sereininc.live/");
	}
	
	
	
}

