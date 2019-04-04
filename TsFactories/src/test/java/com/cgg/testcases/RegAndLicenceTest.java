package com.cgg.testcases;

import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.RegAndLicenceSubmitPage;
import com.cgg.Pages.RegAndLicenceAppForm;
import com.cgg.util.TestUtil;

public class RegAndLicenceTest extends TestBase {
	@Test(dataProvider = "getData")
	public void RegistrationFormFilling(Hashtable<String, String> data) throws Exception {

		if (!TestUtil.isExecutable(this.getClass().getSimpleName(), xls) || data.get("Runmode").equalsIgnoreCase("N"))
			throw new SkipException("Skipping the Test Case Number");
		test=report.startTest("Testing Registration and Grant of licence form");
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		APP_LOGS.info("going to enter user id and paasword");
		EntreprenuerLoggedinPage lp = home.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		RegAndLicenceAppForm regForm = lp.clickOnRegGrantOfLicence();
		APP_LOGS.info("going to click on proceed to fill the form ");
		regForm.buttonClickOnProceed();
		regForm.sendFactoryFullName(data.get("SendFullNameOfTheFactory"));
		regForm.sendFactoryDoorNo(data.get("SendFactoryDoorNo"));
		regForm.sendFactoryLocality(data.get("SendFactoryLocality"));
		regForm.selectFactoryDistrict(data.get("SelectFactoryDistrict"));
		regForm.selectFactoryMandal(data.get("SelectFactoryMandal"));
		regForm.selectFactoryVillage(data.get("SelectFactoryVillage"));
		regForm.sendFactoryPincode(data.get("SendFactoryPincode"));
		regForm.sendFactoryFullPostalAddress(data.get("SendFactoryFullPostalAddress"));
		regForm.sendNatureOfManufacturingProcessMain(data.get("SendNatureOfManufacturingProcessMain"));
		// regForm.sendNatureOfManufacturingProcessSecondary(data.get("SendNatureOfManufacturingProcessSecondary"));
		regForm.sendRegularHorsePowerValue(data.get("SendRegularHorsePowerValue"));
		regForm.selectRegularHorsePowerUnits(data.get("SelectRegularHorsePowerUnits"));
		// regForm.sendStandbyHorsePowerValue(data.get("SendStandbyHorsePowerValue"));
		// regForm.selectStandbyHorsePowerUnits(data.get("SelectStandbyHorsePowerUnits"));
		regForm.sendWorkersAdultMaleCount(data.get("SendWorkersAdultMaleCount"));
		// regForm.sendWorkersAdultFeMaleCount(data.get("SendWorkersAdultFeMaleCount"));
		// regForm.sendWorkersAdolescentsMaleCount(data.get("SendWorkersAdolescentsMaleCount"));
		// regForm.sendWorkersAdolescentsFemaleCount(data.get("SendWorkersAdolescentsFemaleCount"));
		// regForm.sendWorkersChildrenMaleCount(data.get("SendWorkersChildrenMaleCount"));
		// regForm.sendWorkersChildrenFemaleCount(data.get("SendWorkersChildrenFemaleCount"));
		// regForm.sendReferenceByChiefInspector(data.get("SendReferenceByChiefInspector"));

		regForm.sendManagerFullName(data.get("SendManagerFullName"));
		regForm.sendManagerMobileNumber(data.get("SendManagerMobileNumber"));
		regForm.sendManagerMailId(data.get("SendManagerMailId"));
		regForm.sendManagerDoorNo(data.get("SendManagerDoorNo"));
		regForm.sendManagerLocality(data.get("SendManagerLocality"));
		regForm.selectManagerDistrict(data.get("SelectManagerDistrict"));
		regForm.selectManagerMandal(data.get("SelectManagerMandal"));
		regForm.selectManagerVillage(data.get("SelectManagerVillage"));
		regForm.sendManagerPincode(data.get("SendManagerPincode"));
		regForm.picFactoryOccupationDate();
		regForm.sendOccupierFullName(data.get("SendOccupierFullName"));
		// regForm.sendOccupierFullName(data.get("SendOccupierFullName"));
		regForm.sendOccupierMobileNumber(data.get("SendOccupierMobileNumber"));
		regForm.sendOccupierMailId(data.get("SendOccupierMailId"));
		regForm.sendOccupierDoorNo(data.get("SendOccupierDoorNo"));
		regForm.sendOccupierLocality(data.get("SendOccupierLocality"));

		regForm.selectOccupierState(data.get("SelectOccupierState"));

		regForm.selectOccupierDistrict(data.get("SelectOccupierDistrict"));

		regForm.selectOccupierMandal(data.get("SelectOccupierMandal"));
		regForm.selectOccupierVillage(data.get("SelectOccupierVillage"));

		regForm.sendOccupierPinCode(data.get("SendOccupierPinCode"));
		regForm.sendOccupierPositionInCompany(data.get("SendOccupierPositionInCompany"));
		regForm.sendOwnerFullName(data.get("SendOwnerFullName"));
		regForm.sendOwnerMobileNumber(data.get("SendOwnerMobileNumber"));
		regForm.sendOwnerEmailId(data.get("SendOwnerEmailId"));
		regForm.sendOwnerDoorNo(data.get("SendOwnerDoorNo"));
		regForm.sendOwnerLocality(data.get("SendOwnerLocality"));
		regForm.selectOwnerState(data.get("SelectOwnerState"));
		regForm.selectOwnerdistrict(data.get("SelectOwnerdistrict"));
		regForm.selectOwnerMandal(data.get("SelectOwnerMandal"));
		regForm.selectOwnerVillage(data.get("SelectOwnerVillage"));
		regForm.sendOwnerPinCode(data.get("SendOwnerPinCode"));
		regForm.selectLicenseYears(data.get("SelectLicenseYears"));
		regForm.selectTypeOfFactory(data.get("SelectTypeOfFactory"));
		regForm.browseProposedInventoriesOfChemicls();
		regForm.browseListOfPartnersAndDirectors();
		regForm.browsePartnershipDeed();
		regForm.browseLandOwnerShipDocuments();
		regForm.browseOccupierPhotoId();
		regForm.browseReferenceByDirectories();
		RegAndLicenceSubmitPage submitPage = regForm.clickPreviewAndContinue();
		if (data.get("DataFlag").equalsIgnoreCase("P")) {
			Assert.assertEquals(submitPage.getcheckboxtext(),
					"I hereby declare that the above information is true to the best of my knowledge and belief.");
			System.err.println(submitPage.getcheckboxtext());
			APP_LOGS.info(submitPage.getcheckboxtext());
			submitPage.clickOnDeclatration();
			submitPage.clickOnSubmit();
			Assert.assertTrue(submitPage.isProceedToPaymenyPageOpened(), "Not navigated to Payment page");
		} else if (data.get("DataFlag").equalsIgnoreCase("N")) {
			Assert.assertEquals(submitPage.getcheckboxtext(), "");
		}
	}

	@DataProvider
	public Object[][] getData() {
		return TestUtil.getData(this.getClass().getSimpleName(), xls);
	}

}
