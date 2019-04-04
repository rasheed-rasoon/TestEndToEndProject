package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cgg.constants.TransferOfLicenseConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class TransferOfLicensePages extends TestBase{

	private WebDriver driver;

	public TransferOfLicensePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = TransferOfLicenseConstants.REGISTRATIONNUMBER)
	private WebElement RegistrationNumber;

	@FindBy(xpath = TransferOfLicenseConstants.FACTORYFULLNAME)
	private WebElement FactoryFullName;

	@FindBy(xpath = TransferOfLicenseConstants.FACTORYDOORNO)
	private WebElement FactoryDoorNo;

	@FindBy(xpath = TransferOfLicenseConstants.FACTORYLOCALITY)
	private WebElement FactoryLocality;

	@FindBy(xpath = TransferOfLicenseConstants.TRANSFERFACTORYDISTRICT)
	private WebElement TransferFactoryDistrict;

	@FindBy(xpath = TransferOfLicenseConstants.TRANSFERFACTORYMANDAL)
	private WebElement TransferFactoryMandal;

	@FindBy(xpath = TransferOfLicenseConstants.TRANSFERFACTORYVILLAGE)
	private WebElement TransferFactoryVillage;

	@FindBy(xpath = TransferOfLicenseConstants.FACTORYPINCODE)
	private WebElement FactoryPincode;

	@FindBy(xpath = TransferOfLicenseConstants.COMMUNICATIONADDRESS)
	private WebElement CommunicationAddress;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGER)
	private WebElement Manager;

	@FindBy(xpath = TransferOfLicenseConstants.OUTGOINGMANAGEROCCUPIER)
	private WebElement OutgoingManagerOccupier;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERFULLNAME)
	private WebElement ManagerFullName;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERMOBILENUMBER)
	private WebElement ManagerMobileNumber;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGEREMAILID)
	private WebElement ManagerEmailId;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERDOORNO)
	private WebElement ManagerDoorno;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERLOCALITY)
	private WebElement ManagerLocality;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERSTATE)
	private WebElement ManagerState;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERDISTRICT)
	private WebElement ManagerDistrict;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERMANDAL)
	private WebElement ManagerMandal;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERVILLAGE)
	private WebElement ManagerVillage;

	@FindBy(xpath = TransferOfLicenseConstants.OTHERSTATE)
	private WebElement OtherState;

	@FindBy(xpath = TransferOfLicenseConstants.OTHERSTATEPOSTALADDRESS)
	private WebElement OtherStatePostalAddress;

	@FindBy(xpath = TransferOfLicenseConstants.MANAGERPINCODE)
	private WebElement ManagerPincode;

	@FindBy(xpath = TransferOfLicenseConstants.APPOINTMENTOFMANAGER)
	private WebElement AppointmentOfManager;

	@FindBy(css = TransferOfLicenseConstants.PREVIEWANDCONTINUE)
	private WebElement PreviewAndContinue;

	public void sendRegistrationNumber(String registrationNumber) {
		APP_LOGS.info("Goging to enter Regstreation number");
		sendKeysToTextBox(this.RegistrationNumber, registrationNumber);}

	public void sendFactoryFullName(String factoryFullName) {
		APP_LOGS.info("going to enter Registration  number");
		sendKeysToTextBox(this.FactoryFullName, factoryFullName);
	}

	@FindBy(xpath = ".//*[@id='em']/td/font")
	private WebElement ErrorMessageForInvalidRegNumber;

	public void clickOnFactoryFullName() {
APP_LOGS.info("Going to click on Factory name for autopopulating some fields");
clickOnButton(this.FactoryFullName);
		 // for autopopulating the corresponding fields 
	}

	public void sendFactoryDoorNo(String factoryDoorNo) {
		WaitUtil.waitForElementClickable(this.FactoryDoorNo);
		sendKeysToTextBox(this.FactoryDoorNo, factoryDoorNo);
        }

	public void sendFactoryLocality(String factoryLocality) {
		sendKeysToTextBox(this.FactoryLocality, factoryLocality);

	}

	public void selectTransferFactoryDistrict(String transferFactoryDistrict) {
		WaitUtil.waitForElementClickable(this.TransferFactoryDistrict);
		select_Option_In_DropDown_ByVisibleText(this.TransferFactoryDistrict, transferFactoryDistrict);
	}

	public void selectTransferFactoryMandal(String transferFactoryMandal) {
		WaitUtil.waitForElementClickable(this.TransferFactoryMandal);
		select_Option_In_DropDown_ByVisibleText(this.TransferFactoryMandal, transferFactoryMandal);
	}

	public void selectTransferFactoryVillage(String transferFactoryVillage) {
		WaitUtil.waitForElementClickable(this.TransferFactoryVillage);
		select_Option_In_DropDown_ByVisibleText(this.TransferFactoryVillage, transferFactoryVillage);
	}

	public void sendFactoryPincode(String factoryPincode) {
		sendKeysToTextBox(this.FactoryPincode, factoryPincode);

	}

	public void sendCommunicationAddress(String communicationAddress) {
		
		sendKeysToTextBox(this.CommunicationAddress, communicationAddress);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void clickManager() {
		clickOnButton(this.Manager);
	}

	public void sendOutgoingManagerOccupier(String outgoingManagerOccupier) {
	
		sendKeysToTextBox(this.OutgoingManagerOccupier, outgoingManagerOccupier);
	}

	public void sendManagerFullName(String managerFullName) {

		sendKeysToTextBox(this.ManagerFullName, managerFullName);
	}

	public void sendManagerMobileNumber(String managerMobileNumber) {
		sendKeysToTextBox(this.ManagerMobileNumber, managerMobileNumber);
	}

	public void sendManagerEmailId(String managerEmailId) {
		sendKeysToTextBox(this.ManagerEmailId, managerEmailId);
		FunctionUtil.acceptAlertIfAvailable();
		
	}

	public void sendManagerDoorno(String managerDoorno) {
		sendKeysToTextBox(this.ManagerDoorno, managerDoorno);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerLocality(String managerLocality) {
	sendKeysToTextBox(this.ManagerLocality, managerLocality);
	}

	public void selectManagerState(String managerState) {
		//WaitUtil.waitForElementClickable(this.ManagerState);
		select_Option_In_DropDown_ByVisibleText(this.ManagerState, managerState);
	}
	
	public void selectManagerDistrict(String managerDistrict) {
		//WaitUtil.waitForElementClickable(this.ManagerDistrict);
	select_Option_In_DropDown_ByVisibleText(this.ManagerDistrict, managerDistrict);
	}

	public void selectManagerMandal(String managerMandal) {
		//WaitUtil.waitForElementClickable(this.ManagerMandal);
		select_Option_In_DropDown_ByVisibleText(this.ManagerMandal, managerMandal);
	}

	public void selectManagerVillage(String managerVillage) {
		//WaitUtil.waitForElementClickable(this.ManagerVillage)
		select_Option_In_DropDown_ByVisibleText(this.ManagerVillage, managerVillage);
	}
	
	public void selectOtherState(String otherState) {
		//WaitUtil.waitForElementClickable(this.OtherState);
		APP_LOGS.info("Going to select other state if the manager belongs to otherthan Telangana");
	select_Option_In_DropDown_ByVisibleText(this.OtherState, otherState);
	}
	
	public void sendOtherStatePostalAddress(String otherStatePostalAddress) {
		APP_LOGS.info("Going to enter other state posstal address");
		sendKeysToTextBox(this.OtherStatePostalAddress, otherStatePostalAddress);
	}

	public void sendManagerPincode(String managerPincode) {
		APP_LOGS.info("Going to enter manager pincode");
		sendKeysToTextBox(this.ManagerPincode, managerPincode);
	}

	public void dateAppointmentOfManager() throws Exception {
		APP_LOGS.info("Going to select a date of appointment of Manager");
		clickOnButton(this.AppointmentOfManager);
		FunctionUtil.acceptAlertIfAvailable();
		FunctionUtil.datePicker();
	}

	public TransferOfLicenceSubmitPage clickPreviewAndContinue() {
		APP_LOGS.info("Going to click on preview and continue");
		clickOnButton(this.PreviewAndContinue);
		FunctionUtil.acceptAlertIfAvailable();
        return PageFactory.initElements(driver, TransferOfLicenceSubmitPage.class);
	}

	public boolean isTransferOfLicenceFormPageOpened() {
		APP_LOGS.info("Going tocheck whether navigated to transfer of licence page or not");
		try {
			return AssertionsUtil.isElementPresent(this.FactoryFullName);
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

}
