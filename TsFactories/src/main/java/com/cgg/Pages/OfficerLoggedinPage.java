package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cgg.constants.OfficerLoggedInPageConstant;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
public class OfficerLoggedinPage extends TestBase {
	private WebDriver driver;
	public OfficerLoggedinPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=OfficerLoggedInPageConstant.PLANOFAPPROVAlVIEW)
	private WebElement ClickPlanofApprovalView;
	
	@FindBy(xpath=OfficerLoggedInPageConstant.CLICKREGANDLICENCEVIEW)
	private WebElement ClickRegAndLicenceView;
	
	@FindBy(xpath=OfficerLoggedInPageConstant.CLICKONAMENDMENTVIEW)
	private WebElement ClickAmendmentView;
	
	@FindBy(xpath=OfficerLoggedInPageConstant.CLICKONTRANSFEROFLICENCEVIEW)
	private WebElement ClickTransferViewAmendmentView;
	
	@FindBy(css=OfficerLoggedInPageConstant.DOOFFICERLOGOUT)
	private WebElement DoOfficerLogout; //
	
	public PlanOfAppDistrictWebTablePage clickOnPlanofApprovalView()
	{
	this.ClickPlanofApprovalView.click();	
	APP_LOGS.info("clicked on Plan of approval View");
	return PageFactory.initElements(driver, PlanOfAppDistrictWebTablePage.class);
	}
	
	public RegAndLicenceDistrictWebTablePage clickOnRegAndLicenceView()
	{
	this.ClickRegAndLicenceView.click();	
	APP_LOGS.info("clicked on Registration and Grant Of Licence View View");
	return PageFactory.initElements(driver, RegAndLicenceDistrictWebTablePage.class);
	}
	
	public AmendmentOfLicenceDistrictWebTablePage clickOnAmendmentLicenceView()
	{
	this.ClickAmendmentView.click();	
	APP_LOGS.info("clicked on AmendmentOf Licence View View");
	return PageFactory.initElements(driver, AmendmentOfLicenceDistrictWebTablePage.class);
	}
	
	public TransferOfLicenceDistrictWebTablePage clickOnTransferOfLicencetLicenceView()
	{
	this.ClickTransferViewAmendmentView.click();	
	APP_LOGS.info("clicked on Transfer Of Licence View");
	return PageFactory.initElements(driver, TransferOfLicenceDistrictWebTablePage.class);
	}
	
	public HomePage officerLogout()
	{
		this.DoOfficerLogout.click();
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	public boolean isOfficerLoggedinPage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.DoOfficerLogout);
		} catch (NoSuchElementException e) {
			return false;
		}
	
	}
}
