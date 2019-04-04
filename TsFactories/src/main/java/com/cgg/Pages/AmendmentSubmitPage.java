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

public class AmendmentSubmitPage extends TestBase{
	private WebDriver driver;
	public AmendmentSubmitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		
	}
	
	@FindBy(xpath=".//*[@id='form1Form']/tbody/tr[19]/td/button[2]")
	private WebElement ClickOnSubmitAmendment;
	
	@FindBy(xpath=".//*[@id='declaration']")
	private WebElement ClickOnDeclarationAmendment;
	
	@FindBy(xpath=".//*[@id='paymentTab']/form/table/tbody/tr[6]/td/button")
	private WebElement AmendmentPaymentButton;

    	public boolean isAmendmentPaymentPageOpened() 
    	{
    		try {
    			return AssertionsUtil.isElementPresent(this.AmendmentPaymentButton);
    		} catch (NoSuchElementException e) {
    			return false;
    		}
        }
    	public void clickOnDeclarationAmendment()
    	{
    		clickOnButton(this.ClickOnDeclarationAmendment);
    		//this.ClickOnDeclarationAmendment.click();
  
    		
    	}
    	
    	public boolean clickOnSubmitAmendment()
    	{
    	this.ClickOnSubmitAmendment.click();     // click on submit  then application will be displayed an alert
    	FunctionUtil.acceptAlertIfAvailable(); 
WaitUtil.waitForElementClickable(this.AmendmentPaymentButton);
    	    // again click on submit to submit the application 
    	return AssertionsUtil.isElementPresent(this.AmendmentPaymentButton);
    	
    	}
    	
    	
    	public boolean isAmendmentSubmitPageOpened()
    	{
    		try 
    		{
    			return AssertionsUtil.isElementPresent(this.ClickOnSubmitAmendment);
    		} catch (NoSuchElementException e) 
    		{
    			return false;
    		}
    	}	
    	
    	

    	@FindBy(xpath = "//*[@id='form1Form']/tbody/tr[18]/td/b")
    	private WebElement chekbox;


    	public String getcheckboxtext(){
    		String text = chekbox.getText();
    		APP_LOGS.info("checkbox text is"+text);
    		return text;
    	}
    	
    	
    	
}
