package Serien.SerienLive;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
	
//	String validEmail = "omkar@krishworks.com";
	String validEmail; // ValidationOfSetPasswordLinkSendSucessfully  depend on vaildeCredentional
	
	//data provide by the DataProvider 
	
	@Test(dataProvider = "getdata", priority = 1)
	public void ValidateInEmailAndPasswordInvalideCredentials(HashMap<String, String> input) throws Throwable
	{	
		Profile profile=LoginPage.serienLogin(input.get("email"), input.get("pass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
	}
	
	@Test(dataProvider = "getdata", priority = 2)
	public void vaildeCredentional(HashMap<String, String> input) throws Throwable
	{	
		validEmail = (input.get("valideEmail"));
		Profile valideProfile=LoginPage.serienLogin(input.get("valideEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		AssertJUnit.assertTrue(emailTest);
		System.out.println(actEmail);
	}
	
	@Test(dataProvider = "getdata", priority = 3)
	public void InvalidespaceEmail(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("extraSpaceEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		AssertJUnit.assertTrue(emailTest);
		System.out.println(actEmail);
	}
	
	@Test(dataProvider = "getdata", priority = 4)
	public void ValidateEmailFieldByEnteringCapitalLaters(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("capitalEmail"), input.get("ValidePass"));
		Profile pf=new Profile(driver);
		pf.gotoProfile();
		String actEmail=pf.validateUserEmail();
		 boolean emailTest = actEmail.equals(input.get("valideEmail"));
		AssertJUnit.assertTrue(emailTest);
		System.out.println(actEmail);
	}
	
	@Test(dataProvider = "getdata", priority = 5)
	public void ValidateloginWithInvalidEmailCredentials(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("invalideEmail"), input.get("ValidePass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);
	}
	
	@Test(dataProvider = "getdata", priority = 6)
	public void ValidateLoginWithInvalidPasswordCredentials(HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("valideEmail"), input.get("invalidePass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);	
	}
	
	@Test(dataProvider = "getdata", priority = 7)
	public void ValidateEmailFieldWithoutAddingAnyDataIntoInEmailTextFiled (HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("noDataInEmial"), input.get("invalidePass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);	
	}
	
	@Test(dataProvider = "getdata", priority = 8)
	public void ValidatePasswordFieldWithoutEnteringThePasswordInThePasswordField (HashMap<String, String> input) throws Throwable
	{	
		Profile valideProfile=LoginPage.serienLogin(input.get("noDataInEmial"), input.get("invalidePass"));
		String expectedErrorMessage="Enter valid Credentials";
		Boolean ErroeMess=LoginPage.ErrorMessage(expectedErrorMessage);
		Assert.assertTrue(ErroeMess);	
	}
	
	@Test(dataProvider = "getdata", priority = 9)
	public void ValidatingLoginWithBrowserBack (HashMap<String, String> input) throws Throwable
	{	
		String LoginUrl=driver.getCurrentUrl();
		Profile valideProfile=LoginPage.serienLogin(input.get("valideEmail"), input.get("ValidePass"));
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		String CurrentUrl=driver.getCurrentUrl();
		Boolean URLmatches=LoginUrl.equals(CurrentUrl);
	//	System.out.println(URLmatches);
		Assert.assertFalse(URLmatches);
		Thread.sleep(2000);	
	}
	
	@Test(dataProvider = "getdata", priority = 10)
	public void ValidatingThePageTitleAndURL (HashMap<String, String> input) throws Throwable
	{	
		String LoginUrl=driver.getCurrentUrl();
		String getTitle=driver.getTitle();
		Boolean matchTitle =getTitle.equals(input.get("PageTitle"));
		Assert.assertTrue(matchTitle);
		Boolean MatchURl= LoginUrl.equals(input.get("LoginURL"));
		Assert.assertTrue(MatchURl);
	}
	
	@Test(dataProvider = "getdata2", priority = 11)
	public void NavigationToForgetPasswordPage (HashMap<String, String> input) throws Throwable
	{	
		LoginPage lp= new LoginPage(driver);
		lp.ForgotPasswordLink();
		ForgetPassword fp=new ForgetPassword(driver);
		Boolean titelmatch= (input.get("Fp")).equals(fp.titleOfBox.getText());
		Assert.assertTrue(titelmatch);	
	}
	
	@Test(dataProvider = "getdata2", priority = 12)
	public void ValidationOfErrorMessageInForgetPasswordPage (HashMap<String, String> input) throws Throwable
	{	
		LoginPage lp= new LoginPage(driver);
		lp.ForgotPasswordLink();
		ForgetPassword fp=new ForgetPassword(driver);
		fp.ClickOnSubmitButton();
		Boolean errormatch= (input.get("err")).equals(fp.GetErroeMessage());
		Assert.assertTrue(errormatch);	
	}
	
	@Test(dataProvider = "getdata2", priority = 13)
	public void ValidationOfErrorMessageInvalidEmailInForgetPasswordPage (HashMap<String, String> input) throws Throwable
	{	
		LoginPage lp= new LoginPage(driver);
		lp.ForgotPasswordLink();
		ForgetPassword fp=new ForgetPassword(driver);
		fp.EnterEmail((input.get("invalidEmail")));
		fp.ClickOnSubmitButton();
		Thread.sleep(1000);
		Boolean errormatch= (input.get("emailErr")).equals(fp.GetErroeMessage());
	//	System.out.println(fp.GetErroeMessage());
		Assert.assertTrue(errormatch);
	}
	
	@Test(dataProvider = "getdata2", priority = 14, dependsOnMethods={"vaildeCredentional"})
	public void ValidationOfSetPasswordLinkSendSucessfully (HashMap<String, String> input) throws Throwable
	{	
		LoginPage lp= new LoginPage(driver);
		lp.ForgotPasswordLink();
		ForgetPassword fp=new ForgetPassword(driver);
		fp.EnterEmail(validEmail);
		fp.ClickOnSubmitButton();
		Boolean errormatch= (input.get("sucessfullMsg")).equals(fp.GetsucesssfullyMessage());
		System.out.println(fp.GetsucesssfullyMessage());
		Assert.assertTrue(errormatch);
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{	
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//serien//Data//serienUserData2.json");
		return new Object[][]  { {data.get(0)} };
	}
	
	@DataProvider
	public Object[][] getdata2()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Fp", "Forgot password");
		map.put("fp URL", "forgot password");
		map.put("err", "Please enter your email");
		map.put("invalidEmail", "Test@gmail.com");
		map.put("emailErr", "Inavlid Email");
		map.put("sucessfullMsg", "A password recovery link has been sent to your registered email id. Please check your spam folder if you do not see the email in your inbox.");
		
		return new Object[][] {{map}};
	}

}
