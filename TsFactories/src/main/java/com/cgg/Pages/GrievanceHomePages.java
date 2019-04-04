package com.cgg.Pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.cgg.constants.GrievanceHomePageConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class GrievanceHomePages extends TestBase{
	private WebDriver driver;
	
	public static String citizenAppnum=null;

	public GrievanceHomePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id=GrievanceHomePageConstants.CITIZENNAME)
	private WebElement CitizenName;

	public void sendCitizenName(String citizenName) {
		
		sendKeysToTextBox(this.CitizenName, citizenName);
		
	}
	
	@FindBy(id=GrievanceHomePageConstants.LOCALITY)
	private WebElement Locality;
	
	@FindBy(id=GrievanceHomePageConstants.AJAXSEARCH)
	private WebElement ajaxSearch;

	public void sendLocality(String PartialLocality,String fullLocality) {
		
		sendKeysToTextBox(this.Locality, PartialLocality);
		WaitUtil.waitForElementClickable(ajaxSearch);
		
		//WebElement ajax_box=  driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul"));
		 
		  List<WebElement>values=ajaxSearch.findElements(By.tagName("li"));
		  
		  for (WebElement option : values) {
			  
			  if (option.getText().equalsIgnoreCase(fullLocality)) {
				  option.click();
				  break;
				
			  }}

		
	}
	
	@FindBy(id=GrievanceHomePageConstants.LANDMARK)
	private WebElement Landmark;

	public void sendLandmark(String landmark) {
		
		sendKeysToTextBox(this.Landmark, landmark);
		
	}
	
	@FindBy(id=GrievanceHomePageConstants.MOBNUM)
	private WebElement sendMobNum;
	
public void sendMobNum(String sendMobNum) {
		
		sendKeysToTextBox(this.sendMobNum, sendMobNum);
		
	}
	
	
	@FindBy(id=GrievanceHomePageConstants.CATEGORY)
	private WebElement Category;

	public void selectCategory(String categoryText) {
		//WaitUtil.waitForEelementToBeSelected(Category);
		
	select_Option_In_DropDown_ByVisibleText(this.Category, categoryText);
		sendKeysToTextBox(Category, categoryText);
	}
	
	@FindBy(id=GrievanceHomePageConstants.SUBCATEGORY)
	private WebElement SubCategory;

	public void selectSubCategory(String subCategoryText) throws Exception {
		//WaitUtil.waitForEelementToBeSelected(SubCategory);
		Thread.sleep(3000);
		//select_Option_In_DropDown_ByVisibleText(this.SubCategory, subCategoryText);
		sendKeysToTextBox(this.SubCategory, subCategoryText);
		
		
	}
	
	@FindBy(id=GrievanceHomePageConstants.GRIEVANCEDESCRIPTION)
	private WebElement GrievanceDescription;

	public void sendGrievanceDescription(String grievanceDescription) {
		
		sendKeysToTextBox(this.GrievanceDescription, grievanceDescription);
		
	}
	public boolean iscitizenAppSubmittedSuccessfully() throws Exception
	{
		APP_LOGS.info("waiting for success alert");
		try {
			//return AssertionsUtil.verifyalertmessage(alertSuccesstext);
			return AssertionsUtil.verifyisAlertPresent();
		} catch (NoSuchElementException e) {
			
			return false;
		}

	}
	
	public void waitForAlert(WebDriver driver) throws InterruptedException
	{
	   int i=0;
	   while(i++<5)
	   {
	        try
	        {
	            Alert alert = driver.switchTo().alert();
	            break;
	        }
	        catch(NoAlertPresentException e)
	        {
	          Thread.sleep(1000);
	          continue;
	        }
	   }
	}
	
	
	
	@FindBy(id=GrievanceHomePageConstants.SUBMIT)
	private WebElement Submit;

	public void clickSubmit() throws Exception  {
		
		clickOnButton(this.Submit);
	
		waitForAlert(driver);
		}
	
	
	public static String[] getAppNumber(String str )
	{
	
			
			String[] parts = str.split("\\(");
			String part1 = parts[0]; // Apple
			String part2 = parts[1];// 18);

			String[] citizenAppnum=part2.split("\\)");
			
			
			return citizenAppnum;
			
		}
	}
	
	
	

