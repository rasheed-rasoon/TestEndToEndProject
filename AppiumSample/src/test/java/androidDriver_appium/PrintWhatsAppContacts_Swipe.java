package androidDriver_appium;
 
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintWhatsAppContacts_Swipe {
	public DesiredCapabilities dc;
	public AndroidDriver<WebElement> driver;
  @Test
  public void f() throws Exception {
driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);  // appium server url --> appium server --> settings
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.whatsapp:id/menuitem_search\")").click();  // slash addes fron and back
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//com.whatsapp:id/tab	 
driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.whatsapp:id/tab\")").sendKeys("Dheedi");

  }
  @BeforeTest
  public void beforeTest() {
	  dc=new DesiredCapabilities();
	  dc.setCapability("deviceName", "99b59294"); //type ADB devises  and get the device number 
	  dc.setCapability("platformVersion", "6.0.1");
	  dc.setCapability("platformName", "Android");	  
	  dc.setCapability("appPackage", "com.whatsapp");   //cmd --> current focus
	  dc.setCapability("appActivity", "com.whatsapp.HomeActivity"); 	    }
 //Run on my one plus one device
  //note : not working on android 7
}
