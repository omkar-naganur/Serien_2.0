package Serien.SerienLive;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import serien.TestComponents.BaseTest;

public class SubscriptionExpired extends BaseTest {
	
	@Test(dataProvider = "getdata2")
	public void FromAdminPanleExpireTheSubscription(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		Dm.Setting();
		AdminSetting as= new AdminSetting(driver);
		as.CompanySettingsOpen();
		as.ClickonSelectedCompanyEdit();	
	}
	
/*	@Test(dataProvider = "getdata2")
	public void HRporatlsubscriptionMessageTesting(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Profile pro= new Profile(driver);
		String actualsubexpTest=pro.subExpTest();
		boolean wow=actualsubexpTest.contains(input.get("expectedExpText"));
		System.out.println(actualsubexpTest);
		System.out.println(wow);
	}*/
	
	@DataProvider
	public Object[][] getdata2()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		map.put("AdminUseremail", "admin@demo.com");
		map.put("Adminuserpass", "pass2023");
		map.put("expectedExpText", "Subscription Expired");
	
		return new Object[][] {{map}};
	}
}
