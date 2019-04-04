package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.Constant;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class PlanOfAppReplyToQueryFormPage extends TestBase {
	private WebDriver driver;
	public PlanOfAppReplyToQueryFormPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="input[onclick*=add]")
	private WebElement ClickOnAddCell;
	
	@FindBy(xpath=".//*[@id='1_docType']")
	private WebElement EnterDocumentType;
	
	@FindBy(xpath=".//*[@id='1_file']")
	private WebElement BrowerDocument;
	
	@FindBy(css="input[onclick*=del]")
	private WebElement ClickOnDelCell;
	
	
	@FindBy(css="textarea#remarks_user")
	private WebElement EnterRemarks; //#declaration
	
	@FindBy(css="#declaration")
	private WebElement ClickOnDeclarationReplyToQuery; 
	
	@FindBy(css=".btn.btn-sm.btn-success")
	private WebElement ClickOnSubmitApplication; 
	
	public HomePage fillReplyToQuerForm(String enterDocumentType,String enterRemarks) throws Exception
	{
		APP_LOGS.info("Going to click on add cell");
		this.ClickOnAddCell.click();
		AssertionsUtil.verifyisAlertPresent();
		FunctionUtil.acceptAlertIfAvailable();
		APP_LOGS.info("going to enter documenty type");
		AssertionsUtil.isElementPresent(EnterDocumentType);
		AssertionsUtil.isElementPresent(BrowerDocument);
		this.EnterDocumentType.sendKeys(enterDocumentType);
		APP_LOGS.info("going to browse browse document");
		this.BrowerDocument.sendKeys(Constant.UPLOAD_FILE_PATH);
		APP_LOGS.info("going to enter Remarks");
		this.EnterRemarks.sendKeys(enterRemarks);
		APP_LOGS.info("going to click on declaration");
		this.ClickOnDeclarationReplyToQuery.click();
		APP_LOGS.info("going to click on Submit button");
		this.ClickOnSubmitApplication.click();
		AssertionsUtil.verifyisAlertPresent();
		FunctionUtil.acceptAlertIfAvailable();
		
		return PageFactory.initElements(driver,HomePage.class);
		
	}
	public boolean isPlanOfAppReplyToQueryFormPage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.ClickOnSubmitApplication);
		} catch (NoSuchElementException e) {
			return false;
		}	
	}
	@FindBy(xpath=".//*[@id='ann1Tab']/form/div[2]/font/b")
	private WebElement QuerConfirmationMessage;
		
	public String getReplyToQueryConfirmationMessage()
	{
		String getReplyQueryConfMessage=this.QuerConfirmationMessage.getText();
		return getReplyQueryConfMessage;
	}
}
