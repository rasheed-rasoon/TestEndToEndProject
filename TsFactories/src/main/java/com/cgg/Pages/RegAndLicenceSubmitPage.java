package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class RegAndLicenceSubmitPage extends TestBase{
	private WebDriver driver;
	public RegAndLicenceSubmitPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@id ='declaration' and @type='checkbox']")
	private WebElement declaration;

	
	@FindBy(xpath=".//*[@id='form1Form']/tbody/tr[21]/td/button[2]")
	private WebElement submitButton;
	
	@FindBy(xpath="html/body/div[1]/div[2]/center/div/div[4]/form/table/tbody/tr[4]/td/button")
	private WebElement ProceedTOPaymentButton;
	
	public boolean isSubmitPageOpened()
	{
		try {
			return AssertionsUtil.isElementPresent(this.submitButton);
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	public boolean isProceedToPaymenyPageOpened() 
	{
		try {
			return AssertionsUtil.isElementPresent(this.ProceedTOPaymentButton);
		} catch (NoSuchElementException e) {
			return false;
		}
		
		
	}
	public void clickOnDeclatration()
	{
		APP_LOGS.info("Going to click on Declaration");
		this.declaration.click();
		
		
	}
	public RegAndLicencePaymentPage clickOnSubmit()
	{ 
		APP_LOGS.info("Going to click on Submit button");
		this.submitButton.click();
		FunctionUtil.acceptAlertIfAvailable();
		 return PageFactory.initElements(driver,RegAndLicencePaymentPage.class);
		
		
	}
	@FindBy(xpath = "//*[@id='form1Form']/tbody/tr[20]/td/b")
	private WebElement chekbox;


	public String getcheckboxtext(){
		String text = chekbox.getText();
		return text;
	}
	public boolean isRegAndLicenceSubmitPage()
	{
		try {
			return AssertionsUtil.isElementPresent(this.submitButton);
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
}
