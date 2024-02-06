package Serien.SerienLive;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class HRcalenderAndEvents extends BaseTest{

	@Test(dataProvider = "basicDeatils", priority = 1)
	public void ValidationOfEventAndCalender(HashMap<String, String> input) throws Throwable
	{	AdminSetting ass= new AdminSetting(driver);
		int num=ass.randomNumberGenerater();
		System.out.println(num);
		String eventName=input.get("eventName")+num;
		String eventDesc=input.get("eventDesc")+num;
		String iteamName=input.get("iteamName")+num;
		String iteamDesc=input.get("iteamDesc")+num;
		
		LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		ass.Setting();
		ass.EventOpen();
		ass.ClickOnAddEvent();
		ass.SelectYear(input.get("yearOfTheEvent"));
		ass.SelectMonth(input.get("month"));
		ass.EventName(eventName);
		ass.EventDescription(eventDesc);
		ass.EventBasedOn("Month", null, null);
		ass.addIteam(iteamName,iteamDesc, input.get("iteamDocType"), input.get("link"));
		ass.EventSave();
		ass.SwitchToUser(input.get("Useremail"), input.get("userpass"));
//		LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));  // this line for tempory
		DEICalender cal= new DEICalender(driver);
		cal.DEIcalender();
		cal.selectingYear(input.get("yearOfTheEvent"));
		cal.searchingEvents(input.get("month"), eventName);
		Boolean eventmatch=cal.getEventDeatils(eventName,eventDesc);
		Assert.assertTrue(eventmatch);
		Boolean match= cal.ValidationOfIteamNameAndDesc(iteamName,iteamDesc);
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] basicDeatils() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRcalenderAndEvents.json");
		return new Object[][]  { {data.get(0)} };
	}
}


