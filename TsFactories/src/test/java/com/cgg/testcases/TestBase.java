package com.cgg.testcases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.cgg.constants.Constant;
import com.cgg.util.ExtentManager;
import com.cgg.util.WaitUtil;
import com.cgg.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public ExtentReports report=ExtentManager.getInstance();
	public static  ExtentTest test;
	public static Logger APP_LOGS = null;
	public static Properties CONFIG = null;
	public static boolean isInitalized=false;
	public static WebDriver driver = null;
	public static EventFiringWebDriver dr = null;
	public static boolean isLoggedIn = false;
	public static boolean isAlertPresent = false;
	public static int IMPLICIT_WAIT_TIMEOUT=30;

	Xls_Reader xls = new Xls_Reader(Constant.XLS_FILE_PATH);


	// initializing the Tests
	public void initialize() throws Exception {
		// logs
		
		if(!isInitalized){
			APP_LOGS = Logger.getLogger("devpinoyLogger");
			PropertyConfigurator.configure("Log4j.properties");
			// config
			APP_LOGS.info("Loading Property files");
			CONFIG = new Properties();
			FileInputStream ip = new FileInputStream(Constant.CONFIG_FILE_PATH);
			CONFIG.load(ip);

			//APP_LOGS.info("Loaded Property files successfully");
			isInitalized=true;
		}
	}

	// selenium RC/ Webdriver
	// open a browser if its not opened
	public void openBrowser(){
		if(driver==null){
			if(CONFIG.getProperty("browserType").equalsIgnoreCase("FIREFOX"))
				FirefoxDriver();
			else if (CONFIG.getProperty("browserType").equalsIgnoreCase("IE"))
				driver = new InternetExplorerDriver();
			else if (CONFIG.getProperty("browserType").equalsIgnoreCase("CHROME"))
				ChromeDriver();

			//APP_LOGS.info("Browser Opened  -- "+getBrowserName()+" -- With Version -- "+getBrowserVersion());
			//
			driver.manage().window().maximize();
			String waitTime=CONFIG.getProperty("default_implicitWait");
			driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime), TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

		}
	} 
	
	
	

	@BeforeSuite
	public void beforetest() throws Exception{
		initialize();
		openBrowser();

	}
	
	@AfterMethod
	public void Aftertest() {
		flushReports();

	}



	@AfterSuite
	public void closeBrowser(){
		APP_LOGS.info("Closing Browser");
		//driver.close();
		driver=null;
	}


	public static void browseDocument(WebElement element,String browseDocument ) {
		APP_LOGS.info("Browse document");
		try {
			WaitUtil.waitForElementVisible(element);
			
			element.sendKeys(browseDocument);
			
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}
	
public static void sendKeysToTextBox(WebElement element,String enterText)
{
	APP_LOGS.info("Enter text");
	try {
		WaitUtil.waitForElementVisible(element);
		element.sendKeys(enterText);
		test.log(LogStatus.INFO,"entered  "+enterText+ " in the text field "+element.getText());
		
		
	} catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "
				+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element " + element + " was not found in DOM "
				+ e.getStackTrace());
	} catch (Exception e) {
		System.out.println("Element " + element + " was not clickable "
				+ e.getStackTrace());
	}	

}
public static void clickOnButton(WebElement element)
{

	APP_LOGS.info("Enter text");
	try {
		WaitUtil.waitForElementVisible(element);
		element.click();
		test.log(LogStatus.INFO,"CLicked the button "+element.getText());
		
	} catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "
				+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element " + element + " was not found in DOM "
				+ e.getStackTrace());
	} catch (Exception e) {
		System.out.println("Element " + element + " was not clickable "
				+ e.getStackTrace());
	}	
	}
public static void select_Option_In_DropDown_ByVisibleText(WebElement element, String VisibleTextOptionToSelect) {
	try {
		Select select = new Select(element);
		select.selectByVisibleText(VisibleTextOptionToSelect);
		test.log(LogStatus.INFO, "selecting "+VisibleTextOptionToSelect+") From Select List :"+element.getText());
	} catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "
				+ e.getStackTrace());
		APP_LOGS.info("Element is not attached to the page document "
				+ e.getStackTrace());
		
	} catch (NoSuchElementException e) {
		System.out.println("Element " + element + " was not found in DOM "
				+ e.getStackTrace());
		APP_LOGS.info("Element " + element + " was not found in DOM "
				+ e.getStackTrace());
		
		
	} catch (Exception e) {
		System.out.println("Element " + element + " was not clickable "
				+ e.getStackTrace());
		APP_LOGS.info("Element " + element + " was not clickable "
				+ e.getStackTrace());
		
	}
}

//Select DroDown ByValue(element,value)
public static void select_Option_In_DropDown_ByValue(WebElement element, String ValueTextToSelect) {
	APP_LOGS.info("Selecting :("+ValueTextToSelect+") From Select List :"+element.getAttribute("id"));
	try {
		Select select = new Select(element);
		select.selectByValue(ValueTextToSelect);
		test.log(LogStatus.INFO, "Selected "+ValueTextToSelect+" from the dropdown "+element.getAttribute("id")+"");

	} catch (NoSuchElementException e) {
		//System.out.println("Given option:("+ValueTextToSelect+") Not Found from Select List :"+element);
		APP_LOGS.info("Given option:("+ValueTextToSelect+") Not Found from Select List :"+element.getAttribute("id"));
		
	}
}


//Select DroDown By index(element,value)
public static void select_Option_In_DropDown_ByindexValue(WebElement element, int indexVal) {
	APP_LOGS.info("Selecting :("+indexVal+") From Select List :"+element.getAttribute("id"));
	test.log(LogStatus.INFO, "Selecting :("+indexVal+") From Select List :"+element.getAttribute("id"));
	try {
		Select select = new Select(element);
		select.selectByIndex(indexVal);
	} catch (NoSuchElementException e) {
		APP_LOGS.info("Given option:("+indexVal+") Not Found from Select List :"+element.getAttribute("id"));
		System.err.println("Given option:("+indexVal+") Not Found from Select List :"+element.getAttribute("id"));
	}
}



	/*public TopMenu getTopMenu(){
		if(topMenu==null){
			topMenu = PageFactory.initElements(driver, TopMenu.class);
		}
		return topMenu;
	}


	public BottomMenu getBottomMenu(){
		if(bottomMenu==null){
			bottomMenu = PageFactory.initElements(driver, BottomMenu.class);
		}
		return bottomMenu;
	}
	 */

	public static String GetTimeStampValue(){          
		Calendar cal = Calendar.getInstance();
		Date time=cal.getTime();
		String timestamp=time.toString();
		System.out.println(timestamp);
		String systime=timestamp.replace(":", "-");
		System.out.println(systime);
		return systime;
	} 


	public static void capturescreenshot(String filename){
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+"-"+GetTimeStampValue()+".jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//	public static void takescreenshotfor(String filename) throws IOException{
	//		WebDriver augmentedDriver = new Augmenter().augment(driver);
	//		File scrFile = ((TakesScreenshot)augmentedDriver).
	//				getScreenshotAs(OutputType.FILE);
	//		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".jpg"));
	//	}
	//

	public static void createScreenshotUsingRobot(String filename) throws IOException {

		/*BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException | AWTException e1) {
			e1.printStackTrace();
		}
		try {
			ImageIO.write(image, "JPG", new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+"-"+GetTimeStampValue()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		// capture the whole screen
		try{
			BufferedImage screencapture = new Robot().createScreenCapture(
					new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );

			// Save as JPEG
			File file = new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+"-"+GetTimeStampValue()+".jpg");
			ImageIO.write(screencapture, "jpg", file);
		} catch (HeadlessException e) { // | AWTException | IOException
			e.printStackTrace();
		}
		catch(AWTException t)
		{

		}
	}


	public void FirefoxDriver(){

//		ProfilesIni allProfiles = new ProfilesIni();
//		FirefoxProfile profile = allProfiles.getProfile("selenium");
//
//		profile.setPreference("browser.download.folderList",2);
//		profile.setPreference("browser.download.manager.showWhenStarting",false);
//		profile.setPreference("browser.download.dir","D:\\Selenium");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","msi"); 
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-zip;application/x-zip-compressed;application/zip");
//		profile.setPreference("security.mixed_content.block_active_content",false);
//		profile.setPreference("security.mixed_content.block_display_content",true);
//		profile.setPreference("extensions.blocklist.enabled", false);
//		profile.setPreference("plugin.default.state", 2);
        //System.setProperty("webdriver.gecko.driver", "D:\\stdy\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",CONFIG.getProperty("GeckoDriver"));
		driver = new FirefoxDriver();
		//driver = new FirefoxDriver(profile);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void ChromeDriver(){  

		System.setProperty("webdriver.chrome.driver",CONFIG.getProperty("ChromeDriverPath"));
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 1);
		prefs.put("download.default_directory", "C:\\Selenium");
		prefs.put("download.prompt_for_download",false);
		prefs.put("download.extensions_to_open", "msi");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--always-authorize-plugins=false");
		options.addArguments("--start-maximized");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

	}

	

	public String getBrowserName() {
		// Capabilities capabilities = ((RemoteWebDriver)
		// ((Browser)this.browser).getWebDriver() ).getCapabilities();
		Capabilities capabilities = ((RemoteWebDriver)driver)
				.getCapabilities();
		return capabilities.getBrowserName();
	}


	public String getBrowserVersion() {
		Capabilities capabilities = ((RemoteWebDriver)driver)
				.getCapabilities();
		return capabilities.getVersion();
	}


	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
		.setContents(stringSelection, null);
	}
	public static void moveMouseToElement(WebElement element) {
		APP_LOGS.info("Mouse Hover(Move) to the element");
		
		WaitUtil.waitForElementVisible(element);
		try {
			Actions action = new Actions(driver).moveToElement(element);
			action.build().perform();
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public void robotuploadfile(String filepathlocation) {
		//APP_LOGS.info("Uploading File Using RobotClass");
		setClipboardData(filepathlocation);
		try {
			Robot robot = new Robot();
			robot.delay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			//APP_LOGS.info("Unable To Upload File Using RobotClass");
			e.printStackTrace();
		}

	}
	public void takeScreenshot(){
		Date d = new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		String path=Constant.SCREENSHOT_PATH+screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
		//add screenshot to report
		test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
				test.addScreenCapture(path));
	}
	
	public void flushReports()
	{
		if(report!=null){
			report.endTest(test);
			report.flush();
		}
	}
	
	public void reportpass(String passMsg)
	{
		test.log(LogStatus.PASS,passMsg);

	}
	public void reportFail(String failMsg)
	{
		takeScreenshot();
		test.log(LogStatus.FAIL,failMsg);
		Assert.fail(failMsg);

	}
}
