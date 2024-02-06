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
	{	
//		LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminSetting ass= new AdminSetting(driver);
//		ass.Setting();
//		ass.EventOpen();
//		ass.ClickOnAddEvent();
//		ass.SelectYear("2024");
//		ass.SelectMonth("April");
//		ass.EventName("eve1");
//		ass.EventDescription("xyz");
//		ass.EventBasedOn("Month", null, null);
//		ass.addIteam();
//		ass.EventSave();
//		ass.SwitchToUser(input.get("Useremail"), input.get("userpass"));
		LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));  // this line for tempory
		DEICalender cal= new DEICalender(driver);
		cal.DEIcalender();
		cal.selectingYear("2023");
		cal.searchingEvents("October", "10th – World Mental Health Day");
		Boolean eventmatch=cal.getEventDeatils("10th – World Mental Health Day","World Mental Health Day is celebrated globally on October");
		Assert.assertTrue(eventmatch);
		Boolean match= cal.ValidationOfIteamNameAndDesc("Prioritising well-being","3 ways to prioritise your personal well-being");
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] basicDeatils() throws Throwable
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//HRcalenderAndEvents.json");
		return new Object[][]  { {data.get(0)} };
	}
}


