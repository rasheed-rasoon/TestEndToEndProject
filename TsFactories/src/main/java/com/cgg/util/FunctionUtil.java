package com.cgg.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cgg.testcases.TestBase;


public class FunctionUtil extends TestBase{
	public static String regNum=null;
	public static String amendFreshRegNum=null;
	public static String transferFreshRegNum=null;
	
	public static String getappNumTransferOfLicOffProcess=null;
	public static String getTransferOfLicAllotedOffId=null;
	public static String gettransferOfLicAllotedOffPwd=null;
	public static ArrayList<String> transferOfLicOfficerInput=null;
	
	
	public static String entreprenueruname=null;
	public static String allotedOfficerUname=null;
	//----------Actions Drivers Mouse Move,RighClick,Drag&Drop,DoubleClick,Scroll Start----------//

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
	public   static String getRegistrationNumberUsingDB() 
	{
		try{  
			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
			Class.forName("org.postgresql.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(  
			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select application_id from factories_form2a limit 1");  
			while(rs.next())  {
				regNum=rs.getString(1);
			System.out.println(rs.getString(1));  
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return regNum;  
			} 
	
	public static ArrayList<String> getAppNumForTransferOfLicOfficerProcess()
	{
		try{  
			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
			Class.forName("org.postgresql.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(  
			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
		ResultSet rs1=stmt.executeQuery("select application_id from factories_form2a where status = 'Pre-Scrutiny-Pending' limit 1");  
			while(rs1.next())  {
				getappNumTransferOfLicOffProcess=rs1.getString(1);
			}
				ResultSet rs2=stmt.executeQuery("select assigned_to_officer from factories_form2a where application_id = '"+getappNumTransferOfLicOffProcess+"' limit 1");  
				while(rs2.next())  {
					getTransferOfLicAllotedOffId=rs2.getString(1);
				}
					ResultSet rs3=stmt.executeQuery("select real_password from users_mst where user_id = '"+getTransferOfLicAllotedOffId+"'");  
					while(rs3.next())  {
						gettransferOfLicAllotedOffPwd=rs3.getString(1);			
			//System.out.println(rs.getString(1));  
			}
					ArrayList<String> transferOfLicOfficerInput=new ArrayList<String>();
					transferOfLicOfficerInput.add("getappNumTransferOfLicOffProcess");
					transferOfLicOfficerInput.add("getTransferOfLicAllotedOffId");
					transferOfLicOfficerInput.add("gettransferOfLicAllotedOffPwd");
					
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return transferOfLicOfficerInput;  
				
	}
//	public   static String getAllottedOfficerForGrantOfLicOfficerProcess() 
//	{
//		try{  
//			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
//			
//			Class.forName("org.postgresql.Driver").newInstance();
//			
//			Connection con=DriverManager.getConnection(  
//			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
//			//here sonoo is database name, root is username and password  
//			Statement stmt=con.createStatement();  
//			ResultSet rs=stmt.executeQuery("select assigned_to_officer from factories_form2a where application_id ='"+getappNumGrantOfLicOffProcess+"' limit 1");  
//			while(rs.next())  {
//				granOfLicAllotedOffId=rs.getString(1);
//			System.out.println(rs.getString(1));  
//			}
//			con.close();  
//			}catch(Exception e){ System.out.println(e);}
//		return granOfLicAllotedOffId;  
//			} 
//	
	public   static String getAmendmentFreshRegNumForFormFilling() 
	{
		try{  
			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
			
			Class.forName("org.postgresql.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(  
			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select rno from total_factories where is_amendment is false limit 1");  
			while(rs.next())  {
				amendFreshRegNum=rs.getString(1);
			System.out.println(rs.getString(1));  
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return amendFreshRegNum;  
			}  
	

public   static String getTransferFreshRegNumForFormFilling() 
{
try{  
	//Class.forName("com.postgresql.jdbc.Driver").newInstance();
	
	Class.forName("org.postgresql.Driver").newInstance();
	
	Connection con=DriverManager.getConnection(  
	"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select rno from total_factories where is_transferlicence is false limit 1");  
	while(rs.next())  {
		transferFreshRegNum=rs.getString(1);
	System.out.println(rs.getString(1));  
	}
	con.close();  
	}catch(Exception e){ System.out.println(e);}
return transferFreshRegNum;  
	}  

	public   static String getEntreprenuerUserNameUsingDB() 
	{
		try{  
			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
			
			Class.forName("org.postgresql.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(  
			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select application_id from factories_form2a limit 1");  
			while(rs.next())  {
				entreprenueruname=rs.getString(1);
			System.out.println(rs.getString(1));  
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return regNum;  
			} 
	public   static String getAllottedOfficerUsingDB() 
	{
		try{  
			//Class.forName("com.postgresql.jdbc.Driver").newInstance();
			
			Class.forName("org.postgresql.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(  
			"jdbc:postgresql://10.2.17.139:5432/ts_factories_test","ts_factories","ts_factories");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select application_id from factories_form2a limit 1");  
			while(rs.next())  {
				allotedOfficerUname=rs.getString(1);
			System.out.println(rs.getString(1));  
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return regNum;  
			} 
		//public static String forPlanApproval(Connection con,Statement stmt){
				
	
	public static void MouseClick(WebElement element) {
		APP_LOGS.info("Mouse Click on the element");
		try {
			WaitUtil.waitForElementVisible(element);
			Actions action = new Actions(driver).click();
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
	
	public static void doubleClick(WebElement element) {
		APP_LOGS.info("Mouse Double Click");
		try {
			Actions action = new Actions(driver).doubleClick(element);
			WaitUtil.waitForElementVisible(element);
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

	public static void rightClick(WebElement element) {
		APP_LOGS.info("Mouse Right Click");
		try {
			Actions action = new Actions(driver).contextClick(element);
			WaitUtil.waitForElementVisible(element);
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

	public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				WaitUtil.waitForElementVisible(sourceElement);
				WaitUtil.waitForElementVisible(destinationElement);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		}
	}

	public static void scrollToBottom(WebDriver driver) {
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToelement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}


	public static void doClear(WebElement element) {
		APP_LOGS.info("Mouse Click and clear");
		try {
			Actions action = new Actions(driver).sendKeys(element,Keys.DELETE);
			WaitUtil.waitForElementVisible(element);
			element.clear();
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


	public static void mouseHoverJScript(WebElement HoverElement) {
		WaitUtil.waitForElementVisible(HoverElement);
		try {

			if (AssertionsUtil.isElementPresent(HoverElement)) {

				String mouseOverScript =/*"var element = arguments[0];"
						+ "var mouseEventObj = document.createEvent('MouseEvents');"
						+ "mouseEventObj.initEvent( 'mouseover', true, true );"
						+ "element.dispatchEvent(mouseEventObj);"; */
				
						"if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

				((JavascriptExecutor) driver).executeScript(mouseOverScript,HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}

		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}
	
	
	
	
	 
	//---------- Mouse Move,RighClick,Drag&Drop,DoubleClick,Scroll  Start----------//



	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				APP_LOGS.info("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}






	public  static boolean calander(String xpath,String fromdate){
		APP_LOGS.info("Selecting fromcalander");
		try{

			/*JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.document.getElementById('dob').setAttribute('value', '28/06/1984');");*/
			WebElement fromDateBox= driver.findElement(By.xpath(xpath));
			WaitUtil.waitForElementClickable(fromDateBox);
			fromDateBox.clear();
			Thread.sleep(2000L);
			fromDateBox.sendKeys(fromdate); //Enter date in required format
		}
		catch(Exception t){
			ErrorUtil.addVerificationFailure(t);
			return false;
		}
		return true;
	}

	public  static boolean tocalander(String ByID,String todata){
		APP_LOGS.info("Selecting Tocalander");
		try{
			//((JavascriptExecutor)driver).executeScript ("document.getElementById(ByID).removeAttribute('readonly',0);"); // Enables the from date box
			WebElement toDateBox= driver.findElement(By.id(ByID));
			WaitUtil.waitForElementClickable(toDateBox);
			toDateBox.clear();
			toDateBox.sendKeys(todata); //Enter date in required format
		}
		catch(Exception t){
			ErrorUtil.addVerificationFailure(t);
			return false;
		}
		return true;
	}

//   Date Picker
	
	
	public static void datePicker() throws Exception{
		//driver.findElement(By.xpath(".//*[@id='dt_of_occupation']")).click();
		WebElement datepicker = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
		// List<WebElement> rows =
		// datepicker.findElements(By.tagName("tr"));
		List<WebElement> cols = datepicker.findElements(By.tagName("td"));
		// System.out.println("Rows:
		// "+rows.size()+"\nColumns:"+cols.size());

		for (WebElement cell : cols) {
			if (cell.getText().equals("20")) {
				cell.findElement(By.linkText("20")).click();
				break;
			}
		}
		
	}


	//---------- Re-usable Select DroDown(SelectBox) Start----------//



	//Select DroDown ByVisibleText(element,value)
	
//	public static void select_Option_In_DropDown_ByVisibleText(WebElement element, String VisibleTextOptionToSelect) {
//		APP_LOGS.info("Selecting :("+VisibleTextOptionToSelect+") From Select List :"+element.getAttribute("id"));
//		try {
//			Select select = new Select(element);
//			select.selectByVisibleText(VisibleTextOptionToSelect);
//
//		} catch (StaleElementReferenceException e) {
//			System.out.println("Element is not attached to the page document "
//					+ e.getStackTrace());
//			APP_LOGS.info("Element is not attached to the page document "
//					+ e.getStackTrace());
//			
//		} catch (NoSuchElementException e) {
//			System.out.println("Element " + element + " was not found in DOM "
//					+ e.getStackTrace());
//			APP_LOGS.info("Element " + element + " was not found in DOM "
//					+ e.getStackTrace());
//			
//			
//		} catch (Exception e) {
//			System.out.println("Element " + element + " was not clickable "
//					+ e.getStackTrace());
//			APP_LOGS.info("Element " + element + " was not clickable "
//					+ e.getStackTrace());
//			
//		}
//	}
//
//	//Select DroDown ByValue(element,value)
//	public static void select_Option_In_DropDown_ByValue(WebElement element, String ValueTextToSelect) {
//		APP_LOGS.info("Selecting :("+ValueTextToSelect+") From Select List :"+element.getAttribute("id"));
//		try {
//			Select select = new Select(element);
//			select.selectByValue(ValueTextToSelect);
//
//		} catch (NoSuchElementException e) {
//			//System.out.println("Given option:("+ValueTextToSelect+") Not Found from Select List :"+element);
//			APP_LOGS.info("Given option:("+ValueTextToSelect+") Not Found from Select List :"+element.getAttribute("id"));
//			
//		}
//	}
//
//
//	//Select DroDown By index(element,value)q
//	public static void select_Option_In_DropDown_ByindexValue(WebElement element, int indexVal) {
//		APP_LOGS.info("Selecting :("+indexVal+") From Select List :"+element.getAttribute("id"));
//		try {
//			Select select = new Select(element);
//			select.selectByIndex(indexVal);
//		} catch (NoSuchElementException e) {
//			APP_LOGS.info("Given option:("+indexVal+") Not Found from Select List :"+element.getAttribute("id"));
//			System.err.println("Given option:("+indexVal+") Not Found from Select List :"+element.getAttribute("id"));
//		}
//	}

	/*//Select DroDown By index(element,value)
		public static void getSelectedIn_DropDown(WebElement element) {
			//APP_LOGS.info("Selecting :("+indexVal+") From Select List :"+element);
			String selectedValue=" ";
			try {
				Select select = new Select(element);
				WaitUtil.waitForEelementToBeSelected(element);
				selectedValue =select.getFirstSelectedOption().getText();

				System.err.println(selectedValue);
			} catch (NoSuchElementException e) {
				//APP_LOGS.info("Given option:("+indexVal+") Not Found from Select List :"+element);
				//System.err.println("Given option:("+indexVal+") Not Found from Select List :"+element);
				System.err.println("No--Results");
			}
			//return selectedValue;
		}*/

	public static String get_SelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedOption = selectedElement.getText();
		return selectedOption;
	}


	public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) {
		boolean bValue=false;
		List<String> list = new ArrayList<String>();
		for (String strValue : strValues) {
			boolean bflag = false;
			for (WebElement element : listOfElements) {
				String elementValue = element.getText();
				if (strValue.equals(elementValue)) {
					bflag= true;
				}
			}
			if (!bflag)
				list.add(strValue);
		}
		if (list.size() > 0) {
			for(String strList : list) {
				System.out.println("Value not present in dropdown: "+strList);
				APP_LOGS.info("Value not present in dropdown: "+strList);
			}
			//Assign false if any of the value not found in dropdown
			bValue = false;
		} else {
			//Assign true if all values found in dropdown
			System.out.println("All value(s) found in dropdown");
			APP_LOGS.info("All value(s) found in dropdown");
			bValue=true;
		}
		return bValue;
	}





	//---------- Re-usable Select DroDown(SelectBox) END----------//




	//---------- Re-usable Check Boxes Start----------//

	public static void Select_The_CheckBox_from_List(WebElement element,String TagName, String valueToSelect) {
		try{
			List<WebElement> allOptions = element.findElements(By.tagName(TagName));
			for (WebElement option : allOptions) {
				System.out.println("Option value "+option.getText());
				if (valueToSelect.equals(option.getText())) {
					option.click();

				}
			}
		}catch(Exception t){
			ErrorUtil.addVerificationFailure(t);
			System.out.println("Given option:("+valueToSelect+") Not Found from Select List :"+element.getAttribute("id"));
		}
	}
	
	


	public static void Select_The_Checkbox(WebElement element) {
		APP_LOGS.info("Selecting_The_Checkbox : " +element.getAttribute("id"));
		try {
			if (element.isSelected()) {
				//System.out.println("Checkbox: " + element + "is already selected");
				APP_LOGS.info("Checkbox: " + element.getAttribute("id") + "is already selected");
			} else {
				// Select the checkbox
				element.click();
			}
		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);
			//System.out.println("Unable to select the checkbox: " + element);
			APP_LOGS.info("Checkbox: " + element.getAttribute("id") + "is already selected");
		}

	}

	public static void DeSelect_The_Checkbox(WebElement element) {
		try {
			if (element.isSelected()) {
				//De-select the checkbox
				element.click();
			} else {
				System.out.println("Checkbox: "+element.getAttribute("id")+"is already deselected");
			}
		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);
			System.out.println("Unable to deselect checkbox: "+element.getAttribute("id"));
		}
	}



	//----------Re-Usable Check Boxes END----------//



	public static void Select_the_RadioButton(List<WebElement> element,String valueToSelect) {
		APP_LOGS.info("Select_the_RadioButton as--"+valueToSelect+"- on -");
		WaitUtil.waitForElementVisible(element);
		try {
			for (WebElement option : element) {
				//System.out.println("Option value "+option.getText());
				if (valueToSelect.equalsIgnoreCase(option.getAttribute("value"))) {
					WaitUtil.waitForElementClickable(option);
					option.click();
				}
			}
		}catch(Exception t){
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Given option:("+valueToSelect+") Not Found :");
			//System.out.println("Given option:("+valueToSelect+") Not Found from Select List :");
		}
	}


	public static void Select_Random_RadioButton (List<WebElement> element){
		APP_LOGS.info("Clicking_Radio Button_Randomly");
		WaitUtil.waitForElementVisible(element);
		try {
			Random random = new Random();
			int index = random.nextInt(element.size());
			element.get(index).click();
		}catch(Exception t){
			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.info("Unable to Click Radio Button_Randomly");

		}
	}


	public static void doSearch(WebElement search,String data) {
		try {
			if (search.isEnabled()
					|| search.isDisplayed()
					&&(search.equals(null))) {
				search.sendKeys(data);
			} else {
				search.clear();
			}
		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);

		}

	}


	public static void acceptAlertIfAvailable(){
		//APP_LOGS.info("Accept UnExpected Alert If Available");
		long waitForAlert= System.currentTimeMillis() + IMPLICIT_WAIT_TIMEOUT;
		boolean boolFound = false;
		do
		{
			try
			{
				Alert alert = driver.switchTo().alert();
				if (alert != null)
				{
					String alerttext=alert.getText().trim();
					APP_LOGS.info(" Alert Is Present:-"+alerttext);
					//createScreenshotUsingRobot(alerttext.trim()+name);
					alert.accept();
					boolFound = true;
				}
			}
			catch (NoAlertPresentException ex) {
			}
		} while ((System.currentTimeMillis() < waitForAlert) && (!boolFound));
	}
	

	public static boolean checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	public static void checkForBrokenLinks(){
		// Get all links url
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		String[] myLinks = new String[ele.size()];

		for(int i=0; i<ele.size(); i++){
			myLinks[i] = ele.get(i).getAttribute("href");
		}

		System.out.println("Total Number of links on  are :: "+ele.size()); 
		//System.out.println("\nStatus\t URL\t TEXT-NAME");
		String sLinkText="";

		for(int i=0;i<ele.size();i++)
		{
			sLinkText = ele.get(i).getText();

			int statusCode=0;
			try{
				statusCode=getResponseCode(ele.get(i).getAttribute("href"));
			}catch(Exception e)
			{
				//e.printStackTrace();
			}
			if(statusCode!=200 && statusCode!=201 && statusCode!=202&& 
					statusCode!=300 && statusCode!=301 && statusCode!=302 && statusCode!=303) 
			{
				//System.err.println("InvalidLink :\t"+ele.get(i).getAttribute("href") + 
				//	"--Response Code:" + statusCode);

				APP_LOGS.info("InvalidLink :\t"+ele.get(i).getAttribute("href") + 
						"--Response Code:" + statusCode);

			}else  {
				//System.out.println("ValidLink:\t"+ele.get(i).getAttribute("href")+"\t"+ele.get(i).getText());

			}

		}

	}
	
	public static void checklinks(List<WebElement>Element){
		// Get all links url
		//List<WebElement> ele = driver.findElements(By.tagName("a"));
		String[] myLinks = new String[Element.size()];

		for(int i=0; i<Element.size(); i++){
			myLinks[i] = Element.get(i).getAttribute("href");
		}

		System.out.println("Total Number of links on  are :: "+Element.size()); 
		//System.out.println("\nStatus\t URL\t TEXT-NAME");
		String sLinkText="";

		for(int i=0;i<Element.size();i++)
		{
			sLinkText = Element.get(i).getText();

			int statusCode=0;
			try{
				statusCode=getResponseCode(Element.get(i).getAttribute("href"));
			}catch(Exception e)
			{
				//e.printStackTrace();
			}
			if(statusCode!=200 && statusCode!=201 && statusCode!=202&& 
					statusCode!=300 && statusCode!=301 && statusCode!=302 && statusCode!=303) 
			{
				//System.err.println("InvalidLink :\t"+ele.get(i).getAttribute("href") + 
				//	"--Response Code:" + statusCode);

				APP_LOGS.info("InvalidLink :\t"+Element.get(i).getAttribute("href") + 
						"--Response Code:" + statusCode);

			}else  {
				System.out.println("ValidLink:\t"+Element.get(i).getAttribute("href")+"\t"+Element.get(i).getText());

			}

		}

	}

	//Get the URL response code
	public static int getResponseCode(String urlString) throws Exception {
		URL u = new URL(urlString);
		HttpURLConnection h = (HttpURLConnection)  u.openConnection();
		h.setRequestMethod("GET");
		h.connect();
		return h.getResponseCode();
	}




}
