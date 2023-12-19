package Serien.SerienLive;

import java.util.List;

import javax.xml.xpath.XPath;

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
	
	@FindBy(xpath = "//a[@href='/admin/groupEdits/']")
	WebElement addNewGroup;
	
	@FindBy(css = "//li[@role='option']")
	List<WebElement> SelectCompany;
	
	@FindBy(xpath = "//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-18fyyqq']")
	List<WebElement> ListofComapny;
	
	@FindBy(xpath = "//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary  css-1ebyv4v']")
	WebElement selectComapnyDropDown;
	
	public void creatingGroup() throws Throwable
	{
		waitForWebElementTOApper(addNewGroup);
		addNewGroup.click();
		String companynameforEdit= "TCS";
		
		waitForWebElementTOApper(selectComapnyDropDown);
		selectComapnyDropDown.click();
		
	      for(int i = 0; i< ListofComapny.size(); i++) 
	      {
	         
	         String s = ListofComapny.get(i).getText();
	         System.out.println(s);
	         
	         if(s.equals(companynameforEdit))
	         {
	        	 System.out.println("ok");
	        	 ListofComapny.get(i).click();
	        	 break;
	        	 
	         }
	         else
	         {
	        	 System.out.println("companyNameNotFound");
	         }
	    
	}

	}}

