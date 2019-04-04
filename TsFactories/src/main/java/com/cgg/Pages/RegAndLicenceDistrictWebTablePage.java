package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.WaitUtil;

public class RegAndLicenceDistrictWebTablePage  extends TestBase{
private WebDriver driver;
	
	public RegAndLicenceDistrictWebTablePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[8]/td[4]/a")
	private WebElement ClickOnRegPrescrutinyPendingTotal;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[8]/td[6]/a")
	private WebElement ClickOnRegAwaitingQueryResponse;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[8]/td[7]/a")
	private WebElement ClickOnRegApprovalUnderProcessTOtal;
	
	public RegAndLicenceWebTableProcessPage clickOnRegPrescrutinyPendingTotal()
	{
		this.ClickOnRegPrescrutinyPendingTotal.click();
		APP_LOGS.info("clicked on prescrutiny pending total ");
		return PageFactory.initElements(driver,RegAndLicenceWebTableProcessPage.class);
	}
	public RegAndLicenceWebTableProcessPage ClickApprovalUnderProcessTotal()
	
	{
		this.ClickOnRegApprovalUnderProcessTOtal.click();
		APP_LOGS.info("clicked on Approval under process total ");
		return PageFactory.initElements(driver,RegAndLicenceWebTableProcessPage.class);
	}
	
	public boolean isRegAndLicenceDistrictWebTablePage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.ClickOnRegPrescrutinyPendingTotal);
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	
}
