package Serien.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		public String alertAccepectMethod () {
			Alert alr = driver.switchTo().alert();
			String text=alr.getText();
			System.out.println(text);
			alr.accept();
			return text;
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
	
	@FindBy(xpath = "(//li[@class='MuiListItem-root MuiListItem-gutters tooltip-wrap css-humwks'])[4]")
	WebElement ProgresReport;
	
//	@FindBy(xpath = "//li[4]//div[1]//div[1]")
//	WebElement ProgresReport;
	
	@FindBy(xpath = "//li[5]//div[1]//div[1]")
	WebElement DEIcalender;
	
	@FindBy(xpath = "//li[6]//div[1]//div[1]")
	WebElement Profile;
	
	// admin panel Side bard Elements
	@FindBy(xpath = "//div[@class='sidebar-cnt']//a[@href='/admin/groupEnrollment']")
	WebElement groupEnrollment;
	
	@FindBy(xpath = "//div[@class='sidebar-cnt']//a[@href='/admin/training']")
	WebElement training;
	
	@FindBy(xpath = "//div[@class='sidebar-cnt']//a[@href='/admin']")
	WebElement dashboard;
	
	@FindBy(xpath = "//a[@href='/admin/users']")
	WebElement users;
	
	@FindBy(xpath = "//div[@class='sidebar-cnt']//a[@href='/admin/groups']")
	WebElement groups;
	
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	WebElement Logout;
	
	@FindBy(xpath = "//a[@href='/admin/settings']")
	WebElement setting;
	
	// HR and User panle navigations
	
	public void adminLogout() throws Throwable
	{
		waitForWebElementTOApper(adminLogut);
		adminLogut.click();
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(1000);
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
	
	public void groupEnrollment()
	{
		waitForWebElementTOApper(groupEnrollment);
		groupEnrollment.click();
	}
	
	public void training()
	{
		waitForWebElementTOApper(training);
		training.click();
	}
	
	public void dashboard()
	{
		waitForWebElementTOApper(dashboard);
		dashboard.click();
	}
	
	public void users()
	{
		waitForWebElementTOApper(users);
		users.click();
	}
	
	public void groups()
	{
		waitForWebElementTOApper(groups);
		groups.click();
	}
	
	public void Logout()
	{
		waitForWebElementTOApper(Logout);
		Logout.click();
	}
	
	public void Setting()
	{
		waitForWebElementTOApper(setting);
		setting.click();
	}
	
	public void ScrollUp500() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
	
	}
	
}
