package Serien.SerienLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class AdminGroupPage extends abstractReusable{

	WebDriver driver;
	public AdminGroupPage(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/admin/groupEnrollmentEdits/']")
	WebElement addNewGroupEnrollment;
	
	@FindBy(xpath = "//a[@href='/admin/settings']/..")
	WebElement SettingA;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	public void AddNewGroupEnrollmentPage() throws Throwable
	{
		addNewGroupEnrollment.click();
	}
	
	
}

