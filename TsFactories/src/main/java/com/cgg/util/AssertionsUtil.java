package com.cgg.util;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cgg.testcases.TestBase;





public class AssertionsUtil extends TestBase {


	//----------Compare Titles----------//
	public static boolean verifytitle(String ExpectedTitle){
		APP_LOGS.info("----------||Verifying Title||----------");
		String ActualTitle=driver.getTitle();
		try{
			Assert.assertTrue(ActualTitle.equalsIgnoreCase(ExpectedTitle));
		}catch(Throwable t){
			ErrorUtil.addVerificationFailure(t);			
			APP_LOGS.info("Actual Title :-("+ActualTitle+")"+" Not Matching With Expected Title :-("+ExpectedTitle+") (-Failed-)");
			return false;
		}
		//APP_LOGS.info("Actual Title :-("+ActualTitle+")"+" Matched With Expected Title :-("+ExpectedTitle+") (-Passed-)");
		return true;
	}



	public static boolean verifytext(WebElement element, String data) {
		APP_LOGS.info("----------||Verifying Text||----------");
		String Actual=element.getText();
		String Expected=data;
		try {
			Assert.assertTrue(Actual.contains(Expected));
		} catch (Throwable t) {
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Actual Text :-("+Actual+")"+" Not Matching With Expected Text :-("+Expected+") (-Failed-)");
			return false;
		}
		return true;
	}
	
	
	public static boolean verifytext(String Actualdata, String Expecteddata) {
		APP_LOGS.info("----------||Verifying Text||----------");
		try {
			Assert.assertTrue(Actualdata.contains(Expecteddata));
		} catch (Throwable t) {
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Actual Text :-("+Actualdata+")"+" Not Matching With Expected Text :-("+Expecteddata+") (-Failed-)");
			return false;
		}
		return true;
	}



  	//----------Check Weather Alert Message Matching With Expected----------//
	public static boolean verifyalertmessage(String data){
		APP_LOGS.info("Verifying the Alert Message");
		Alert alert = driver.switchTo().alert();//Switch to Pop window from main window

		String Actual=alert.getText();
		String Expected=data;

		try {
			Actual.equalsIgnoreCase(data);
			alert.accept();
		} catch (Throwable t) {
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Actual Alert Message :-("+Actual+")"+" Not Matching With Expected Alert Message :-("+Expected+") (-Failed-)");
			alert.accept();
			//System.err.println("Actual Alert Message :-("+Actual+")"+" Not Matching With Expected  Alert Message :-("+Expected+") (-Failed-)");
			return false;
		}
		APP_LOGS.info("Actual Alert Message :-("+Actual+")"+" Matched With Expected Alert Message :-("+Expected+") (-Passed-)");
		return true;
	}


	public static boolean verifyisAlertPresent() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,2);
		boolean AlertStatus=false;
		APP_LOGS.info("Verifying Presence of Alert");
		try {
			Alert alert=driver.switchTo().alert();//Switch to Pop window from main window
			//wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			AlertStatus=true;
			APP_LOGS.info("Alert Present and Message Is -- "+alert.getText());
			//alert.accept();
		} catch (NoAlertPresentException e) {
			//createScreenshotUsingRobot("NoAlert");
			APP_LOGS.info("No Alert Present");
		}
		return AlertStatus;
	}

	

	public static boolean verifyDropdownValues(WebElement element,String[] strValues){
		try{
			//APP_LOGS.info("Verifying_Values_In_("+element.getAttribute("id")+")"); 
			List<WebElement> options=element.findElements(By.tagName("option"));
			WaitUtil.waitForElementVisible(options);
			Assert.assertTrue(FunctionUtil.verify_Values_In_Dropdown(options,strValues),"Values_In_("+element.getLocation()+") Doesn't Match-");
		}catch(Throwable t){
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Values_In_("+element.getAttribute("id")+")Doesn't Match- (-Failed-)");
			return false;
		}
		return true;
	}



	public static boolean isElementPresent(WebElement element) {
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				return true;
			APP_LOGS.info("--- Element Present ---"+element.getText());
		} catch (NoSuchElementException e) {
			APP_LOGS.info("--- No Such Element Present ---"+element.getText());
			return false;
		} catch (StaleElementReferenceException e) {
			
			return false;
		}
		return true;
		
	}
	

}
