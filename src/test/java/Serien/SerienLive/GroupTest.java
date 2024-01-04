package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class GroupTest extends BaseTest {
	
	@Test(dataProvider = "getdata4")
	public void CreatingGroupinAdminPanle(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		Dm.groups();
		AdminGroupPage ag=new AdminGroupPage(driver);
		ag.creatingGroup(input.get("GroupName"));
		driver.quit();
	}
	
	@Test(dataProvider = "getdata4")
	public void ValidationOfGroupNameUserCountEnrollmentsCount(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("AdminUseremail"), input.get("Adminuserpass"));
		Dm.groups();
		AdminGroupPage ag=new AdminGroupPage(driver);
		ag.SearchingComapnyNameInGroupListSecond();
		
	}
	
	@DataProvider
	public Object[][] getdata4()
	{
		
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		map.put("AdminUseremail", "admin@demo.com");
		map.put("Adminuserpass", "pass2023");
		map.put("expectedExpText", "Subscription Expired");
		map.put("GroupName", "Group xyz1");
		return new Object[][] {{map}};
	}

}
