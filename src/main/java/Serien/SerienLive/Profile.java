package Serien.SerienLive;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class Profile extends abstractReusable {

	WebDriver driver;
	public Profile(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//li[6]//div[1]//div[1]")
	WebElement profileButton;
	
	@FindBy(xpath = "//div[@class='hrpageheding MuiBox-root css-0']")
	WebElement userName;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1hg9omi']")
	WebElement userEmail;
	
	@FindBy(xpath = "//div[@class='hrbodytext MuiBox-root css-i5q2k0']/div[3]")
	WebElement userSubName;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1p7qxde'][2])//div[2]")
	WebElement SubExpText;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1p7qxde'][1])//div[2]")
	WebElement SubStarText;
	
	@FindBy(xpath = "//li[6]//div[2]/div[1]")
	List<WebElement> moduleNames;
	
	By moduleNameGetEle=By.xpath("//li[6]//div[2]/div[1]");
	
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	WebElement userLogout;
	
	@FindBy(xpath = "//div[contains(text(), ' Change password')]")
	WebElement changePassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Current')] ")
	WebElement CurrentPassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'New')] ")
	WebElement newPassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Confirm')] ")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitPassword;
	
	
	public void gotoProfile () throws Throwable
	{
		profileButton.click();
		Thread.sleep(1000);
	}
		
	public Boolean ValidationBasicDeatils (String userName1, String userEmail1, String userSubName1)
	{
		String ActualUserName =userName.getText();
		String ActualUserEmail1=userEmail.getText();
		String ActualUserSubName1=userSubName.getText();
		Boolean UserName = ActualUserName.equalsIgnoreCase(userName1);
		Boolean userEmail = ActualUserEmail1.equalsIgnoreCase(userEmail1);
		Boolean userSubName = ActualUserSubName1.equalsIgnoreCase(userSubName1);
		return UserName;
	}
	
	public List<WebElement> sidemenuValidation() {
		waitForElementTOApper(moduleNameGetEle);
		return moduleNames;
	}
	
	public void userLogout()
	{
		userLogout.click();
	}
	public String validateUserEmail ()
	{
		waitForWebElementTOApper(userEmail);
		String ActualUserEmail1=userEmail.getText();
		System.out.println(ActualUserEmail1);
		return ActualUserEmail1;
	}
	
	public String subExpTest() throws Throwable
	{
		waitForWebElementTOApper(SubExpText);
		Thread.sleep(1000);
		String subexpText=SubExpText.getText();
		return 	subexpText;
	}
	
	public String getUserNameFromProfile () throws Throwable
	{
		Thread.sleep(2000);
		waitForWebElementTOApper(userName);
		String Username=userName.getText();
		return 	Username;
	}
	
	public void changePassword (String oldpass, String newPass)throws Throwable
	{
		waitForWebElementTOApper(changePassword);
		Thread.sleep(2000);
		changePassword.click();	
		waitForWebElementTOApper(CurrentPassword);
		CurrentPassword.sendKeys(oldpass);
		waitForWebElementTOApper(newPassword);
		newPassword.sendKeys(newPass);
		waitForWebElementTOApper(confirmPassword);
		confirmPassword.sendKeys(newPass);
		waitForWebElementTOApper(submitPassword);
		submitPassword.click();
		Thread.sleep(2000);
		alertAccepectMethod();
		Thread.sleep(1000);
	}
	
}

