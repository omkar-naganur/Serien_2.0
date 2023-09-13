package Serien.SerienLive;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import java.util.Random;

public class AdminSetting extends abstractReusable{

	// Create an instance of Random class
	Random random = new Random();
	// Generate random integer between 0 (inclusive) and 100 (exclusive)
	int randomInt = random.nextInt(100);
	String SubName = "xyz"+randomInt;
	WebDriver driver;
	public AdminSetting(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Admin Subscription Web Elements
	
	@FindBy(xpath = "//a[@href='/admin/settings/SubscriptionList']//button")
	WebElement SubscriptionListSettingOpen;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement AddSubscription;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement SubscriptionName;
	
	@FindBy(xpath = "(//input[@type='checkbox'])")
	List<WebElement> checkbox;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement SubscriptionSave;
	
	@FindBy(xpath = "//div[@class='subscriptionUserTabel subscriptionTabelTabelBody']/div[2]")
	List<WebElement> SubscriptionNameList;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement BackButton;
	
	//Admin Company Setting Web Elements
	
	@FindBy(xpath = "//a[@href='/admin/settings/company-department']")
	WebElement CompanySettings;
	
	@FindBy(xpath = "//a[@href='/admin/settings/companycreate']")
	WebElement CompanyCreateButton;
	
	@FindBy(xpath = "//input[@name='companyName']")
	WebElement companyNameTestFiled;
	
	@FindBy(css = "div[role='button']")
	WebElement SubscriptionPlans;
	
	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> subName;
	
	@FindBy(xpath = "(//input[@type='date'])[1]")
	WebElement planStartDate;
	
	@FindBy(xpath = "(//input[@type='date'])[2]")
	WebElement planEndDate;
	
	@FindBy(xpath = "//input[@type='number']")
	WebElement noticePeriod;
	
	@FindBy(css = "label[role='button']")
	WebElement CompanySettingsSubmit;
	
	@FindBy(xpath = "//div[@class='templatename']")
	List<WebElement> companyNameList;
	
	
	public void SubscriptionSettingOpen () throws Throwable
	{
		waitForWebElementTOApper(SubscriptionListSettingOpen);
		SubscriptionListSettingOpen.click();
		
	}
	public void CompanySettingsOpen () throws Throwable
	{
		waitForWebElementTOApper(CompanySettings);
		CompanySettings.click();
	}
	public void CompanyCreatePage () throws Throwable
	{
		waitForWebElementTOApper(CompanyCreateButton);
		CompanyCreateButton.click();
	}
	
	public void fillCompanyDeatils (String companyName, String startdate, String enddate, String noticeperiod) throws Throwable
	{
		companyNameTestFiled.click();
		companyNameTestFiled.sendKeys(companyName);
		SubscriptionPlans.click();
		waitForWebElementTOApper(subName);
		WebElement selectedElement = null;

		for (WebElement element : subName) {
		    if (element.getText().equals(SubName)) {
		        selectedElement = element;
		        break; // Found the desired element, so exit the loop.
		    }
		}

		if (selectedElement != null) {
		    // Perform your actions with the selectedElement here
			selectedElement.click();
		} else {
		    // Handle the case when the element is not found
			System.out.println("Your Subscription not found");
			System.err.println(SubName);
		}
		// write from here Plane start date plane end date and notice period click on Submit button
		SubscriptionPlans.sendKeys(Keys.TAB);
		planStartDate.sendKeys(startdate);
		planStartDate.sendKeys(Keys.TAB);
		planEndDate.sendKeys(enddate);
		planEndDate.sendKeys(Keys.TAB);
		noticePeriod.sendKeys(noticeperiod);
		CompanySettingsSubmit.click();
	}
	
	public void verifiveCompanyName (String companyName)throws Throwable
	{
		waitForWebElementTOApper(companyNameList);

		String b = "";
		List<WebElement> m = companyNameList;
	      // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println(s);
	         b=s;
	         
	         }
	      
	      if(b==companyName)
	         {
	        	 System.out.println(b);
	         }
	         else
	         {
	        	 System.out.println("company creation fail");
	         }
	      
	}
	
	
	public void AddSubscription () throws Throwable
	{
		AddSubscription.click();
		SubscriptionName.click();
		SubscriptionName.sendKeys(SubName);
		
		List<WebElement> els = checkbox;
	      // iterate over list
		for ( WebElement el : els ) {
		    if ( !el.isSelected() ) {
		        el.click();
		    }
		}
		SubscriptionSave.click();
		Thread.sleep(2000);
		String SubAlertPoup=driver.switchTo().alert().getText();
		System.out.println(SubAlertPoup);
		driver.switchTo().alert().accept();
		waitForWebElementTOApper(SubscriptionNameList);
	
		String b = "";
		List<WebElement> m = SubscriptionNameList;
	      // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println(s);
	         b=s;
	         }
	     
	      if(b==SubName)
	         {
	        	 System.out.println(b);
	         }
	         else
	         {
	        	 System.out.println("subscrtion creation fail");
	         }
	      BackButton.click();
	 
	}
	
	
	
}

