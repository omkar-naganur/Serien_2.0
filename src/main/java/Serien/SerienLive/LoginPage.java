package Serien.SerienLive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Serien.AbstractComponents.abstractReusable;

public class LoginPage extends abstractReusable {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Trial Test 
	
	
	
	//***************************************
	// original 
	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameTextFiled;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//div/span[1]")
	WebElement LoginErroeMessage1;
	
	@FindBy(xpath = "//a[@href='/forgot-password-page']")
	WebElement ForgotPassword;
	
//	@FindBy(xpath = "//div/span[1]")
//	By LoginErroeMessage;
	
	By LoginB =By.xpath("//button[@type='submit']");
	
	//By LoginErroeMessage =By.xpath("//button[@type='submit']");
	
	public Profile serienLogin (String Username, String password) throws Throwable
	{	
		waitForWebElementTOApper(userNameTextFiled);
		userNameTextFiled.sendKeys(Username);
		waitForWebElementTOApper(Password);
		Password.sendKeys(password);
		Thread.sleep(2000);
		waitForWebElementTOApper(LoginButton);
		LoginButton.click();
		// this helps to move to Profile page objective
		Profile profile= new Profile(driver);
		return profile;
	}
	
	public void gotoLoginPage () throws InterruptedException 
	{
		driver.get("https://console.cloud.google.com/storage/browser/sereindevcontent.kdev.co.in;tab=objects?forceOnBucketsSortingFiltering=true&project=serein-devqa-internal-gcp&prefix=&forceOnObjectsSortingFiltering=false");
		//driver.get("https://sereindevweb.kdev.co.in/");
		//driver.get("https://sereininc.live/");
	}
	
	public void gooleColudLogin (String Username, String password) throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@jscontroller='soHxf'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@jscontroller='soHxf'])[2]")).click();
		
	}
	
	public void gooleColudFile (String filePath) throws InterruptedException, FileNotFoundException 
	{
		Thread.sleep(5000);
	    WebElement fileInput = driver.findElement(By.xpath("(//div[@jslog='54826'])//input[2]"));
	 //   CharSequence[] fis=(System.getProperty("user.dir")+"//reports//project1");
	 String fis=  "/media/kwsys4/nonOsPartition/AutomationSerien4.0/SerienLive/reports/project1";
	    fileInput.sendKeys(fis);
	    Thread.sleep(2000);
	   
		
	}
	
	public Boolean ErrorMessage(String expectedErrorMessage) throws Throwable
	{
		waitForWebElementTOApper(LoginErroeMessage1);
		String actualError=LoginErroeMessage1.getText();
		Boolean ErroeMess=actualError.equalsIgnoreCase(expectedErrorMessage);
		return ErroeMess;
	}
	
	public void ForgotPasswordLink () throws Throwable
	{
		waitForWebElementTOApper(ForgotPassword);
		Thread.sleep(2000);
		ForgotPassword.click();
		
	}
	
}

