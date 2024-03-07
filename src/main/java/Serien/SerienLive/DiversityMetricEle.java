package Serien.SerienLive;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class DiversityMetricEle extends abstractReusable {

	WebDriver driver;
	public DiversityMetricEle(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//li[1]//div[1]//div[1]")
	WebElement DiversityButton;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameTextFiled;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1lbir7l']//div[2]")
	WebElement Initiation;
	
	@FindBy(xpath = "//div[@class='maturynamelevel MuiBox-root css-0']")
	List<WebElement> graphAllText;
	
	@FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//button")
	List<WebElement> DMTabsName;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-15q091u']")
	WebElement OverallGenderRepresentation;
		
	

	public ArrayList<String> ValidationAdvanceScaleGraphText ()
	{
		ArrayList<String> adscalegrp = new ArrayList<String>();
		List<WebElement> m = graphAllText;
	      // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println(s);
	         adscalegrp.add(s);
	         }
	      return adscalegrp;
	   }
	
	// Below program for Validate the tabs in advance scale graph
	      public List<WebElement> ValidationTopTabsText ()
	  	{
	  		
	  		// List<WebElement> m = driver.findElements(By.xpath("//div[@class='maturynamelevel MuiBox-root css-0']"));
	  		List<WebElement> m = DMTabsName;
	  	      // iterate over list
	  	      for(int i = 0; i< m.size(); i++) {
	  	         //obtain text
	  	         String s = m.get(i).getText();
	  	         System.out.println(s);
	  	   }
	  	      return m;
	  	}
	      
	    public String OverallGenderRepresentationGrp ()
	    {
	    	waitForWebElementTOApper(OverallGenderRepresentation);
	    	ArrayList<String> SN = new ArrayList<String>();
	    	String ogr =OverallGenderRepresentation.getText();
	    	System.out.println(ogr);
	    	return ogr;
	    }
	
}

