package Serien.SerienLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class AdminGroupEnrollment extends abstractReusable{

	WebDriver driver;
	public AdminGroupEnrollment(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/admin/settings']")
	WebElement Setting;
	
	@FindBy(xpath = "//a[@href='/admin/settings']/..")
	WebElement SettingA;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	public AdminSetting GotoAdminSetting () throws Throwable
	{
		try {
			waitForWebElementTOApper(Setting);
			Setting.click();
			}
			catch(Exception e) {
				waitForWebElementTOApper(SettingA);
				SettingA.click();
				System.out.println("catch working");
			}
		
		AdminSetting Setting= new AdminSetting(driver);
		return Setting;
	}
	
	
}

