package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class TrnasferOfLicenceWebTableProcessPage extends TestBase {
	private WebDriver driver;
	public TrnasferOfLicenceWebTableProcessPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="input[type='search']")
	private WebElement SendApplicationNumber;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr/td[9]/button")
	private WebElement ClickOnProcess;//
	
	@FindBy(xpath=".//*[@id='status']")
	private WebElement SelectStatus;
	
	@FindBy(css="textarea#remarks")
	private WebElement SendOfficerRemarks; //input[value='Update']
	
	@FindBy(css="input[value='Update']")
	private WebElement clickOnUpdate;
	public void sendApplicationNumber(String sendApplicationNumber)
	{
		this.SendApplicationNumber.sendKeys(sendApplicationNumber);
		APP_LOGS.info("entered application number ");
	}
	public void clickOnProcess()
	{
		APP_LOGS.info("going to click on process button");
		this.ClickOnProcess.click();
		
	}
	public void selectStatus(String selectStatus)
	{
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.SelectStatus, selectStatus);
		
	}

	public void sendOfficerRemarks(String sendOfficerRemarks)
	{
		APP_LOGS.info("going to click on officer remarks");
		this.SendOfficerRemarks.sendKeys(sendOfficerRemarks);
		
	}
	
	public TrnasferOfLicenceWebTableProcessPage clickOnUpdateButton()
	{
		//WaitUtil.waitForElementClickable(this.clickOnUpdate);
		APP_LOGS.info("Going to click on Update button");
		this.clickOnUpdate.click();
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver, TrnasferOfLicenceWebTableProcessPage.class);
		
	}
	public boolean isTransferOfLicenceFormPageOpened() {
		APP_LOGS.info("Going tocheck whether navigated to transfer of licence page or not");
		try {
			return AssertionsUtil.isElementPresent(this.SendApplicationNumber);
		} catch (NoSuchElementException e) {
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
