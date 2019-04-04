package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class RegAndLicenceWebTableProcessPage extends TestBase {
	private WebDriver driver;
	public RegAndLicenceWebTableProcessPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="input[type='search']")
	private WebElement SendApplicationNumber;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr/td[12]/button")
	private WebElement ClickOnProcess;//
	
	@FindBy(xpath=".//*[@id='status']")
	private WebElement SelectStatus;
	
	@FindBy(css="textarea#remarks")
	private WebElement SendOfficerRemarks; //input[value='Update']
	
	@FindBy(css="input[value='update']")
	private WebElement clickOnUpdate;
	

		
	public void sendApplicationNumber(String sendApplicationNumber)
	{
		//EntreprenuerDashboard.getApNumEntreprenuerLogin();
		this.SendApplicationNumber.sendKeys(sendApplicationNumber);
		APP_LOGS.info("entered application number ");
	}
	public void ClickOnProcess()
	{
		this.ClickOnProcess.click();
		
	}
	public void selectStatus(String selectStatus)
	{
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.SelectStatus, selectStatus);
		
	}

	public void sendOfficerRemarks(String sendOfficerRemarks)
	{
		this.SendApplicationNumber.sendKeys(sendOfficerRemarks);
		
	}
	
	public RegAndLicenceWebTableProcessPage clickOnUpdateButton()
	{
		//WaitUtil.waitForElementClickable(this.clickOnUpdate);
		this.clickOnUpdate.click();
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver, RegAndLicenceWebTableProcessPage.class);
		
	}
	public boolean isRegAndLicenceWebTableProcessPage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.SendApplicationNumber);
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/table/tbody/tr[1]/td/font")
	private WebElement ScrutinyConfirmationMessage;
		
	public String getConfirmationMessageForScrutiny()
	{
		String getConfMessage=this.ScrutinyConfirmationMessage.getText();
		return getConfMessage;
	}
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/table/tbody/tr[1]/td/font")
	private WebElement QueryConfirmationMessage;
		
	public String getConfirmationMessageForQuery()
	{
		String getConfMessage=this.QueryConfirmationMessage.getText();
		return getConfMessage;
	}
	@FindBy(xpath="html/body/div[1]/div[2]/center/form/table/tbody/tr[1]/td/font")
	private WebElement RejectionConfirmationMessage;
		
	public String getConfirmationMessageForRejection()
	{
		String getConfMessage=this.RejectionConfirmationMessage.getText();
		return getConfMessage;
	}

}
