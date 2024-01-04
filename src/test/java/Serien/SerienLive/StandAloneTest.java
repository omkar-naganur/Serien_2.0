package Serien.SerienLive;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
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

public class StandAloneTest extends BaseTest {
	
	@Test
	public void profileValidation() throws Throwable
	{	
		
		//LoginPage LoginPage=lunchApplication(); //this line optimized with Base class
		//Constructor written in the Login PageObject file
		//rixij84515@rc3s.com
		Profile profile=LoginPage.serienLogin("subhajit@krishworks.com", "password");
		Thread.sleep(2000);
		profile.gotoProfile();
		
		List<WebElement> products = driver.findElements(By.xpath("//li")); 
		
		//profile.sidemenuValidation();
		
		for (WebElement CwebElement : products) 
		{
			Thread.sleep(1000);
			WebElement StringLink = CwebElement.findElement(By.xpath("//div[2]/div[1]"));
			String king = StringLink.getText();
			System.out.println("om"+king);
		}
		String userName1= "Subhajit";
		String userEmail1= "subhajit@krishworks.com";
		String userSubName1= "ADMIN Testing";
		
		Boolean UserName = profile.ValidationBasicDeatils(userName1, userEmail1, userSubName1);
		Assert.assertTrue(UserName);
		System.out.println(UserName);
	}
	
	@Test
    public void profileValidationNagative() throws Throwable
	{	
		
		//LoginPage LoginPage=lunchApplication(); this line optimized with Base class
		//Constructor written in the Login PageObject file
		//Profile profile=LoginPage.serienLogin("rixij84515@rc3s.com", "password");
		Profile profile=LoginPage.serienLogin("subhajit@krishworks.com", "password");
		Thread.sleep(2000);
		profile.gotoProfile();
		
		List<WebElement> products = driver.findElements(By.xpath("//li")); 
		
		//profile.sidemenuValidation();
		
		for (WebElement CwebElement : products) 
		{
			Thread.sleep(1000);
			WebElement StringLink = CwebElement.findElement(By.xpath("//div[2]/div[1]"));
			String king = StringLink.getText();
			System.out.println("om"+king);
		}
		String userName1= "Subhajit12";
		String userEmail1= "rixij84515@rc3s.com";
		String userSubName1= "ADMIN Testing";
		
		Boolean UserName = profile.ValidationBasicDeatils(userName1, userEmail1, userSubName1);
		Assert.assertFalse(UserName);
		System.out.println(UserName);
	}

}
