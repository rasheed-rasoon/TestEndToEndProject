package com.cgg.util;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

import com.cgg.testcases.TestBase;




public class WindowUtil extends TestBase{
	
	
	
	//To get the main window 
	public static String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	//To get the current window title
	public static String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To wait for the new window to be present and switch to it.
	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
        
		String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        //Wait for 20 seconds for the new window and throw exception if not found
        for (int i = 0; i < 20; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                    	newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            } else {
                Thread.sleep(1000);
            }
        }
        if (cHandle == newWindowHandle) {
            throw new RuntimeException(
                    " No windows found");
        }
    }

	
	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(WebDriver driver, String openWindowHandle) throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				Thread.sleep(1000);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
	
	
	
	public static void switchToFrame(String frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with name " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with name " + frame
					+ e.getStackTrace());
		}
	}
	
	public static void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	public static void switchtoDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out.println("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
	
	
	public void switchToIframe() {
		driver.switchTo().frame(
				WaitUtil.waitForAndReturnElement(By
						.cssSelector("[class=\"bd-iframeContainer\"]")));
		APP_LOGS.info("Switched to iframe");
	}

	public void switchToPreviewFrame() {
		driver.switchTo().frame(
				WaitUtil.waitForAndReturnElement(By
						.cssSelector("iframe#bd-preview-frame")));
		APP_LOGS.info("Switched to preview frame ");
	}

}
