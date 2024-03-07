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
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath = "//ul[@role='listbox']//li") 
	List<WebElement> ListOfCompanyName;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td'][3]") 
	List<WebElement> ListOfGroupNames ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td'][4]") 
	List<WebElement> numberOfMenebrsInGroup ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td'][5]") 
	List<WebElement> numberOfCourses ;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-table-td'][7]//select") 
	List<WebElement> ListOfActionButton;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-pagination-cnt-item'][2]")
	WebElement PagenationForwardButton;
	
	@FindBy(xpath = "//div[@class='admin-overdue-bottom-pagination-cnt-item'][1]")
	WebElement PagenationwardButton;
	
	public void creatingGroup(String GroupName, String companynName, String groupexp) throws Throwable
	{
		waitForWebElementTOApper(addNewGroup);
		addNewGroup.click();
		String companynameforEdit= companynName;
		
		waitForWebElementTOApper(selectComapnyDropDown);
		selectComapnyDropDown.click();
		
		waitForWebElementTOApper(ListOfCompanyName);
	//	System.out.println("G3");
	      for(int i = 0; i< ListOfCompanyName.size(); i++) 
	      {
	         String s = ListOfCompanyName.get(i).getText();
	        System.out.println(s);
	         
	         if(s.equals(companynameforEdit))
	         {
	        	 ListOfCompanyName.get(i).click();
	        	 System.out.println("ok");
	        	// ListofComapny.get(i).click();
	        	 break;
	         }
	         else
	         {
	        	 
	        	 System.out.println("company Name Not Found");
	         }
	        
	      }   
	      groupName.sendKeys(GroupName);
	      GroupDescription.sendKeys("HI");
	      ExpiryDate.sendKeys(groupexp);
	      SaveUpdate.click();
	      Thread.sleep(2000);
	      ScrollUp500();
	}
	
	String s ;
	  	public ArrayList<String> SearchingGroupNameInGroupList (String groupName) throws Throwable
		{
	  		ArrayList<String> membersAndCourses = new ArrayList<String>() ;
			waitForWebElementTOApper(ListOfGroupNames);
			Thread.sleep(2000);
			ArrayList<String> lastArray = new ArrayList<String>() ;
			boolean milgya = false;
			while(!milgya) {
				ArrayList<String> ar = new ArrayList<String>();
				for(int i = 0; i< ListOfGroupNames.size(); i++) 
			      {   	  
			    	  waitForWebElementTOApper(ListOfGroupNames);
			         String s = ListOfGroupNames.get(i).getText();
			         ar.add(s);
			      }
			     
			      if(ar.contains(groupName))
			         {
			    	  int num=ar.indexOf(groupName);
			        	 milgya = true;
			        	 System.out.println("milgya***********************");
			        	String numOfCourses= numberOfCourses.get(num).getText();
			        	String numOfMenebrsInGroup= numberOfMenebrsInGroup.get(num).getText();
			        	String details= (numOfMenebrsInGroup+" "+numOfCourses);
			        	membersAndCourses.add(details);
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
			return membersAndCourses;
		     
	}
	  	
	  	
	  	public boolean groupEdit (String Groupname) throws Throwable
		{
			
					waitForWebElementTOApper(ListOfGroupNames);
					Thread.sleep(2000);
					ArrayList<String> lastArray = new ArrayList<String>() ;
					ArrayList<String> lastsArray = new ArrayList<String>() ;
					boolean milgya = false;
					while(!milgya) {
						ArrayList<String> ar = new ArrayList<String>();
						for(int i = 0; i< ListOfGroupNames.size(); i++) 
					      {   	   		      
					         ar.add(ListOfGroupNames.get(i).getText());       
					      }
						
						for(int i = 0 ; i < ar.size() ; i++) {
							String wow= ar.get(i);
							if(wow.equals(Groupname)){
								System.out.println("milgya***********************");
								System.out.println(i);
								clickOnViewButton(i);
								milgya = true;
								Thread.sleep(1000);
							}
						}
						if(!milgya) {
							if(lastArray.size()!= 0) {
						    	  boolean xyz = 	false;
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
						}else {
							System.out.println("milgya***********************Double check");
						} 
					}
					return milgya;

	}
		public void clickOnViewButton(int i) {
			Select se = new Select(ListOfActionButton.get(i));
			se.selectByVisibleText(" Edit");	
		}

	public void UpdateGroupExpiredDate(String GropExpInvalide, String gpName) throws Throwable {
		groupEdit(gpName);
		waitForWebElementTOApper(ExpiryDate);
		ExpiryDate.sendKeys(GropExpInvalide);
		Thread.sleep(1000);
		waitForWebElementTOApper(SaveUpdate);
		SaveUpdate.click();
		Thread.sleep(2000);
		
	}
		
}

