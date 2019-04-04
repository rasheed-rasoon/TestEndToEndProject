package com.cgg.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test; 
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.OfficerLoggedinPage;
import com.cgg.Pages.TransferOfLicenceDistrictWebTablePage;
import com.cgg.Pages.TransferOfLicenceReplyToQuerPage;
import com.cgg.Pages.TrnasferOfLicenceWebTableProcessPage;
import com.cgg.util.FunctionUtil;

public class TransferOfLicenceOfficerProcess extends TestBase {
	@Test(priority = 0, description = "get applicaton number to perform officer activities ", enabled = true)
	public void getTheAppToProcessGrantOfLicence() {
		// Log in and get the application number
		//driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
//		HomePage ehome = PageFactory.initElements(driver, HomePage.class);
//		EntreprenuerLoggedinPage entp = ehome.Entreprenuerlogin("rasheed0566", "R@sheed0566");
//		entp.getApNumTransferOfLicenceEntreprenuerLogin();
		FunctionUtil.getAppNumForTransferOfLicOfficerProcess();
		System.out.println("Application number is "+FunctionUtil.getappNumTransferOfLicOffProcess);
		System.out.println("Alloted officer for"+FunctionUtil.getappNumTransferOfLicOffProcess+ " is "+FunctionUtil.getTransferOfLicAllotedOffId);
		System.out.println("Password  for "+FunctionUtil.getTransferOfLicAllotedOffId+ " is "+FunctionUtil.gettransferOfLicAllotedOffPwd);
		
		Assert.assertNotEquals(FunctionUtil.getappNumTransferOfLicOffProcess, null);
	}

	@Test(description = "officer put the status as Query", enabled = true,dependsOnMethods={"getTheAppToProcessGrantOfLicence"})
	public void putTheStatusAsQuery() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome = PageFactory.initElements(driver, HomePage.class);
		//FunctionUtil.getAllottedOfficerForGrantOfLicOfficerProcess();
		OfficerLoggedinPage off2 = ohome.officerlogin(FunctionUtil.getTransferOfLicAllotedOffId,FunctionUtil.gettransferOfLicAllotedOffPwd);
		TransferOfLicenceDistrictWebTablePage transferDist = off2.clickOnTransferOfLicencetLicenceView();
		TrnasferOfLicenceWebTableProcessPage transferProcess = transferDist.clickOnTransferPrescrutinyPendingTotal();
		transferProcess.sendApplicationNumber(FunctionUtil.getappNumTransferOfLicOffProcess);
		transferProcess.clickOnProcess();
		transferProcess.selectStatus("Query");
		transferProcess.sendOfficerRemarks("Query");
		transferProcess.clickOnUpdateButton();
		Assert.assertEquals(transferProcess.getConfirmationMessageForQuery(), "Data updated successfully...");
	}

	@Test(priority = 2, description = "entreprenuer replied for the query ",enabled=true,
			dependsOnMethods={"putTheStatusAsQuery"})
	public void ReplyTOQueryByTheEntreprenuer() {
		// Reply to Query
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ehome1 = PageFactory.initElements(driver, HomePage.class);
		EntreprenuerLoggedinPage entp1 = ehome1.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		TransferOfLicenceReplyToQuerPage transferReplyToQuery = entp1.TransferOfLicenceclickReplyToQuery("FNC201600185");
		transferReplyToQuery.fillReplyToQuerForm("doc", "doc");
		Assert.assertEquals(transferReplyToQuery.getConfirmationMessageForReplyToQuery(),"YOU HAVE SUCCESSFULLY RESPONDED TO QUERY");
		APP_LOGS.info("Reply to query done");
	}
	@Test(enabled = true,dependsOnMethods={"ReplyTOQueryByTheEntreprenuer"})
	public void putTheStatusAsScrutinyCompleted() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome = PageFactory.initElements(driver, HomePage.class);
		OfficerLoggedinPage off2 = ohome.officerlogin("IF-ADB", "guest");
		TransferOfLicenceDistrictWebTablePage tranDist=off2.clickOnTransferOfLicencetLicenceView();
		TrnasferOfLicenceWebTableProcessPage transWebTableProcess=tranDist.clickOnTransferPrescrutinyPendingTotal();
		transWebTableProcess.sendApplicationNumber("FNC201600185");
		transWebTableProcess.clickOnProcess();
		transWebTableProcess.selectStatus("Scrutiny Completed");
		transWebTableProcess.sendOfficerRemarks("Scrutiny Completed");
		transWebTableProcess.clickOnUpdateButton();
		Assert.assertEquals(transWebTableProcess.getConfirmationMessageForScrutiny(), "Data updated successfully...");
		APP_LOGS.info("Put the status as Scrutiny completed done");
	}
	@Test(priority = 4, enabled = true,dependsOnMethods={"putTheStatusAsScrutinyCompleted"})
	public void putTheStatusAsRejected() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome = PageFactory.initElements(driver, HomePage.class);
		OfficerLoggedinPage off2 = ohome.officerlogin("IF-ADB", "guest");
		TransferOfLicenceDistrictWebTablePage tranDist=off2.clickOnTransferOfLicencetLicenceView();
		TrnasferOfLicenceWebTableProcessPage transWebTableProcess=tranDist.ClickApprovalUnderProcessTotal();
		transWebTableProcess.sendApplicationNumber("FNC201600185");
		transWebTableProcess.clickOnProcess();
		transWebTableProcess.selectStatus("Rejected");
		transWebTableProcess.sendOfficerRemarks("Rejected");
		transWebTableProcess.clickOnUpdateButton();
		Assert.assertEquals(transWebTableProcess.getConfirmationMessageForReject(), "Data updated successfully...");
		APP_LOGS.info("Put the status as Rejected done");
	}

}
