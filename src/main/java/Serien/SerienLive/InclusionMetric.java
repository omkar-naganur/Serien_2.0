package Serien.SerienLive;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Serien.AbstractComponents.abstractReusable;

public class InclusionMetric extends abstractReusable {

	WebDriver driver;
	public InclusionMetric(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@role='button'])[2]")
	WebElement InclusionMetric;
	
	@FindBy(xpath = "(//button[@role='tab'])[1]")
	WebElement PsychologicalSafety;
	
	@FindBy(xpath = "(//button[@role='tab'])[2]")
	WebElement BystanderIntervention;
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement SendLink;
	
	public void getInclusionMetricPage ()
	{
		InclusionMetric.click();
	}
	
	public ArrayList<String> getTabsname()
	{
		waitForWebElementTOApper(PsychologicalSafety);
		waitForWebElementTOApper(BystanderIntervention);
		String pstext=PsychologicalSafety.getText();
		String bitext=BystanderIntervention.getText();
		ArrayList<String> InclusionMetricPermission = new ArrayList<String>();
		InclusionMetricPermission.add(pstext);
		InclusionMetricPermission.add(bitext);
		System.out.println(pstext+"PsychologicalSafetyPrinted");
		System.out.println(bitext+"BystanderInterventionPrinted");
		return InclusionMetricPermission;
	}
	
	
}

