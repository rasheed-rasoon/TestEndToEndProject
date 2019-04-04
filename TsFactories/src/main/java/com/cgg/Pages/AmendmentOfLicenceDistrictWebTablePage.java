package com.cgg.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.AmendmentOfLicenceDistrictWebTablePageConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;

public class AmendmentOfLicenceDistrictWebTablePage extends TestBase {
private WebDriver driver;
private int distTableRowSizeTotal=0;	
	public AmendmentOfLicenceDistrictWebTablePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath=AmendmentOfLicenceDistrictWebTablePageConstants.CLICKONPRESCRYTINYPENDINGTOTAL)
	private WebElement ClickOnPrescrutinyPendingTotal;
	
	@FindBy(xpath=AmendmentOfLicenceDistrictWebTablePageConstants.CLICKONAWAITINGQUERYRESPONSE)
	private WebElement ClickOnAwaitingQueryResponse;
	
	@FindBy(xpath=AmendmentOfLicenceDistrictWebTablePageConstants.CLICKONAPPROVALUNDERPROCESSTOTAL)
	private WebElement ClickOnApprovalUnderProcessTOtal;
	
	@FindBy(xpath=".//*[@id='detailsTable']")//
	private WebElement AmendmentDistrictWebTablexpath;	
	
	public AmendmentAndLicenceWebTableProcessPage ClickOnPrescrutinyPendingTotal()
	{
		driver.navigate().to("http://test.cgg.gov.in:8083/tsfactories/dbAmendmentOfLicense.do");
		List<WebElement> rows=AmendmentDistrictWebTablexpath.findElements(By.tagName("tr"));
	distTableRowSizeTotal=rows.size()-2;
	System.out.println("row total is"+	distTableRowSizeTotal);
	APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
	driver.findElement(By.xpath(".//*[@id='detailsTable']/tbody/tr["+distTableRowSizeTotal+"]/td[4]/a")).click();
		return PageFactory.initElements(driver,AmendmentAndLicenceWebTableProcessPage.class);
	}
	public AmendmentAndLicenceWebTableProcessPage ClickApprovalUnderProcessTotal()
	{
		List<WebElement> rows=AmendmentDistrictWebTablexpath.findElements(By.tagName("tr"));
		distTableRowSizeTotal=rows.size()-2;
		APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
		driver.findElement(By.xpath(".//*[@id='detailsTable']/tbody/tr["+distTableRowSizeTotal+"]/td[6]/a")).click();
		return PageFactory.initElements(driver,AmendmentAndLicenceWebTableProcessPage.class);
	}
	
	public void clickOnAwaitingQueryResponse()
	{
			this.ClickOnAwaitingQueryResponse.getText();
		this.ClickOnAwaitingQueryResponse.click();
		APP_LOGS.info("clicked on prescrutiny total "+this.ClickOnAwaitingQueryResponse.getText());
		
	}
	public boolean isAmendmentOfLicenceDistrictWebTablePage()
	{
		try 
		{
			return AssertionsUtil.isElementPresent(this.ClickOnPrescrutinyPendingTotal);
		} catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	

}
