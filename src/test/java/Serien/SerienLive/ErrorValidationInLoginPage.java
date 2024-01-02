package Serien.SerienLive;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
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
import serien.TestComponents.Retry;

public class ErrorValidationInLoginPage extends BaseTest {
	
	//data provide by the DataProvider 
	
	@Test(dataProvider = "getdata", retryAnalyzer=Retry.class)//here we also applied test retry method
	public void invaildeCredentional(String email, String pass) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(email, pass);
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"rixij84515@rc3s.com", "password"}/*,{"omkar1@gmail.com", "pass2"},{"omkar2@gmail.com","pass3"}*/};
	}

}
