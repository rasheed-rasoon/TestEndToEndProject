package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.AmendmentOfLicenceStatusPageConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class AmendmentOfLicenceStatusPage extends TestBase {
	private WebDriver driver;
	@FindBy(xpath=AmendmentOfLicenceStatusPageConstants.SELECTSTATUS)
	private WebElement SelectStatus;
	
	@FindBy(css=AmendmentOfLicenceStatusPageConstants.SENDOFFICERREMARKS)
	private WebElement SendOfficerRemarks; //input[value='Update']
	
	@FindBy(css=AmendmentOfLicenceStatusPageConstants.CLICKONUPDATE)
	private WebElement clickOnUpdate;
	public void selectStatus(String selectStatus)
	{
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.SelectStatus, selectStatus);
		
	}

	public void sendOfficerRemarks(String sendOfficerRemarks)
	{
		APP_LOGS.info("Going to enter officer remarks");
		this.SendOfficerRemarks.sendKeys(sendOfficerRemarks);
	}
	
	public AmendmentAndLicenceWebTableProcessPage clickOnUpdateButton()
	{
		APP_LOGS.info("Going to click on update");
		this.clickOnUpdate.click();
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver, AmendmentAndLicenceWebTableProcessPage.class);
		
	}
	public boolean isAmendmentOfLicenceStatusPage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.SelectStatus);
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
