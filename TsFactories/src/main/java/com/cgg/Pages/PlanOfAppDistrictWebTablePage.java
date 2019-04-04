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

public class PlanOfAppDistrictWebTablePage extends TestBase{

private WebDriver driver;
	private int distTableRowSizeTotal=0;
	public PlanOfAppDistrictWebTablePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath=".//*[@id='dynamic-table']/tbody/tr[32]/td[4]/a")
	private WebElement ClickOnPrescrutinyPendingTotal;
	
	@FindBy(xpath=".//*[@id='dynamic-table']/tbody/tr[32]/td[5]/a")
	private WebElement ClickOnAwaitingQueryResponse;
	
	@FindBy(xpath=".//*[@id='dynamic-table']/tbody/tr[32]/td[3]/a")//
	private WebElement ClickOnApprovalUnderProcessTOtal;
	
	@FindBy(xpath=".//*[@id='dynamic-table']")//
	private WebElement PlanOfAppDistrictWebTablexpath;	
	
	public PlanOfAppWebtableProcessPage ClickOnPrescrutinyPendingTotal()
	{
		
		List<WebElement> rows=PlanOfAppDistrictWebTablexpath.findElements(By.tagName("tr"));
		distTableRowSizeTotal=rows.size()-2;
		APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
		driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr["+distTableRowSizeTotal+"]/td[4]/a")).click();

		return PageFactory.initElements(driver,PlanOfAppWebtableProcessPage.class);
	}
	public PlanOfAppWebtableProcessPage ClickApprovalUnderProcessTotal()
	{
		List<WebElement> rows=PlanOfAppDistrictWebTablexpath.findElements(By.tagName("tr"));
		distTableRowSizeTotal=rows.size()-2;
		APP_LOGS.info("size of district webtable is "+distTableRowSizeTotal);
		driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr["+distTableRowSizeTotal+"]/td[6]/a")).click();
		return PageFactory.initElements(driver,PlanOfAppWebtableProcessPage.class);
	}
	
	public void clickOnAwaitingQueryResponse()
	{
			this.ClickOnAwaitingQueryResponse.getText();
		this.ClickOnAwaitingQueryResponse.click();
		APP_LOGS.info("clicked on prescrutiny total "+this.ClickOnAwaitingQueryResponse.getText());
		
	}
	public boolean isPlanOfAppDistrictWebTablePage() {
		APP_LOGS.info("Going tocheck whether navigated to transfer of licence page or not");
		try {
			return AssertionsUtil.isElementPresent(this.ClickOnPrescrutinyPendingTotal);
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
