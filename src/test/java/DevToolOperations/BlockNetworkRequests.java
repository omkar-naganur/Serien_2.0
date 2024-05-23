package DevToolOperations;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
//import org.openqa.selenium.devtools.
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;
import serien.TestComponents.BaseTest;

public class BlockNetworkRequests extends BaseTest{

	@Test
	public void BlockNetworkRequests(String[] args) throws InterruptedException, Throwable {
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(org.openqa.selenium.devtools.v114.network.Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(org.openqa.selenium.devtools.v114.network.Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		//1793 2033
		
	}

}
