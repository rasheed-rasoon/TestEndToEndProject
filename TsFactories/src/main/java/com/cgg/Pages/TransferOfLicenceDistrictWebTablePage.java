package com.cgg.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;

public class TransferOfLicenceDistrictWebTablePage extends TestBase {
private WebDriver driver;
private int distTableRowSizeTotal=0;
	public TransferOfLicenceDistrictWebTablePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[12]/td[4]/a")
	private WebElement ClickOnTransferPrescrutinyPendingTotal;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[12]/td[5]/a")
	private WebElement ClickOnTransferAwaitingQueryResponse;
	
	@FindBy(xpath=".//*[@id='detailsTable']/tbody/tr[12]/td[6]/a")
	private WebElement ClickOnTransferApprovalUnderProcessTOtal;
	
	@FindBy(xpath=".//*[@id='detailsTable']")//
	private WebElement TransferDistrictWebTablexpath;
	public TrnasferOfLicenceWebTableProcessPage clickOnTransferPrescrutinyPendingTotal()
	{
		List<WebElement> rows=TransferDistrictWebTablexpath.findElements(By.tagName("tr"));
		distTableRowSizeTotal=rows.size()-2;
		APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
		driver.findElement(By.xpath(".//*[@id='detailsTable']/tbody/tr["+distTableRowSizeTotal+"]/td[4]/a")).click();
		return PageFactory.initElements(driver,TrnasferOfLicenceWebTableProcessPage.class);
	}
	public TrnasferOfLicenceWebTableProcessPage ClickApprovalUnderProcessTotal()
	{
		List<WebElement> rows=TransferDistrictWebTablexpath.findElements(By.tagName("tr"));
		distTableRowSizeTotal=rows.size()-2;
		APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
		driver.findElement(By.xpath(".//*[@id='detailsTable']/tbody/tr["+distTableRowSizeTotal+"]/td[6]/a")).click();
		return PageFactory.initElements(driver,TrnasferOfLicenceWebTableProcessPage.class);
	}
	public boolean isTransferOfLicenceDistrictWebTablePage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.ClickOnTransferPrescrutinyPendingTotal);
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}

}
