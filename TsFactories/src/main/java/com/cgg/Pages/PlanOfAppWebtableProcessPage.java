package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class PlanOfAppWebtableProcessPage extends TestBase{
private  WebDriver driver;
private String getConfMessageQuery="";	
private String getConfMessagescrutiny="";
private String getConfMessageRejection="";
	public PlanOfAppWebtableProcessPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="input[type='search']")
	private WebElement SendApplicationNumber;
	
	@FindBy(xpath=".//*[@id='dynamic-table']/tbody/tr/td[8]/abbr/button")
	private WebElement ClickOnProcess;//
	
	@FindBy(xpath=".//*[@id='status']")
	private WebElement SelectStatus;
	
	@FindBy(css="textarea#remarks")
	private WebElement SendOfficerRemarks; //input[value='Update']
	
	@FindBy(css="input[value='Update']")
	private WebElement clickOnUpdate;
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/font")
	private WebElement SuccesmessageForQuery;
	
	@FindBy(xpath=".//*[@id='RejReason']")
	private WebElement ReasonForRejection;
	
	
	public void sendApplicationNumber(String sendApplicationNumber)
	{
		APP_LOGS.info("Going to enter application number in serch box");
		this.SendApplicationNumber.sendKeys(sendApplicationNumber);
		APP_LOGS.info("entered application number ");
	}
	public void ClickOnProcess()
	{
		APP_LOGS.info("going to click on Process button");
		this.ClickOnProcess.click();
	}
	public void selectStatus(String selectStatus)
	{
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.SelectStatus, selectStatus);
	}
	public void reasonFOrRejection(String selectStatus)
	{
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.ReasonForRejection, selectStatus);
		
	}
	public void sendOfficerRemarks(String sendOfficerRemarks)
	{
		APP_LOGS.info("going to enter officer remarks");
		this.SendOfficerRemarks.sendKeys(sendOfficerRemarks);
	}
	
	public PlanOfAppWebtableProcessPage clickOnUpdateButton()
	{
		APP_LOGS.info("going to click on update button");
       this.clickOnUpdate.click();
       AssertionsUtil.isElementPresent(this.SuccesmessageForQuery);
		return PageFactory.initElements(driver, PlanOfAppWebtableProcessPage.class);
		
	}
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/font")
	private WebElement ScrutinyConfirmationMessage;
		
	public String getConfirmationMessageForScrutiny()
	{
		 getConfMessagescrutiny=this.ScrutinyConfirmationMessage.getText();
		return getConfMessagescrutiny;
	}
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/font")
	private WebElement QueryConfirmationMessage;
		
	public String getConfirmationMessageForQuery()
	{
		 getConfMessageQuery=this.QueryConfirmationMessage.getText();
		return getConfMessageQuery;
	}
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/font")
	private WebElement RejectConfirmationMessage;
		
	public String getConfirmationMessageForReject()
	{
		 getConfMessageRejection=this.RejectConfirmationMessage.getText();
		return getConfMessageRejection;
	}
	public boolean isPlanOfAppWebtableProcessPage() {
		APP_LOGS.info("Going tocheck whether navigated to transfer of licence page or not");
		try {
			return AssertionsUtil.isElementPresent(this.SendApplicationNumber);
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	

}
