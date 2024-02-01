package Serien.SerienLive;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import serien.TestComponents.BaseTest;

//my clip board

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetSubDate extends BaseTest {
	
	// trail test 
	
	@Test(dataProvider = "getdata4")
	public void getSubscriptionEndDateInProgressReport (HashMap<String, String> input) throws Throwable
	{
		LoginPage Dm= new LoginPage(driver);
		Dm.serienLogin(input.get("Useremail"), input.get("userpass"));
		Learning ln= new Learning(driver);
		ln.ProgresReport();
		// Example using XPath to locate a graph element
		WebElement graphElement = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-0'])[4]//div[2]"));
		ln.waitForWebElementTOApper(graphElement);
		Actions actions = new Actions(driver);
		//WebElement elementToDoubleClick = driver.findElement(By.id("elementId")); // Replace with the actual element locator
		actions.doubleClick(graphElement).perform();
		// Now, you can get the text from the double-clicked element
		String textAfterDoubleClick = graphElement.getText();
		System.out.println("SubscriptionEndDate"+textAfterDoubleClick);
		
	}
	
	@DataProvider
	public Object[][] getdata4()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Useremail", "omkar@krishworks.com");
		//map.put("Useremail", "subhajit@krishworks.com");
		map.put("userpass", "password");
		return new Object[][] {{map}};
	}

}
