package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.util.AssertionsUtil;

public class RegAndLicencePaymentPage {
	
	private WebDriver driver;
	public RegAndLicencePaymentPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="html/body/div[1]/div[2]/center/div/div[4]/form/table/tbody/tr[4]/td/button")
	private WebElement PaymentButton;
	
	public boolean isRegAndGrantOfLicencePaymentPageOpened()
	{
		try {
			return AssertionsUtil.isElementPresent(this.PaymentButton);
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
}
