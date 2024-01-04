package Serien.SerienLive;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import serien.TestComponents.BaseTest;

public class HashMapUsage extends BaseTest {
	
	//data provide by the DataProvider 
	
	@Test(dataProvider = "getdata")
	public void invaildeCredentional(HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("email"), input.get("pass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("email","omkar3@gmail.com");
		map.put("pass","pass4");
		
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("email","omkar2@gmail.com");
		map1.put("pass","pass2");
		
		return new Object[][] {{map},{map1}};
	}

}
