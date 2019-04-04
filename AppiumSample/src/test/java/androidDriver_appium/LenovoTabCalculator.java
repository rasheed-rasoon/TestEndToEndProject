package androidDriver_appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LenovoTabCalculator {
	public DesiredCapabilities dc;
	public AndroidDriver<WebElement> driver;
  @Test
  public void f() throws Exception {
driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);  // appium server url --> appium server --> settings
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.whatsapp:id/menuitem_search\")").click();  // slash addes fron and back
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//com.whatsapp:id/tab
//driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.whatsapp:id/tab\")").sendKeys("Dheedi");

  }
  @BeforeTest
  public void beforeTest() {
	  dc=new DesiredCapabilities();
	  dc.setCapability("deviceName", "0123456789ABCDEF"); //type ADB devises  and get the device number 
	  dc.setCapability("platformVersion", "5.0.1");
	  dc.setCapability("platformName", "Android");	  
	  dc.setCapability("appPackage", "com.android.calculator2");   //cmd --> current focus
	  dc.setCapability("appActivity", "com.android.calculator2.Calculator"); 	    }
 //Run on my one plus one device
  //note : not working on android 7
}
