package com.cgg.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.OfficerLoggedinPage;
import com.cgg.Pages.RegAndLicenceDistrictWebTablePage;
import com.cgg.Pages.RegAndLicenceReplyToQueryPage;
import com.cgg.Pages.RegAndLicenceWebTableProcessPage;

public class RegAndLicenceOfficerProcessTest extends TestBase {
  @Test(priority=0,description="get applicaton number to perform officer activities ")
  public void getTheAppToProcessGrantOfLicence() {
	// Log in and get the application number
		  driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
			HomePage ehome=PageFactory.initElements(driver,HomePage.class);
			EntreprenuerLoggedinPage    entp= ehome.Entreprenuerlogin("rasheed0566", "R@sheed0566");
			entp.getApNumGrantOfLicenceEntreprenuerLogin();
			Assert.assertNotEquals(EntreprenuerLoggedinPage.appNumber, null);
  }
  @Test(priority=1,description="officer put the status as Query")
  public void putTheStatusAsQuery()
  {
	  driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
	  HomePage ohome=PageFactory.initElements(driver,HomePage.class);
	  OfficerLoggedinPage offl= ohome.officerlogin("DOF","guest");
	  RegAndLicenceDistrictWebTablePage regDistr=offl.clickOnRegAndLicenceView();
	  
	  RegAndLicenceWebTableProcessPage regProcess= regDistr.clickOnRegPrescrutinyPendingTotal();
	  regProcess.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);//EntreprenuerLoggedinPage.appNumber
	  regProcess.ClickOnProcess();
	  regProcess.selectStatus("Query");
	  regProcess.clickOnUpdateButton();
	  Assert.assertEquals(regProcess.getConfirmationMessageForQuery(), "Application Updated Successfully...");
	  APP_LOGS.info("Query process done");
	  
 }
  @Test(priority=2,description="entreprenuer replied for the query ")
 public void ReplyTOQueryByTheEntreprenuer(){
   //Reply to Query
     driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
     HomePage ehome1=PageFactory.initElements(driver,HomePage.class);
     EntreprenuerLoggedinPage    entp1= ehome1.Entreprenuerlogin("rasheed0566", "R@sheed0566");
     RegAndLicenceReplyToQueryPage regRplyToQuery=entp1.regAndLicenceclickReplyToQuery(EntreprenuerLoggedinPage.appNumber);
      regRplyToQuery.fillReplyToQuerForm("sod","Remarks entered");
      Assert.assertEquals(regRplyToQuery.getReplyToQueryConfirmationMessage(), "YOU HAVE SUCCESSFULLY RESPONDED TO QUERY");
      APP_LOGS.info("Reply to Query done");
}  
  @Test(priority=3,description="officer put the status as Scutiny completed")
  public void PutTheStatusAsScrutinyCompleted(){
	  driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
	  HomePage ohome=PageFactory.initElements(driver,HomePage.class);
      OfficerLoggedinPage    off2= ohome.officerlogin("DOF","guest");
      RegAndLicenceDistrictWebTablePage regDisTable=off2.clickOnRegAndLicenceView();
      RegAndLicenceWebTableProcessPage regTableProcess= regDisTable.clickOnRegPrescrutinyPendingTotal();
      regTableProcess.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);
      regTableProcess.ClickOnProcess();
      regTableProcess.selectStatus("Scrutiny Completed");
      regTableProcess.clickOnUpdateButton();
      Assert.assertEquals(regTableProcess.getConfirmationMessageForScrutiny(), "Application Updated Successfully...");
      APP_LOGS.info("Scrutiny completed process done");
      
  }
	@Test(priority=4)
  public void putTheStatusAsReject()
  {
 driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
 HomePage ohome2=PageFactory.initElements(driver,HomePage.class);
 OfficerLoggedinPage    off2= ohome2.officerlogin("DOF","guest");
 RegAndLicenceDistrictWebTablePage regDisTable=off2.clickOnRegAndLicenceView();
 RegAndLicenceWebTableProcessPage regProcess=regDisTable.ClickApprovalUnderProcessTotal();
 regProcess.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);
 regProcess.ClickOnProcess();
 regProcess.selectStatus("Rejected");
 regProcess.clickOnUpdateButton();
 Assert.assertEquals(regProcess.getConfirmationMessageForRejection(), "Application Updated Successfully...");
 APP_LOGS.info("Rejected done"); //Application Updated Successfully...

  }
  
  
}
 
//}
