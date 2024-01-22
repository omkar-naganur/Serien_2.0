package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class EndToEndTestCase extends BaseTest {
	
	@Test(dataProvider = "getdata2")
	public void FromAdminPanleExpireTheSubscription(HashMap<String, String> input) throws Throwable
	{
		String companyname=input.get("companyName");
		String groupName= input.get("groupName");
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		AdminSetting as= new AdminSetting(driver);
/*		Dm.Setting();	
		as.CompanySettingsOpen();
		as.CompanyCreatePage();
		as.fillCompanyDeatils(companyname, input.get("startdate"), input.get("enddate"), input.get("noticeperiod"));
		as.verifiveCompanyName(companyname); */
		
/*		AdminGroupPage ag= new AdminGroupPage(driver);
		ag.groups();
		ag.creatingGroup(input.get("groupName"), companyname, input.get("groupExpDate"));
		ag.SearchingComapnyNameInGroupListSecond(groupName); */
		AdminUser au= new AdminUser(driver);
		au.users();
		au.searchByEmail(input.get("Useremail"));
		au.clickOnEditButton();
		au.EditUserCompanyAndGroup(companyname, groupName);
		
	}
	
	@DataProvider
	public Object[][] getdata2()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		// Login deatils 
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		map.put("AdminUseremail", "admin@demo.com");
		map.put("Adminuserpass", "pass2023");
		//*********************************
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		String companyName = "TCS"+rand_int1;
		map.put("companyName", "TCS755");
		//***************************************
		   LocalDateTime currentLocalDateTime = LocalDateTime.now(); 
	        // Create DateTimeFormatter instance with specified format
	        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        // Format LocalDateTime to String
	        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);  
		map.put("startdate", formattedDateTime);
	//**********************************************************
		map.put("enddate", "30-12-2024");
		map.put("noticeperiod", "10");
		map.put("expectedExpText", "Subscription Expired");
		map.put("groupName", "TCS755Group1");
		map.put("groupExpDate", "30-12-2024");
	
		return new Object[][] {{map}};
	}
}
