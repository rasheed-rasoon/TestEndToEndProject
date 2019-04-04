package com.cgg.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.Constant;
import com.cgg.testcases.TestBase;
import com.cgg.util.FunctionUtil;

public class TransferOfLicenceReplyToQuerPage extends TestBase{
	private WebDriver driver;
	private String getConfMessageFIllReplyToQuery="";
	public TransferOfLicenceReplyToQuerPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="input[value='add']")
	private WebElement ClickOnAddCell;
	
	@FindBy(xpath=".//*[@id='1_docType']")
	private WebElement EnterDocumentType;
	
	@FindBy(xpath=".//*[@id='1_file']")
	private WebElement BrowerDocument;
	
	@FindBy(css="input[onclick*=del]")
	private WebElement ClickOnDelCell;
	
	@FindBy(xpath=".//*[@id='declaration']")
	private WebElement ClickOnDeclaration;
	
	@FindBy(css="textarea#remarks_user")
	private WebElement EnterRemarks; //#declaration
	
	
	
	@FindBy(css=".btn.btn-sm.btn-success")
	private WebElement ClickOnSubmitApplication; 
	
	public HomePage fillReplyToQuerForm(String enterDocumentType,String enterRemarks)
	{
		this.ClickOnAddCell.click();
		FunctionUtil.acceptAlertIfAvailable();
		this.EnterDocumentType.sendKeys(enterDocumentType);
		this.BrowerDocument.sendKeys(Constant.UPLOAD_FILE_PATH);
		this.EnterRemarks.sendKeys(enterRemarks);
	this.ClickOnDeclaration.click();
		this.ClickOnSubmitApplication.click();
		FunctionUtil.acceptAlertIfAvailable();
		
		return PageFactory.initElements(driver,HomePage.class);
		
	}
	@FindBy(xpath=".//*[@id='ann1Tab']/form/div[2]/font")
	private WebElement getConfirmationMessageAfterFillReplyToQuery;
		
	public String getConfirmationMessageForReplyToQuery()
	{
		 getConfMessageFIllReplyToQuery=this.getConfirmationMessageAfterFillReplyToQuery.getText();
		return getConfMessageFIllReplyToQuery;
	}
}
