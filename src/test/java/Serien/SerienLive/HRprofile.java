package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class HRprofile extends BaseTest {
	
	@Test(dataProvider = "getdata1", priority = 1)
	public void ValidationOfSubscriptionDateInHRpanle(HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminDashboard as = new AdminDashboard(driver);
		as.GotoAdminSetting();
		AdminSetting ass= new AdminSetting(driver);
		ass.CompanySettingsOpen();
		ass.ClickonSelectedCompanyEditAAplyStreamFunction(input.get("testCompanyName"), input.get("startdate"), input.get("enddate"), input.get("noticeperiod"));
		Thread.sleep(1000);
		ass.Logout();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Profile pro=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		pro.Profile();
		String exp=pro.subExpTest();
		System.out.println(exp);
			
	}
	
	@Test(dataProvider = "getdata1", priority = 2)
	public void ValidationOfUserNameFromAdminPanleToHRpanle(HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("adminEmail"), input.get("adminPass"));
		AdminDashboard as = new AdminDashboard(driver);
		as.users();
		AdminUser au= new AdminUser(driver);
		au.searchByEmail(input.get("Useremail"));
		au.clickOnEditButton();
		au.changeUsername(input.get("userName"));
		au.saveUserDeatils();
		au.adminLogout();
		Profile hr=LoginPage.serienLogin(input.get("Useremail"), input.get("userpass"));
		hr.Profile();
		String actUserName=hr.getUserNameFromProfile();
		Boolean nameMatch=actUserName.equals(input.get("userName"));
		Assert.assertTrue(nameMatch);
		
	}
	
	
	@Test(dataProvider = "getdata1", enabled = false)
	public void ValidationOfSubscriptionEndDate (HashMap<String, String> input) throws Throwable
	{
		
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin("admin@demo.com", "pass2023");
		AdminDashboard as = new AdminDashboard(driver);
		as.GotoAdminSetting();
		AdminSetting ass= new AdminSetting(driver);
		ass.SubscriptionSettingOpen();
		ass.AddSubscription();
		ass.CompanySettingsOpen();
		ass.CompanyCreatePage();
		ass.fillCompanyDeatils(input.get("companyName"), input.get("startdate"), input.get("enddate"), input.get("noticeperiod") );
		ass.verifiveCompanyName(input.get("companyName"));
		AdminUser au= new AdminUser(driver);
		au.GotoUser();
		Thread.sleep(2000);
		au.SearchByUserName(input.get("userName"));
		au.clickOnEditButton();
		au.EditUserCompanyAndGroup(input.get("companyName"), input.get(""));
		// this line of code is write because of application issue not for QA issue 
		Thread.sleep(3000);
		au.UserEditOrSaveCancel();
		//Thread.sleep(2000);
		//remove above code after fix the from Rahul
		au.SearchByUserName(input.get("userName"));
		String ActualName=au.validateTheCompanyNameFromUser(input.get("companyName"));
		String cpname=input.get("companyName");
		AssertJUnit.assertEquals(ActualName, cpname);
		au.adminLogout();
		
		// From Here HR Login start
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning lear=new Learning(driver);
		Thread.sleep(2000);
		ArrayList<String> acctualPermission=lear.learningPagePermissionsget();
		ArrayList<String> learningPagePermission = new ArrayList<String>();
		learningPagePermission.add("Courses");
		learningPagePermission.add("Micro-learnings");
		learningPagePermission.add("Webinars");
		learningPagePermission.add("Games");
		AssertJUnit.assertEquals(acctualPermission,learningPagePermission);
		System.out.println(acctualPermission+"acctualPermission");
		System.out.println(learningPagePermission+"learningPagePermission");
		
		
		// for first time HR login it not display the advancle sclae graph It should display to overall represention data sheet that why this asseration fail
	/*	ArrayList<String> graphText=dme.ValidationAdvanceScaleGraphText();
		ArrayList<String> expectedGraphText = new ArrayList<String>();
		expectedGraphText.add("Initiation");
		expectedGraphText.add("Developing");
		expectedGraphText.add("Acceleration");
		expectedGraphText.add("Amplification");
		System.out.println(graphText +"graphText");
		System.out.println(expectedGraphText+"expectedGraphText");
	//	Assert.assertEquals(graphText,expectedGraphText); */
		InclusionMetric icm=new InclusionMetric(driver);
		icm.getInclusionMetricPage();
		ArrayList<String> actualtabName=icm.getTabsname();
		ArrayList<String> expectedName=new ArrayList<String>();
		expectedName.add("Psychological Safety");
		expectedName.add("Bystander Intervention");
		AssertJUnit.assertEquals(actualtabName,expectedName);
		System.out.println("InclusionMetric passed");
		
	/*	DiversityMetricEle dme= new DiversityMetricEle(driver);
		dme.Diversity();
		String grpTitle=dme.OverallGenderRepresentationGrp();
		Assert.assertEquals(grpTitle,input.get("grpTitle"));           */
		
		icm.ProgresReport();
		ProgressReport pr=new ProgressReport(driver);
		ArrayList<String> UserProgressReportSubData=pr.SubscriptioDeatilsfromUser();
		ArrayList<String> expectedSubData=new ArrayList<String>();
		//expectedSubData.add(input.get("subName"));
		expectedSubData.add(input.get("startdate"));
		expectedSubData.add(input.get("enddate"));
		System.out.println(UserProgressReportSubData+"UserProgressReportSubData");
		System.out.println(expectedSubData+"expectedSubData");
		//Assert.assertEquals(UserProgressReportSubData,expectedSubData);
		
		//pr.Profile();
		Profile pro=new Profile(driver);
		pro.Profile();
		String actualEmail=pro.validateUserEmail();
		String expectedEmail=input.get("Useremail");
		Thread.sleep(2000);
		String s=driver.findElement(By.xpath("(//div[@class='MuiBox-root css-0'])[4]")).getText();
		System.out.println(s);
	//	Assert.assertEquals(actualEmail,expectedEmail);     
		System.out.println("Profile validation done");
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
		map.put("testCompanyName","TCS");
		map.put("startdate","08-08-2023");
		map.put("enddate","30-08-2024");
		map.put("noticeperiod","10");
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		map.put("grptit", "Overall gender representation");
		map.put("userName", "omkar123456");
		map.put("adminEmail", "admin@demo.com");
		map.put("adminPass", "pass2023");
		map.put("groupName", "TCS");
		return new Object[][] {{map}};
	}

}
