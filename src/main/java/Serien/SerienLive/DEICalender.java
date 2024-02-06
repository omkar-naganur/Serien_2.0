package Serien.SerienLive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class DEICalender extends abstractReusable{

	WebDriver driver;
	public DEICalender(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameTextFiled ;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password ;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton ;
	
	@FindBy(xpath = "//div[@role='button']//../input/..")
	WebElement year ;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listYear ;
	
	@FindBy(xpath = "//div[@id='month']")
	List<WebElement> listMonth ;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-i6bazn']//div")
	List<WebElement> listEvents ;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-hflso0']")
	List<WebElement> listSeeMoreButton ;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1pv1a1d']/div")
	List<WebElement> listEventsInSeeMore ;
	
	@FindBy(xpath = "//div[@role='dialog']//span")
	WebElement eventDialogCloseButton ;
	
	@FindBy(xpath = "//img[@class='NavbarTopImg']//..")
	WebElement titleOfTheEvent ;
	
//	@FindBy(xpath = "//div[@class='MuiBox-root css-1jeyyxo']/div")
//	List<WebElement> eventDescription ;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1jeyyxo']/div")
	WebElement eventDescription ;
	
	@FindBy(xpath = "//div[contains(@class, 'DEIEventViewGrid')]//div/div[1]/div[1]")
	List<WebElement> iteamNameList ;
	
	@FindBy(xpath = "//div[contains(@class, 'DEIEventViewGrid')]//div/div[1]/div[2]")
	List<WebElement> iteamDescriptionList ;
	
	
	public void serienLogin (String Username, String password) throws Throwable
	{
		userNameTextFiled.sendKeys(Username);
		Password.sendKeys(password);
		Thread.sleep(1000);
		LoginButton.click();
	}
		
	public void gotoLoginPage ()
	{
		driver.get("https://sereininc.live/");
	}

	public void selectingYear(String actYear) throws Throwable {
		Thread.sleep(1000);
		waitForElementTOClickAble(year);
		year.click();
		for (int i = 0; i < listYear.size() ; i++) {
			String yer=listYear.get(i).getText();
			if (yer.equals(actYear)) {
				listYear.get(i).click();
			}
		}
		Thread.sleep(2000);
	}
	
	public void searchingEvents (String month, String eventName) throws Throwable {
		Boolean eventFound = false ;
		for (int i = 0; i < listMonth.size(); i++) {
			String monthsname= listMonth.get(i).getText();
			System.out.println(monthsname);
			if (monthsname.equals(month.toLowerCase()))
			{
				System.out.println("month found "+listMonth.get(i).getText());
			}	
		}
		
		if (!eventFound) {
			
		for (int i = 0; i < listEvents.size(); i++) {
			String eventsList =listEvents.get(i).getText();
			System.out.println(listEvents.get(i).getText());
			if (eventsList.contains(eventName))
			{
				listEvents.get(i).click();
				eventFound =true;
				break ;
			}	
		}
		}
		
		if (!eventFound) {
			
			for (int i = 0; i < listSeeMoreButton.size(); i++) {
				listSeeMoreButton.get(i).click();
				
				for (int j = 0; j < listEventsInSeeMore.size(); j++) {
					String eventsNameInsideSeeMore=listEventsInSeeMore.get(j).getText();
					if (eventsNameInsideSeeMore.contains(eventName)) {
						listEventsInSeeMore.get(j).click();
						eventFound =true;
						System.out.println("found");
						break ;
					}
				}
				if (!eventFound) {
					eventDialogCloseButton.click();
				}
				
			}
		}
		
	}

	public Boolean getEventDeatils(String actTitle, String actDecs) throws Throwable {
		Thread.sleep(2000);
		Boolean validation =false;
		 String TitelOfTheEvent = titleOfTheEvent.getText();
		 String dec= eventDescription.getText();
		 System.out.println(TitelOfTheEvent);
		 System.out.println(dec);
		 if (TitelOfTheEvent.equals(actTitle)&&dec.contains(actDecs)) { 
				System.out.println("event title and description matched");
				validation =true;
			}
		 else {
			System.out.println("unable to match");
		}
		 return validation;
	}
	
	public ArrayList<String> getEventiteamList() {
		
		ArrayList<String> listOfIteamNames = new ArrayList<String>() ;
		
		for (int i = 0; i < iteamNameList.size(); i++) {
			listOfIteamNames.add(iteamNameList.get(i).getText());
		}
	//	System.out.println(listOfIteamNames);
		return listOfIteamNames;
	}
	
	public ArrayList<String> getEventiteamDescriptionList() {
		
		ArrayList<String> listOfDescription = new ArrayList<String>() ;
		
		for (int i = 0; i < iteamNameList.size(); i++) {
			listOfDescription.add(iteamDescriptionList.get(i).getText());
		}
	//	System.out.println(listOfDescription);
		return listOfDescription;
	}

	public boolean ValidationOfIteamNameAndDesc(String iteamName, String IteamDescription) {
		boolean validation =false;
		ArrayList<String> iteamNames = getEventiteamList();
		ArrayList<String> iteamDesc = getEventiteamDescriptionList();
		
		for (int i =0; i<iteamNames.size(); i++ ) {
			if (iteamNames.get(i).equals(iteamName) && iteamDesc.get(i).equals(IteamDescription)) {
				System.out.println("Iteam name & descrption matched");
				validation =true;
			}	
		}
		return validation ;
	}
	
	
	
	
	
}

