package serien.TestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Serien.SerienLive.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage LoginPage;
		
	public WebDriver  initializeDriver() throws IOException 
	{
		// properties class
		//jenkind commite
		
		Properties prop= new Properties();
		
		//Converting file objective to input stream
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//serien//Resource//GlobalData.properties");
		///media/kwsys4/nonOsPartition/Automation of Serien2.0/SerienLive/src/main/java/serien/Resource/GlobalData.properties
		//your properties objective now reading the file
		prop.load(fis);
		//get the properties file objectives {Property string key}
		//String browserName=prop.getProperty("browser");
		// java ternier operator used
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
		//	System.out.println("Hello boss");
		//	File chromeDriver = new File("/media/kwsys4/nonOsPartition/AutomationSerien4.0/SerienLive/driver/chromedriver.exe");
//		    System.setProperty("webdriver.chrome.driver", "/media/kwsys4/nonOsPartition/AutomationSerien4.0/SerienLive/driver/chromedriver.exe");
//		    driver = new ChromeDriver();
//		    driver.manage().window().maximize();
			
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--start-maximized");
			//this below condination for set up the chrome headless node running 
			//for this you can use this command 'mvn test -PRegression -Dbrowser=chromeheadless'
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			//this below code for full screen dimension give because this is screen standard size
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
			
			////https://www.omgubuntu.co.uk/2022/04/how-to-install-firefox-deb-apt-ubuntu-22-04
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			//System.setProperty("webDriver.edge.driver", "pass the edge.exe file path");
		}
		
		else if(browserName.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
			//System.setProperty("webDriver.edge.driver", "pass the edge.exe file path");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

//	@BeforeMethod
//	public LoginPage launchApplication() throws IOException, InterruptedException
//	{
//		driver =initializeDriver();
//		LoginPage = new LoginPage(driver);
//		LoginPage.gotoLoginPage();
//		return LoginPage;
//	}
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException, InterruptedException
	{
		driver =initializeDriver();
		LoginPage = new LoginPage(driver);
		LoginPage.gotoLoginPage();
		return LoginPage;
	}
	

	@AfterMethod
	public void tearDown()
	{
	//	driver.close();
	}
}
// this link for install jankinkes 
//https://github.com/javaexpresschannel/softwares_installation/blob/master/jenkins%20installation%20in%20Ubuntu
//https://www.youtube.com/watch?v=b-5izLecX2c

/* how to push the code to github
 * git add .
 * git commit -m "message"
 * git push
 */ 
//	 	//a[contains(@class, 'link')]
//		//a[contains(text(),'SAP M')]
// attrubites containes  //a[contains(@prop,'Foo')] 

//scrcpy
//
// <release>17</release>

/* <plugin>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.8.0</version>
<configuration>
	   <source>17</source>
     <target>17</target>
	 
</configuration>
</plugin> */

// jenkin 1
/// omkar change for web hook 1
/// omkar change for web hook 2
/// omkar change for web hook 2
/// omkar change for web hook 3
/// omkar change for web hook 4
/// omkar change for web hook 5
/// omkar change for web hook 6
/// omkar change for web hook 7
/// omkar change for web hook 8
/// omkar change for web hook 9
/// omkar change for web hook 10
/// omkar change for web hook 11
