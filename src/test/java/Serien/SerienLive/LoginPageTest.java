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

public class LoginPageTest extends BaseTest {
	
	//data provide by the DataProvider 
	
	@Test(dataProvider = "getdata", priority = 1)
	public void invaildeCredentional(HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("email"), input.get("pass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
		driver.close();
	}
	
	@Test(dataProvider = "getdata", priority = 2)
	public void vaildeCredentional(HashMap<String, String> input) throws Throwable
	{	
		
		Profile valideProfile=LoginPage.serienLogin(input.get("valideEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		Assert.assertTrue(emailTest);
		System.out.println(actEmail);
		driver.close();
	}
	
	@Test(dataProvider = "getdata", priority = 3)
	public void InvalidespaceEmail(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("extraSpaceEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		Assert.assertTrue(emailTest);
		System.out.println(actEmail);
		driver.close();
	}
	
	@Test(dataProvider = "getdata", priority = 4)
	public void ValidateEmailFieldByEnteringCapitalLaters(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("capitalEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		Assert.assertTrue(emailTest);
		System.out.println(actEmail);
		driver.close();
	}
	
	@Test(dataProvider = "getdata", priority = 5)
	public void ValidateloginWithInvalidEmailCredentials(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("invalideEmail"), input.get("ValidePass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
		driver.close();
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{	
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//serienUserData2.json");
		return new Object[][]  { {data.get(0)} };
	}

}
