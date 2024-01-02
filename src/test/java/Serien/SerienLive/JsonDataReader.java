package Serien.SerienLive;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
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

public class JsonDataReader extends BaseTest {
	
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
	public Object[][] getdata() throws IOException
	{	
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//serienUserData.json");
		return new Object[][]  { {data.get(0)}, {data.get(1)} };
	}

}
