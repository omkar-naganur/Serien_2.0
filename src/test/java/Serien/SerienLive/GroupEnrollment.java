package Serien.SerienLive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class GroupEnrollment extends BaseTest {
	
	@Test(dataProvider = "getdata1")
	public void ValidationOfSubscriptionEndDate (HashMap<String, String> input) throws Throwable
	{
		
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin("admin@demo.com", "pass2023");
		AdminDashboard as = new AdminDashboard(driver);
		
	}
	
	@DataProvider
	public Object[][] getdata1()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		// Create an instance of Random class
		Random random = new Random();
		// Generate random integer between 0 (inclusive) and 100 (exclusive)
		int randomInt = random.nextInt(100);
		String comName = "om"+randomInt;
		map.put("companyName",comName);
		map.put("startdate","08-08-2023");
		map.put("enddate","30-08-2023");
		map.put("noticeperiod","10");
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		map.put("grptit", "Overall gender representation");
		map.put("userName", "omkar");
		return new Object[][] {{map}};
	}

}
