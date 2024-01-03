package Serien.SerienLive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Serien.AbstractComponents.abstractReusable;

public class ForgetPassword extends abstractReusable {

	WebDriver driver;
	public ForgetPassword(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-0'][1])//p[1]")
	WebElement titleOfBox;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-0'][1])//p[2]")
	WebElement dscription;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement emailtextbox;
	
	@FindBy(xpath = "//*[text()='Submit']")
	WebElement Submit;
	
	@FindBy(xpath = "//*[text()='Go to login']")
	WebElement Gotologin;
	
//	@FindBy(xpath = "//*[text()='Please enter your email']")
//	WebElement actErrorMess;
	
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-z9tt10']")
	WebElement actErrorMess;
	
	
	public void getTitle () throws Throwable
	{
		waitForWebElementTOApper(titleOfBox);
		titleOfBox.getText();
	}
	
	public void ClickOnSubmitButton () throws Throwable
	{
		waitForWebElementTOApper(Submit);
		Submit.click();
	}
	
	public String GetErroeMessage () throws Throwable
	{
		waitForWebElementTOApper(actErrorMess);
		String errMes=actErrorMess.getText();
		return errMes;
	}
	
	public void EnterEmail (String email) throws Throwable
	{
		waitForWebElementTOApper(emailtextbox);
		emailtextbox.sendKeys(email);
	}
	
}

