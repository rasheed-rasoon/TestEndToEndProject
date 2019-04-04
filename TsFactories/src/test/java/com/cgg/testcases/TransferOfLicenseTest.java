package com.cgg.testcases;

import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.TransferOfLicenceSubmitPage;
import com.cgg.Pages.TransferOfLicensePages;
import com.cgg.util.FunctionUtil;
import com.cgg.util.TestUtil;

public class TransferOfLicenseTest extends TestBase{
  @Test(dataProvider = "getData")
	   	public void TransferOfLicenceFormFilling(Hashtable<String, String> data) throws Exception {

		if (!TestUtil.isExecutable(this.getClass().getSimpleName(), xls) || data.get("Runmode").equalsIgnoreCase("N"))
			throw new SkipException("Skipping the Test Case Number");

		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		//APP_LOGS.info("going to enter user id and paasword");
		EntreprenuerLoggedinPage lp = home.Entreprenuerlogin("rasheed0566", "R@sheed0566");
		//lp.mouseHoverOnServices();
		TransferOfLicensePages transfer=lp.clickOnTransferOfLicense();
		FunctionUtil.getTransferFreshRegNumForFormFilling();
		transfer.sendRegistrationNumber(FunctionUtil.transferFreshRegNum);
		transfer.clickOnFactoryFullName();
		transfer.sendFactoryDoorNo(data.get("SendFactoryDoorNo"));	
	
		transfer.sendFactoryLocality(data.get("FactoryLocality"));
		transfer.selectTransferFactoryDistrict(data.get("TransferFactoryDistrict"));
		transfer.selectTransferFactoryMandal(data.get("TransferFactoryMandal"));
		transfer.selectTransferFactoryVillage(data.get("TransferFactoryVillage"));
		transfer.sendFactoryPincode(data.get("FactoryPincode"));	
		transfer.sendFactoryDoorNo(data.get("SendFactoryDoorNo"));
		transfer.sendCommunicationAddress(data.get("CommunicationAddress"));
		transfer.clickManager();
		transfer.sendOutgoingManagerOccupier(data.get("NameOfOutgoingManagerOrOccupier"));
		transfer.sendManagerFullName(data.get("ManagerFullName"));
		transfer.sendManagerMobileNumber(data.get("SendManagerMobileNumber"));
		transfer.sendManagerEmailId(data.get("ManagerEmailId"));
		transfer.sendManagerDoorno(data.get("ManagerDoorno"));
		transfer.sendManagerLocality(data.get("ManagerLocality"));
		transfer.selectManagerState(data.get("ManagerState"));
		transfer.selectManagerDistrict(data.get("ManagerDistrict"));
		transfer.selectManagerMandal(data.get("ManagerMandal"));
		transfer.selectManagerVillage(data.get("ManagerVillage"));
//		transfer.selectOtherState("OtherState");
//		transfer.sendOtherStatePostalAddress(data.get("OtherStatePostalAddress"));
		transfer.sendManagerPincode(data.get("ManagerPincode"));
		transfer.dateAppointmentOfManager();
		TransferOfLicenceSubmitPage transferSubmit=transfer.clickPreviewAndContinue();
	
		if(data.get("DataFlag").equalsIgnoreCase("P")){
			FunctionUtil.acceptAlertIfAvailable();
			Assert.assertEquals(transferSubmit.getcheckboxtext(), "I hereby declare that the above information is true to the best of my knowledge and belief.");
			System.err.println(transferSubmit.getcheckboxtext());
			APP_LOGS.info(transferSubmit.getcheckboxtext());
			transferSubmit.clickOnDeclarationTransferOfLicence();
			transferSubmit.clickOnSubmitTransferOfLicence();
			Assert.assertTrue(transferSubmit.isTransferOfLicencesuccesfulPageOpened(), "Not navigated to Payment page");
		}
			else
			if(data.get("DataFlag").equalsIgnoreCase("N")){
				FunctionUtil.acceptAlertIfAvailable();
				Assert.assertTrue(transfer.isTransferOfLicenceFormPageOpened(),"Navigating Payment Page"); 
				Assert.assertEquals(transferSubmit.getcheckboxtext(),"");

			}	
}
	@DataProvider
	public Object[][] getData() {
		return TestUtil.getData(this.getClass().getSimpleName(), xls);
	}
}