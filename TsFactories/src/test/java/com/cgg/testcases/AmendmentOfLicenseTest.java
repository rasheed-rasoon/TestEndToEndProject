package com.cgg.testcases;
import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cgg.Pages.AmendmentOfLicenseFormPage;
import com.cgg.Pages.AmendmentSubmitPage;
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.util.FunctionUtil;
import com.cgg.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class AmendmentOfLicenseTest extends TestBase {
	
	@Test(dataProvider = "getData")
	public void amendmentFormFiling(Hashtable<String, String> data) throws Exception {

		if (!TestUtil.isExecutable(this.getClass().getSimpleName(), xls) || data.get("Runmode").equalsIgnoreCase("N"))
			throw new SkipException("Skipping the Test Case Number");
		test=report.startTest("Test Amendment of Licence App form"+" for the test case "+data.get("TC"));
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		test.log(LogStatus.INFO, "Navigated to url");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		EntreprenuerLoggedinPage lp = home.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		AmendmentOfLicenseFormPage amendment = lp.clickOnAmendmentOfLicense();
		test.log(LogStatus.INFO, "going to click on Amendment of licence continue button ");
		amendment.amendmentClickOnContinue();
		test.log(LogStatus.INFO, "going to enter registration number ");
		FunctionUtil.getAmendmentFreshRegNumForFormFilling();
		amendment.sendRegistrationNumber(FunctionUtil.amendFreshRegNum);
		amendment.clickExistingFactoryNameYes();
		amendment.sendExistingFactoryNameText(data.get("ExistingFactoryNameText"));
		amendment.clickExistingHorsePowerYes();
		amendment.sendRegularHorsePowerValue(data.get("RegularHorsePowerValue"));
		amendment.selectRegularHorsePowerUnits(data.get("RegularHorsePowerUnits"));
		amendment.sendStandbyHorsePowerValue(data.get("StandbyHorsePowerValue"));
		amendment.selectStandbyHorsePowerUnits(data.get("StandbyHorsePowerUnits"));
		amendment.clickNoOfWorkersYes();
		amendment.sendAdultsMale(data.get("AdultsMale"));
		amendment.sendAdultsFemale(data.get("AdultsFemale"));
		amendment.sendAdolescentsMale(data.get("AdolescentsMale"));
		amendment.sendAdolescentsFemale(data.get("AdolescentsFemale"));
		amendment.sendChildrenMale(data.get("ChildrenMale"));
		amendment.sendChildrenFemale(data.get("ChildrenFemale"));
		amendment.sendFactoryDoorno(data.get("FactoryDoorno"));
		amendment.sendFactoryLocality(data.get("FactoryLocality"
				
				
				));
		amendment.selectFactoryDistrict(data.get("FactoryDistrict"));
		amendment.selectFactoryMandal(data.get("FactoryMandal"));
		amendment.selectFactoryVillage(data.get("FactoryVillage"));
		amendment.sendFactoryPincode(data.get("FactoryPincode"));
		amendment.sendFactoryCommunicationAddress(data.get("FactoryCommunicationAddress"));
		amendment.sendManufacturingProcessMain(data.get("ManufacturingProcessMain"));
		amendment.sendManufacturingProcessSecondary(data.get("ManufacturingProcessSecondary"));
		amendment.sendReferencePlans(data.get("ReferencePlans"));
		amendment.sendManagerFullName(data.get("ManagerFullName"));
		amendment.sendManagerMobileNumber(data.get("ManagerMobileNumber"));
		amendment.sendManagerEmailId(data.get("ManagerEmailId"));
		amendment.sendManagerDoorno(data.get("ManagerDoorno"));
		amendment.sendManagerLocality(data.get("ManagerLocality"));
		amendment.selectManagerDistrict(data.get("ManagerDistrict"));
		amendment.selectManagerMandal(data.get("ManagerMandal"));
		amendment.selectManagerVillage(data.get("ManagerVillage"));
		amendment.sendManagerPincode(data.get("ManagerPincode"));
		amendment.dateOccupierDate();
		amendment.sendOccupierFullName(data.get("OccupierFullName"));
		amendment.sendOccupierMobileNumber(data.get("OccupierMobileNumber"));
		amendment.sendOccupierEmailId(data.get("OccupierEmailId"));
		amendment.sendOccupierDoorno(data.get("OccupierDoorno"));
		amendment.sendOccupierLocality(data.get("OccupierLocality"));
		amendment.selectOccupierDistrict(data.get("OccupierDistrict"));
		amendment.selectOccupierMandal(data.get("OccupierMandal"));
		amendment.selectOccupierVillage(data.get("OccupierVillage"));
		amendment.sendOccupierPincode(data.get("OccupierPincode"));
		amendment.sendPositionInTheCompany(data.get("PositionInTheCompany"));
		amendment.sendOwnerFullname(data.get("OwnerFullname"));
		amendment.sendOwnerMobileNumber(data.get("OwnerMobileNumber"));
		amendment.sendOwnerEmailId(data.get("OwnerEmailId"));
		amendment.sendOwnerDoorno(data.get("OwnerDoorno"));
		amendment.sendOwnerLocality(data.get("OwnerLocality"));
		amendment.selectOwnerDistrict(data.get("OwnerDistrict"));
		amendment.selectOwnerMandal(data.get("OwnerMandal"));
		amendment.selectOwnerVillage(data.get("OwnerVillage"));
		amendment.sendOwnerPincode(data.get("OwnerPincode"));
		amendment.selectAmendmentYear(data.get("AmendmentYear"));
		amendment.browseOriginalLicenseForm(data.get("OriginalLicenseForm"));
		amendment.browseChangePartnerShipOrSaleDeed(data.get("PartnerShipAndSaleDeed"));
		amendment.browseReferenceNumber(data.get("ReferenceNumber"));
		
		AmendmentSubmitPage amendmentsubmit = amendment.clickPreviewAndContinue();
		amendmentsubmit.clickOnDeclarationAmendment();
		amendmentsubmit.clickOnSubmitAmendment();
		
		if (data.get("DataFlag").equalsIgnoreCase("P")&& !amendment.isAmendmentOfLicenseFormPageOpened()){
			reportFail("unable to navigated to submit page with valid data ");

		}else if(data.get("DataFlag").equalsIgnoreCase("N")&& amendment.isAmendmentOfLicenseFormPageOpened()) {
			reportFail("able to navigated to submit page with In valid data ");
		}
		else{
			reportpass("Amendment Of Licence Form submission working fine");
		}
	}

	@DataProvider
	public Object[][] getData() {

		return TestUtil.getData(this.getClass().getSimpleName(), xls);
	}
}
