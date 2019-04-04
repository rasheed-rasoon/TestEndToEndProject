package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class TransferOfLicenceSubmitPage extends TestBase {
	private WebDriver driver;
	public TransferOfLicenceSubmitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath =".//*[@id='declaration']")
	private WebElement ClickOnDeclarationTransferOfLicence;
	
	@FindBy(xpath =".//*[@id='previewForm']/table/tbody/tr[12]/td/button[2]")
	private WebElement ClickOnSubmitTransferOfLicence;
	
	@FindBy(xpath =".//*[@id='ackTab']/table/tbody/tr[1]/td/font")
	private WebElement PaymentTransferOfLicence;
	
	@FindBy(xpath =".//*[@id='ackTab']/table/tbody/tr[1]/td/font")
	private WebElement confirmationMessage;
	
	public void clickOnDeclarationTransferOfLicence() {
		APP_LOGS.info("Going to click on the check box Transfer of Licence Declaration");
		clickOnButton(this.ClickOnDeclarationTransferOfLicence);
	}
	public void clickOnSubmitTransferOfLicence() {
		APP_LOGS.info("Going to click on the Submit button  Transfer of Licence");
		clickOnButton(this.ClickOnSubmitTransferOfLicence);
		FunctionUtil.acceptAlertIfAvailable();
	
	}
	
	public boolean isTransferOfLicenceSubmitPageOpened()
	{
		
		try 
		{
			return AssertionsUtil.isElementPresent(this.ClickOnSubmitTransferOfLicence);
		} catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	public boolean isTransferOfLicencesuccesfulPageOpened()
	{
		
		try 
		{
			return AssertionsUtil.isElementPresent(this.confirmationMessage);
		} catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	@FindBy(xpath = ".//*[@id='previewForm']/table/tbody/tr[11]/td/b")
	private WebElement chekbox;


	public String getcheckboxtext(){
		String text = chekbox.getText();
		APP_LOGS.info("checkbox text is"+text);
		return text;
	}

}
