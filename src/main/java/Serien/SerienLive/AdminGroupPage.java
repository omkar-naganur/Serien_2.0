package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
//	@FindBy(xpath = "//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-18fyyqq']")
//	List<WebElement> ListofComapny;
	
	@FindBy(xpath = "//li[@data-value]")
	List<WebElement> ListofComapny;
	
	@FindBy(xpath = "//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary  css-1ebyv4v']")
	WebElement selectComapnyDropDown;
	
	@FindBy(xpath = "//input[@name='groupName']")
	WebElement groupName;
	
	@FindBy(xpath = "//textarea[@name='groupDesc']")
	WebElement GroupDescription ;
	
	@FindBy(xpath = "//input[@name='expDate']")
	WebElement ExpiryDate;
	
	@FindBy(xpath = "//button[text()='SaveUpdate']")
	WebElement SaveUpdate;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-cnt-grp']//div[3]") 
	//      old > //div[@class='admin-overdue-bottom-table']//div[3]
	List<WebElement> ListOfGroulName;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-pagination-cnt-item'][2]")
	WebElement PagenationForwardButton;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-pagination-cnt-item'][1]")
	WebElement PagenationwardButton;
	
	public void creatingGroup(String GroupName) throws Throwable
	{
		waitForWebElementTOApper(addNewGroup);
		addNewGroup.click();
		String companynameforEdit= "TCS";
		
		waitForWebElementTOApper(selectComapnyDropDown);
		selectComapnyDropDown.click();
		
		waitForWebElementTOApper(ListOfGroulName);
		
	      for(int i = 0; i< ListOfGroulName.size(); i++) 
	      {
	         String s = ListOfGroulName.get(i).getText();
	        System.out.println(s);
	         
	         if(s.equals("TCS"))
	         {
	        	 System.out.println("ok");
	        	// ListofComapny.get(i).click();
	        	 break;
	         }
	         else
	         {
	        	 
	        	 System.out.println("companyNameNotFound");
	         }
	         groupName.sendKeys(GroupName);
	         GroupDescription.sendKeys("HI");
	         ExpiryDate.sendKeys("25122023");
	            SaveUpdate.click();
	      }   
	}
	
	String s ;
	  	public void SearchingComapnyNameInGroupListSecond() throws Throwable
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			waitForWebElementTOApper(ListOfGroulName);
			Thread.sleep(2000);
			ArrayList<String> lastArray = new ArrayList<String>() ;
			boolean milgya = false;
			while(!milgya) {
				ArrayList<String> ar = new ArrayList<String>();
				for(int i = 0; i< ListOfGroulName.size(); i++) 
			      {   	  
			    	  waitForWebElementTOApper(ListOfGroulName);
			         String s = ListOfGroulName.get(i).getText();
			         ar.add(s);
			      }
			     
			      if(ar.contains("Esper Group"))
			         {
			        	 milgya = true;
			        	 System.out.println("milgya***********************");
			        	 break;
			         }else  {
			        	 if(lastArray.size()!= 0) {
					    	  boolean xyz = false;
					    	  for(int i = 0 ; i < lastArray.size() && i < ar.size();i++) {
					    		  System.out.println(lastArray.get(i)+" == "+ar.get(i));
					    		  if(!lastArray.get(i).equals(ar.get(i))) {
					    			  i = lastArray.size();
					    			  xyz = true;
					    		  }
					    	  }
					    	  System.out.println("xyz : "+ xyz);
					    	  if(!xyz) {
					    		  milgya = true;
					    		  System.out.println("NAhi mil raha");
					    	  }
					      }
					       lastArray = ar;
			        	 PagenationForwardButton.click();
			        	 Thread.sleep(2000);
			         }
			      
			}
		     
	}}

