package com.cgg.util;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cgg.testcases.TestBase;




public class WaitUtil extends TestBase {
	
	public static WebElement waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}
	
	public static void waitForElementVisible(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
	
	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForEelementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public static void waitForPagetoload(String title) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.titleContains(title));
	}
	

	public static void waitForElementVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static WebElement waitForAndReturnElement(By by) {
		waitForElementVisible(by);
		return driver.findElement(by);
		
	}
	
	public static WebElement waitForAndReturnElement(WebElement element) {
		waitForElementVisible(element);
		return (element);
		
	}
	
	public static void waitForElementSelected(By by) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.elementSelectionStateToBe(by, true));
	}

}
