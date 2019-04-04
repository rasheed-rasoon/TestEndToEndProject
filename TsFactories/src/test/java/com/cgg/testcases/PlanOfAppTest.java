package com.cgg.testcases;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.PlanOfAppappFormPage;
import com.cgg.util.TestUtil;

public class PlanOfAppTest extends TestBase {
    @Test(dataProvider = "getData",description="Plan of Approval form filling")
	public void planOfApprovalFormFilling(Hashtable<String,String>data) throws Exception {

		if (!TestUtil.isExecutable(this.getClass().getSimpleName(), xls) || data.get("Runmode").equalsIgnoreCase("N"))
			throw new SkipException("Skipping the Test Case Number");
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		EntreprenuerLoggedinPage lp = home.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		PlanOfAppappFormPage plan = lp.clickOnPlanOfApprovalExtension();
		plan.clickContinue();
		plan.clickFactoryPlanTypeNew();
		plan.sendFactoryName(data.get("SendFactoryName"));
		plan.sendFactoryPlanTypeDoorNo(data.get("SendFactoryPlanTypeDoorNo"));
		plan.sendFactoryLocality(data.get("SendFactoryLocality"));
		plan.selectFactoryDistrict(data.get("SelectFactoryDistrict"));
 
		plan.selectFactoryMandal(data.get("SelectFactoryMandal"));

		plan.selectFactoryVillage(data.get("SelectFactoryVillage"));

		plan.sendFactoryPincode(data.get("SendFactoryPincode"));
		plan.sendFactoryCommunicationAddress(data.get("SendFactoryCommunicationAddress"));
		plan.sendMobileNumber(data.get("SendMobileNumber"));
		
		plan.sendEmailAddress(data.get("SendEmailAddress"));
		

		plan.sendNumberOfWorkersMen(data.get("SendNumberOfWorkersMen"));
		plan.sendNumberOfWorkersWomen(data.get("SendNumberOfWorkersWomen"));

		plan.browselistOfPlantMachinery(data.get("BrowseListOfPlantMachinery"));

		plan.sendInstalledHorsePower(data.get("SendInstalledHorsePower"));
		plan.sendRawMaterialUsed(data.get("SendRawMaterialUsed"));
				

		// plan.browseManufacturingProcess(data.get("BrowseManufacturingProcess"));
		plan.browseManufacturingProcess(data.get("BrowseManufacturingProcess"));

		plan.sendFinalProducts(data.get("SendFinalProducts"));
		plan.browseManufacturingProcess(data.get("BrowseManufacturingProcess"));
		plan.sendFinalOutputs(data.get("SendFinalOutputs"));
		plan.browseTypeOfWaste(data.get("BrowseTypeOfWaste"));
		plan.sendAdditionsOrExtensions(data.get("SendAdditionsOrExtensions"));
		plan.browseOccupierSign(data.get("BrowseOccupierSign"));
		plan.clickIndustryTypeSsi();
		plan.browseLeaseDeed(data.get("BrowseLeaseDeed"));
		plan.browseSitePlan(data.get("BrowseSitePlan"));
		plan.browseDetaildedBuildingPlan(data.get("BrowseDetaildedBuildingPlan"));
		plan.browsePartnershipDeed(data.get("BrowsePartnershipDeed"));
		plan.browseProcessFlowChart(data.get("BrowseProcessFlowChart"));
		plan.browseCopyOfPan(data.get("BrowseCopyOfPan"));
		plan.browseSsiCertificate(data.get("BrowseSsiCertificate"));
		plan.clickDeclaration();
		//plan.clickSubmitApplication();
		
		if(data.get("DataFlag").equalsIgnoreCase("P")){
			Assert.assertTrue(plan.isPlanOfApprovalPaymentPageOpened(),"Not navigated to Payment Page");
		}else
			if(data.get("DataFlag").equalsIgnoreCase("N")){
				Assert.assertTrue(plan.isPlanOfApprovalFormPageOpened(),"Navigating Payment Page"); 
			}
	}

	
	@DataProvider
	public Object[][] getData() {
		return TestUtil.getData(this.getClass().getSimpleName(), xls);
	}
}