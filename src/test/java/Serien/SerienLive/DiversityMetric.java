package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

public class DiversityMetric extends BaseTest {
	
	// this class is under development no clear gols availabe 
	
	@Test(dataProvider = "getdata4")
	public void ValidationDiversityMetric(HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		DiversityMetricEle diversit=new DiversityMetricEle(driver);
		diversit.Diversity();
		ArrayList<String> s =diversit.ValidationAdvanceScaleGraphText();
		System.out.println(s);
		List<WebElement> p = diversit.ValidationTopTabsText();	
		System.out.println(p);
	}
	
	@DataProvider
	public Object[][] getdata4()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		map.put("userpass", "password");
		return new Object[][] {{map}};
	}

}
