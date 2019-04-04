package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.AmendmentOfLicenceReplyTOQueryPageConstatns;
import com.cgg.constants.Constant;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;

public class AmendmentOfLicenceReplyToQueryPage extends TestBase {
	private WebDriver driver;
	private String getConfMessageFIllReplyToQuery="";
	public AmendmentOfLicenceReplyToQueryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = AmendmentOfLicenceReplyTOQueryPageConstatns.CLICKONADDCELL)
	private WebElement ClickOnAddCell;

	@FindBy(xpath = AmendmentOfLicenceReplyTOQueryPageConstatns.ENTERDOCUMENTTYPE)
	private WebElement EnterDocumentType;

	@FindBy(xpath = AmendmentOfLicenceReplyTOQueryPageConstatns.BROWSEDOCUMENT)
	private WebElement BrowerDocument;

	@FindBy(css = AmendmentOfLicenceReplyTOQueryPageConstatns.CLICKONDELCELL)
	private WebElement ClickOnDelCell;

	@FindBy(css = AmendmentOfLicenceReplyTOQueryPageConstatns.ENTERREMARKS)
	private WebElement EnterRemarks; // #declaration

	@FindBy(css = AmendmentOfLicenceReplyTOQueryPageConstatns.CLICKONDECLARATION)
	private WebElement ClickOnDeclaration;

	@FindBy(css = AmendmentOfLicenceReplyTOQueryPageConstatns.CLICKONSUBMITAPPLICATION)
	private WebElement ClickOnSubmitApplication;

	public HomePage fillReplyToQuerForm(String enterDocumentType, String enterRemarks) {
		APP_LOGS.info("going to click add cell");
		this.ClickOnAddCell.click();
		FunctionUtil.acceptAlertIfAvailable();
		APP_LOGS.info("going to enter documenty type");
		this.EnterDocumentType.sendKeys(enterDocumentType);
		APP_LOGS.info("going to browse browse document");
		this.BrowerDocument.sendKeys(Constant.UPLOAD_FILE_PATH);
		APP_LOGS.info("going to enter Remarks");
		this.EnterRemarks.sendKeys(enterRemarks);
		APP_LOGS.info("going to click on declaration");
		this.ClickOnDeclaration.click();
		APP_LOGS.info("going to click on Submit button");
		this.ClickOnSubmitApplication.click();
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public boolean isAmendmentOfLicenceReplyToQueryPageOpened() {
		try {
			APP_LOGS.info("going to check whether Reply to query page opened or not  ");
			return AssertionsUtil.isElementPresent(this.ClickOnSubmitApplication);
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	@FindBy(xpath=".//*[@id='ann1Tab']/form/div[2]/font")
	private WebElement getConfirmationMessageAfterFillReplyToQuery;
		
	public String getConfirmationMessageForReplyToQuery()
	{
		 getConfMessageFIllReplyToQuery=this.getConfirmationMessageAfterFillReplyToQuery.getText();
		return getConfMessageFIllReplyToQuery;
	}
}
