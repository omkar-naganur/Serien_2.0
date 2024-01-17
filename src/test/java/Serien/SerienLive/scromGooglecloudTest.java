package Serien.SerienLive;
import org.testng.annotations.Test;
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

public class scromGooglecloudTest extends BaseTest {
	
	//data provide by the DataProvider 
	
	@Test(dataProvider = "getdata")
	public void scromFileUpload(HashMap<String, String> input) throws Throwable
	{	
		LoginPage lp= new LoginPage(driver);
		lp.gooleColudLogin(input.get("email"), input.get("pass"));
		lp.gooleColudFile(input.get("filePath"));
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("email","omkar@krishworks.com");
		map.put("pass","sisshribha");
		map.put("filePath","sisshribha");
		
		return new Object[][] {{map}};
	}

}
