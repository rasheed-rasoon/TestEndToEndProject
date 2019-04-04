package com.cgg.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.OfficerLoggedinPage;
import com.cgg.Pages.PlanOfAppDistrictWebTablePage;
import com.cgg.Pages.PlanOfAppWebtableProcessPage;
import com.cgg.Pages.PlanOfAppReplyToQueryFormPage;

public class PlanOfAppOfficerProcessTest extends TestBase {
	// public Object entp;
	@Test(description = "get applicaton number to perform officer activities ", enabled=true)
	public void getTheAppToProcessPlanApproval() throws Exception {
		// Log in and get the application number
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ehome = PageFactory.initElements(driver, HomePage.class);
		EntreprenuerLoggedinPage entp = ehome.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		entp.getApNumPlanOfApprovalEntreprenuerLogin();
		Assert.assertNotEquals(EntreprenuerLoggedinPage.appNumber, null);
	}

	@Test(priority=1,description = "officer put the status as Query", enabled = true)
	public void putTheStatusAsQuery() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome = PageFactory.initElements(driver, HomePage.class);
		OfficerLoggedinPage offl = ohome.officerlogin("DOF", "guest");
		PlanOfAppDistrictWebTablePage planDistTable = offl.clickOnPlanofApprovalView();
		PlanOfAppWebtableProcessPage PlanProcessTable = planDistTable.ClickOnPrescrutinyPendingTotal();
		System.out.println("Application number is " + EntreprenuerLoggedinPage.appNumber);
		PlanProcessTable.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);
		PlanProcessTable.ClickOnProcess();
		PlanProcessTable.selectStatus("Query");
		PlanProcessTable.clickOnUpdateButton();
		Assert.assertEquals(PlanProcessTable.getConfirmationMessageForQuery(), "Data updated success fully");
	}

	@Test(priority=2,description = "entreprenuer replied for the query ", enabled = true)
	public void ReplyTOQueryByTheEntreprenuer() throws Exception {
		// Reply to Query
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ehome1 = PageFactory.initElements(driver, HomePage.class);
		EntreprenuerLoggedinPage entp1 = ehome1.Entreprenuerlogin("rasheed0566", "R@sheed0566");

		PlanOfAppReplyToQueryFormPage rQuery = entp1
				.planOfApprovalclickReplyToQuery(EntreprenuerLoggedinPage.appNumber);// (entp.appNumber
		Assert.assertTrue(rQuery.isPlanOfAppReplyToQueryFormPage(), "not navigated to Reply to Query page");
		rQuery.fillReplyToQuerForm("doc type", " Query Replied ");

		Assert.assertEquals(rQuery.getReplyToQueryConfirmationMessage(), "YOU HAVE SUCCESSFULLY RESPONDED TO QUERY");
		entp1.doEntreprenuerLogout();

	}

	// Scrutiny Completed
	@Test(priority=3,description = "officer put the status as Scutiny completed", enabled = true)
	public void PutTheStatusAsScrutinyCompleted() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome = PageFactory.initElements(driver, HomePage.class);
		OfficerLoggedinPage offl = ohome.officerlogin("DOF", "guest");
		PlanOfAppDistrictWebTablePage planDistTable = offl.clickOnPlanofApprovalView();
		PlanOfAppWebtableProcessPage PlanProcessTable = planDistTable.ClickOnPrescrutinyPendingTotal();
		System.out.println("Application number is " + EntreprenuerLoggedinPage.appNumber);
		PlanProcessTable.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);
		PlanProcessTable.ClickOnProcess();
		PlanProcessTable.selectStatus("Scrutiny Completed");
		PlanProcessTable.clickOnUpdateButton();
		Assert.assertEquals(PlanProcessTable.getConfirmationMessageForScrutiny(), "Data updated success fully");
	}

	// Rejection
	@Test(priority=4,description = "Oficer put the status as Rejected", enabled = true)
	public void putTheStatusAsReject() {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage ohome2 = PageFactory.initElements(driver, HomePage.class);
		OfficerLoggedinPage off2 = ohome2.officerlogin("DOF", "guest");
		PlanOfAppDistrictWebTablePage planDistTable1 = off2.clickOnPlanofApprovalView();
		PlanOfAppWebtableProcessPage PlanProcessTable1 = planDistTable1.ClickApprovalUnderProcessTotal();
		// System.out.println("Application number is "+entp.appNumber);
		PlanProcessTable1.sendApplicationNumber(EntreprenuerLoggedinPage.appNumber);// EntreprenuerLoggedinPage.appNumber
		PlanProcessTable1.ClickOnProcess();
		PlanProcessTable1.selectStatus("Reject");
		PlanProcessTable1.reasonFOrRejection("Not complied with the Queries raised");
		PlanProcessTable1.clickOnUpdateButton();
		Assert.assertEquals(PlanProcessTable1.getConfirmationMessageForReject(), "Data updated success fully");
	}
}
