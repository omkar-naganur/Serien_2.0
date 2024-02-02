package Serien.SerienLive;

import java.util.List;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;  

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import java.util.Random;

public class AdminSetting extends abstractReusable {

	// Create an instance of Random class
	Random random = new Random();
	// Generate random integer between 0 (inclusive) and 100 (exclusive)
	int randomInt = random.nextInt(100);
	String SubName = "xyz"+randomInt;
	String companynameforEdit ;
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
	
	@FindBy(xpath ="//div[@class='setting_details_table']//div[@class='outer-inner-container']/div[@class='templatename']")
	WebElement CompanyNameListforfirstone;
	
	@FindBy(xpath ="//div[@class='setting_details_table']//div[@class='outer-inner-container']/div[@class='templatename']")
	List<WebElement> CompanyNameListforALL;
	
	@FindBy(xpath = "//a[@href='/admin/settings/companycreate']")
	WebElement CompanyEditButton;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement CompanyLogo;
	
	@FindBy(xpath = "//a[@href='/admin/settings/companycreate']")
	List<WebElement> CompanyEditButtonList;
	
	@FindBy(xpath = "//div[@class='outer-inner-container']//div[@class='templatename'][1]")
	List<WebElement> onlycompanyName;
	
	public void SubscriptionSettingOpen () throws Throwable
	{//input[@type='file']
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
		String subscriptionName= "Testing";
		companyNameTestFiled.click();
		companyNameTestFiled.sendKeys(companyName);
		SubscriptionPlans.click();
		waitForWebElementTOApper(subName);
		WebElement selectedElement = null;

		for (WebElement element : subName) {
		    if (element.getText().equals(subscriptionName)) {
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
		CompanyLogo.sendKeys("/media/kwsys4/nonOsPartition/AutomationSerien4.0/SerienLive/testSuites/apple.png");
		Thread.sleep(2000);
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
	         if(b.equals(companyName))
	         {
	         	 break;
	         }
	         else
	         {
	        	 System.out.println("company name not matched");
	         }
	         
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
	     
	      if(b.equals(SubName))
	         {
	        	 System.out.println(b);
	         }
	         else
	         {
	        	 System.out.println("subscrtion creation fail");
	         }
	      BackButton.click();
	}
	// not complated
	public void ClickonSelectedCompanyEdit (String comame) throws Throwable
	{
		companynameforEdit= comame;
		//waitForWebElementTOApper(CompanyNameListfor);
		String exname= CompanyNameListforfirstone.getText();
		//System.out.println(ListofComapnyNames);
		System.out.println(exname);
		
		String b = "";
		List<WebElement> m = CompanyNameListforALL;
	      // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println(s);
	         b=s;
	         if(b.equals(companynameforEdit))
	         {
	        	 System.out.println("ok");
	        	 // we need to click the Edit button here need to write the Logic
	        	// CompanyNameListforALL.in
	        	 
	        	 break;
	        	 
	         }
	         else
	         {
	        	 System.out.println("companyNameNotFound");
	         }
	         }
		
	}
	
	public void ClickonSelectedCompanyEditAAplyStreamFunction (String comame, String startdate, String enddate, String noticeperiod) throws Throwable
	{
		companynameforEdit= comame;
		
		String b = "";
		List<WebElement> m = onlycompanyName;
	      // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println(s);
	         b=s;
	    
	         if(b.equals(companynameforEdit))
	         {
	        	 System.out.println("ok");
	        	 
	       driver.findElements(By.xpath("//div[@class='setting_details_table']//div[@class='outer-inner-container']/div[@class='templatename']/..//div[3]//div[3]//a[@href='/admin/settings/companycreate']")).get(i).click();
	       Thread.sleep(2000);
	        break;
	        	 
	         }
	      else
	         {
	        	 System.out.println("companyNameNotFound");
	         }
	         }
	      planStartDate.click();
	      planStartDate.sendKeys(startdate);
			planStartDate.sendKeys(Keys.TAB);
			planEndDate.sendKeys(enddate);
			planEndDate.sendKeys(Keys.TAB);
			noticePeriod.sendKeys(noticeperiod);
			Thread.sleep(2000);
			CompanySettingsSubmit.click();
			// after click on submite button still data not chnaged in back end but it working manual test fine
			try {
	            // establish, open connection with URL
	            HttpURLConnection cn = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
	            // set HEADER request
	            cn.setRequestMethod("HEAD");
	            // connection initiate
	            cn.connect();
	            //get response code
	            int res = cn.getResponseCode();
	            //Display
	            System.out.println("Http response code: " + res);
	            Thread.sleep(2000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		
	}
	
	public void ChangeCompanyExpDate () throws Throwable
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		   LocalDateTime now = LocalDateTime.now();
		   System.out.println(dtf.format(now));
		   String date= (dtf.format(now));
		   String enddate = date.replace("/", "");
		   System.out.println(enddate);
		planEndDate.sendKeys(enddate);
		planEndDate.sendKeys(Keys.TAB); 
		CompanySettingsSubmit.click();
		/*
		 *     Date currentDate = new Date();  
      currentDate.setTime(System.currentTimeMillis());  
      Date yesterdayDate = new Date(currentDate.getTime() - (1000 * 60 * 60 * 24));  
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
      String yesterdayDateString = dateFormat.format(yesterdayDate);  
      System.out.println("Yesterday's date: " + yesterdayDateString); 
		 */
		
	}
	
	
	
}

