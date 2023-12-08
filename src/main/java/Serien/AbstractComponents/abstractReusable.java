package Serien.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractReusable {
	WebDriver driver;

	public abstractReusable(WebDriver driver) {
		this.driver = driver;
	}
	
	// this Elements for HR & User Panel
	
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	WebElement userLogout;
	
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	WebElement adminLogut;
	
	@FindBy(xpath = "//li[1]//div[1]//div[1]")
	WebElement Diversity;
	
	@FindBy(xpath = "(//div[@role='button'])[2]")
	WebElement Inclusion;
	
	@FindBy(xpath = "//li[3]//div[1]//div[1]")
	WebElement Learning;
	
	@FindBy(xpath = "//li[4]//div[1]//div[1]")
	WebElement ProgresReport;
	
	@FindBy(xpath = "//li[5]//div[1]//div[1]")
	WebElement DEIcalender;
	
	@FindBy(xpath = "//li[6]//div[1]//div[1]")
	WebElement Profile;
	
	// admin panel Side bard Elements
	
	
	
	//Below methods for Wait for Element to apper
	
	public void waitForElementTOApper(By LoginErroeMessage) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(LoginErroeMessage));	
	}
	
	public void waitForWebElementTOApper(List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOfAllElements(findBy));	
	}
	
	public void waitForWebElementTOApper(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOf(findBy));	
	}
	
	public void waitForElementTODissApper(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
		 wait.until(ExpectedConditions.invisibilityOfAllElements(ele));	
	}
	
	// HR and User panle navigations
	
	public void adminLogout()
	{
		waitForWebElementTOApper(adminLogut);
		adminLogut.click();
	}
	
	public void userLogout()
	{
		waitForWebElementTOApper(userLogout);
		userLogout.click();
	}
	
	public void Diversity()
	{
		waitForWebElementTOApper(Diversity);
		Diversity.click();
	}
	public void Inclusion()
	{
		waitForWebElementTOApper(Inclusion);
		Inclusion.click();
	}
	
	public void Learning()
	{
		waitForWebElementTOApper(Learning);
		Learning.click();
	}
	
	public void ProgresReport()
	{
		waitForWebElementTOApper(ProgresReport);
		ProgresReport.click();
	}
	
	public void DEIcalender()
	{
		waitForWebElementTOApper(DEIcalender);
		DEIcalender.click();
	}
	
	public void Profile()
	{
		waitForWebElementTOApper(Profile);
		Profile.click();
	}
	
	// admin panle navigations
	
}
