package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cgg.constants.AmendmentAndLicenceWebTableProcessConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;

public class AmendmentAndLicenceWebTableProcessPage extends TestBase {
	private WebDriver driver;
	public AmendmentAndLicenceWebTableProcessPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css=AmendmentAndLicenceWebTableProcessConstants.SENDAPPLICATIONUMBER)
	private WebElement SendApplicationNumber;
	
	@FindBy(xpath=AmendmentAndLicenceWebTableProcessConstants.CLICKONPROCESS)
	private WebElement ClickOnProcess;//
	
	

		
	public void sendApplicationNumber(String sendApplicationNumber)
	{
		//EntreprenuerDashboard.getApNumEntreprenuerLogin();
		this.SendApplicationNumber.sendKeys(sendApplicationNumber);
		APP_LOGS.info("entered application number ");
	}
	public AmendmentOfLicenceStatusPage ClickOnProcess()
	{
		this.ClickOnProcess.click();
		return PageFactory.initElements(driver, AmendmentOfLicenceStatusPage.class);
		
	}
	
	public boolean isAmendmentAndLicenceWebTableProcessPage()
	{
		try 
		{
			return AssertionsUtil.isElementPresent(this.SendApplicationNumber);
		} catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/div[1]/font")
	private WebElement ScrutinyConfirmationMessage;
		
	public String getConfirmationMessageForScrutiny()
	{
		String getConfMessagescrutiny=this.ScrutinyConfirmationMessage.getText();
		return getConfMessagescrutiny;
	}
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/div[1]/font")
	private WebElement QueryConfirmationMessage;
		
	public String getConfirmationMessageForQuery()
	{
		String getConfMessageQuery=this.QueryConfirmationMessage.getText();
		return getConfMessageQuery;
	}
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/div[1]/font")
	private WebElement RejectConfirmationMessage;
		
	public String getConfirmationMessageForReject()
	{
		String getConfMessageRejection=this.RejectConfirmationMessage.getText();
		return getConfMessageRejection;
	}

}
