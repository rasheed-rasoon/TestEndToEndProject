package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.Constant;
import com.cgg.constants.RegGrantOfLicenseConstants;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class RegAndLicenceAppForm {
	private WebDriver driver;

	public RegAndLicenceAppForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='collapseOne3']/div/table/tbody/tr/td/a")
	private WebElement ClickOnProceed;

	@FindBy(id = RegGrantOfLicenseConstants.FACTORYFULLNAME)
	private WebElement Factoryfullname;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYDOORNO)
	private WebElement Factorydoorno;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYLOCALITY)
	private WebElement Factorylocality;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYDISTRICT)
	private WebElement Factorydistrict;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYMANDAL)
	private WebElement Factorymandal;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYVILLAGE)
	private WebElement Factoryvillage;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYPINCODE)
	private WebElement Factorypincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYFULLPOSTALADDRESS)
	private WebElement Factoryfullpostaladdress;

	@FindBy(xpath = RegGrantOfLicenseConstants.NATUREOFMANUFACTRINGPROCESS_MAIN)
	private WebElement Natureofmanufacturingprocessmain;

	@FindBy(xpath = RegGrantOfLicenseConstants.NATUREOFMANUFACTRINGPROCESS_SECONDARY)
	private WebElement Natureofmanufacturingprocesssecondary;

	@FindBy(xpath = RegGrantOfLicenseConstants.REGULARHORSEPOWER_VALUE)
	private WebElement Regularhorsepowervalue;

	@FindBy(xpath = RegGrantOfLicenseConstants.REGULARHORSEPOWER_UNITS)
	private WebElement Regularhorsepowerunits;

	@FindBy(xpath = RegGrantOfLicenseConstants.STANDBYHORSEPOWER_VALUE)
	private WebElement Standbyhorsepowervalue;

	@FindBy(xpath = RegGrantOfLicenseConstants.STANDBYHORSEPOWER_UNITS)
	private WebElement Standbyhorsepowerunits;

	@FindBy(xpath = RegGrantOfLicenseConstants.ADULTMALE)
	private WebElement Adultmale;

	@FindBy(xpath = RegGrantOfLicenseConstants.ADULTFEMALE)
	private WebElement Adultfemale;

	@FindBy(xpath = RegGrantOfLicenseConstants.ADOLESCENTSMALE)
	private WebElement Adolescentsmale;

	@FindBy(xpath = RegGrantOfLicenseConstants.ADOLESCENTSFEMALE)
	private WebElement Adolescentsfemale;

	@FindBy(xpath = RegGrantOfLicenseConstants.CHILNDRENMALE)
	private WebElement Childrenmale;

	@FindBy(xpath = RegGrantOfLicenseConstants.CHILNDRENFEMALE)
	private WebElement Childrenfemale;

	@FindBy(xpath = RegGrantOfLicenseConstants.REFERENCEBYCHIEFINSPECTOR)
	private WebElement Referencebychiefinspector;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERFULLNAME)
	private WebElement Managerfullname;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERMOBILENUMBER)
	private WebElement Managermobilenumber;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGEREMAILID)
	private WebElement Managermailid;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERDOORNO)
	private WebElement Managerdoorno;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERLOCALITY)
	private WebElement Managerlocality;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERDISTRICT)
	private WebElement Managerdistrict;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERMANDAL)
	private WebElement Managermandal;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERVILLAGE)
	private WebElement Managervillage;

	@FindBy(xpath = RegGrantOfLicenseConstants.MANAGERPINCODE)
	private WebElement Managerpincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.FACTORYOCCUPATIONDATE)
	private WebElement Factoryoccupationdate;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERFULLNAME)
	private WebElement Occupierfullname;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERMOBILENUMBER)
	private WebElement Occupiermobilenumber;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIEREMAILID)
	private WebElement Occupiermailid;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERDOORNO)
	private WebElement Occupierdoorno;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERLOCALITY)
	private WebElement Occupierlocality;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERSTATE)
	private WebElement Occupierstate;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERDISTRICT)
	private WebElement Occupierdistrict;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERMANDAL)
	private WebElement Occupiermandal;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERVILLAGE)
	private WebElement Occupiervillage;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERPINCODE)
	private WebElement Occupierpincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIERPOSITIONINCOMPANY)
	private WebElement Occupierpositionincompany;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIEROTHERSTATENAME)
	private WebElement Occupierotherstatename;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIEROTHERSTATEPOSTALADDRESS)
	private WebElement Occupierotherstatepostaladdress;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCCUPIEROTHERSTATEPINCODE)
	private WebElement Occupierotherstatepincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERFULLNAME)
	private WebElement Ownerfullname;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERMOBILENUMBER)
	private WebElement Ownermobilenumber;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNEREMAILID)
	private WebElement Owneremailid;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERDOORNO)
	private WebElement Ownerdoorno;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERLOCALAITY)
	private WebElement Ownerlocality;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERSTATE)
	private WebElement Ownerstate;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERDISRICT)
	private WebElement Ownerdistrict;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERMANDAL)
	private WebElement Ownermandal;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNERVILLAGE)
	private WebElement Ownervillage;

	@FindBy(id = RegGrantOfLicenseConstants.OWNERPINCODE)
	private WebElement Ownerpincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNEROTHERSTATENAME)
	private WebElement Ownerotherstatename;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNEROTHERSTATEPOSTALADDRESS)
	private WebElement Ownerotherstatepostaladdress;

	@FindBy(xpath = RegGrantOfLicenseConstants.OWNEROTHERSTATEPINCODE)
	private WebElement Ownerotherstatepincode;

	@FindBy(xpath = RegGrantOfLicenseConstants.LICENCEYEARS)
	private WebElement Licenseyears;

	@FindBy(xpath = RegGrantOfLicenseConstants.TYPEOFFACTORY)
	private WebElement Typeoffactory;

	@FindBy(xpath = RegGrantOfLicenseConstants.PROPOSEDINVENTORIESOFCHEMICALS)
	private WebElement ProposedInventoriesOfChemicals;

	@FindBy(xpath = RegGrantOfLicenseConstants.LISTOFPARTNERSDIRECTORS)
	private WebElement ListOfPartnersAndDirectors;

	@FindBy(xpath = RegGrantOfLicenseConstants.PARTNERSHIPDEED)
	private WebElement PartnershipDeed;

	@FindBy(xpath = RegGrantOfLicenseConstants.LANDOWNERSHIPDOCUMENTS)
	private WebElement LandOwnerShipDocuments;

	@FindBy(xpath = RegGrantOfLicenseConstants.OCUPIERPHOTOID)
	private WebElement OccupierPhotoId;

	@FindBy(xpath = RegGrantOfLicenseConstants.REFERENCEBYDIRECTORIES)
	private WebElement ReferenceByDirectories;

	@FindBy(xpath = RegGrantOfLicenseConstants.PREVIEWANDCONTINUE)
	private WebElement PreviewAndContinue;

	public void buttonClickOnProceed() {
		this.ClickOnProceed.click();
	}

	public void sendFactoryFullName(String factFullName) {
		this.Factoryfullname.sendKeys(factFullName);
	}

	public void sendFactoryDoorNo(String factDoorNo) {
		this.Factorydoorno.sendKeys(factDoorNo);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendFactoryLocality(String factLocality) {
		this.Factorylocality.sendKeys(factLocality);
	}

	public void selectFactoryDistrict(String factDistrict) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Factorydistrict, factDistrict);
	}

	public void selectFactoryMandal(String factMandal) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Factorymandal, factMandal);
	}

	public void selectFactoryVillage(String factVillage) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Factoryvillage, factVillage);
	}

	public void sendFactoryPincode(String factPincode) {
		this.Factorypincode.sendKeys(factPincode);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendFactoryFullPostalAddress(String factFullPostalAddress) {
		this.Factoryfullpostaladdress.sendKeys(factFullPostalAddress);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendNatureOfManufacturingProcessMain(String natureOfManufacProcessMain) {
		this.Natureofmanufacturingprocessmain.sendKeys(natureOfManufacProcessMain);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendNatureOfManufacturingProcessSecondary(String natureOfManufacProcessSecondary) {
		this.Natureofmanufacturingprocesssecondary.sendKeys(natureOfManufacProcessSecondary);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendRegularHorsePowerValue(String regHorsePowerValue) {
		this.Regularhorsepowervalue.sendKeys(regHorsePowerValue);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectRegularHorsePowerUnits(String RegHorsePowerUnits) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Regularhorsepowerunits, RegHorsePowerUnits);
	
	}

	public void sendStandbyHorsePowerValue(String StandHorsePowerValue) {
		this.Standbyhorsepowervalue.clear();
		FunctionUtil.acceptAlertIfAvailable();
		this.Standbyhorsepowervalue.sendKeys(StandHorsePowerValue);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectStandbyHorsePowerUnits(String StandHorsePowerUnits) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Standbyhorsepowerunits, StandHorsePowerUnits);
	}

	public void sendWorkersAdultMaleCount(String adulMale) {
		FunctionUtil.acceptAlertIfAvailable();
		this.Adultmale.sendKeys(adulMale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendWorkersAdultFeMaleCount(String AdulFemale) {
		this.Adultfemale.sendKeys(AdulFemale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendWorkersAdolescentsMaleCount(String AdolesMale) {
		this.Adolescentsmale.sendKeys(AdolesMale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendWorkersAdolescentsFemaleCount(String AdolesFemale) {
		this.Adolescentsfemale.sendKeys(AdolesFemale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendWorkersChildrenMaleCount(String ChildMale) {
		this.Childrenmale.sendKeys(ChildMale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendWorkersChildrenFemaleCount(String ChildFemale) {
		this.Childrenfemale.sendKeys(ChildFemale);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendReferenceByChiefInspector(String RefByChiefInspector) {
		this.Referencebychiefinspector.sendKeys(RefByChiefInspector);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerFullName(String MngrFullName) {
		this.Managerfullname.sendKeys(MngrFullName);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerMobileNumber(String MngrMobileNumber) {
		this.Managermobilenumber.sendKeys(MngrMobileNumber);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerMailId(String MngrMailId) {
		this.Managermailid.sendKeys(MngrMailId);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerDoorNo(String MngrDoorNo) {
		this.Managerdoorno.sendKeys(MngrDoorNo);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendManagerLocality(String MngrLocality) {
		this.Managerlocality.sendKeys(MngrLocality);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectManagerDistrict(String MngrDistrict) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Managerdistrict, MngrDistrict);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectManagerMandal(String MngrMandal) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Managermandal, MngrMandal);
	}

	public void selectManagerVillage(String MngrVillage) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Managervillage, MngrVillage);
		}

	public void sendManagerPincode(String MngrPincode) {
		this.Managerpincode.sendKeys(MngrPincode);
	
	}

	public void picFactoryOccupationDate() throws Exception {
		this.Factoryoccupationdate.click();
		FunctionUtil.acceptAlertIfAvailable();
		FunctionUtil.datePicker();
	}

	public void sendOccupierFullName(String OccuFullName) {
		this.Occupierfullname.sendKeys(OccuFullName);
	}

	public void sendOccupierMobileNumber(String OccuMobileNumber) {
		this.Occupiermobilenumber.sendKeys(OccuMobileNumber);
	}

	public void sendOccupierMailId(String OccuMailId) {
		this.Occupiermailid.sendKeys(OccuMailId);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOccupierDoorNo(String OccuDoorNo) {
		this.Occupierdoorno.sendKeys(OccuDoorNo);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOccupierLocality(String OccuLocality) {
		this.Occupierlocality.sendKeys(OccuLocality);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectOccupierState(String OccuState) {

		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Occupierstate, OccuState);
	}

	public void selectOccupierDistrict(String OccuDistrict) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Occupierdistrict, OccuDistrict);
    }

	public void selectOccupierMandal(String OccuMandal) {

		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Occupiermandal, OccuMandal);
	}

	public void selectOccupierVillage(String OccuVillage) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Occupiervillage, OccuVillage);
		}

	public void sendOccupierPinCode(String OccuPinCode) {
	this.Occupierpincode.sendKeys(OccuPinCode);	
	FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOccupierPositionInCompany(String OccuPositionInCompany) {
		this.Occupierpositionincompany.sendKeys(OccuPositionInCompany);
		FunctionUtil.acceptAlertIfAvailable();

	}

	public void selectOccupierOtherStateName(String OccuOtherStateName) {

		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Occupierotherstatename, OccuOtherStateName);
	}

	public void sendOccupierOtherStatePostalAddress(String OccuOtherStatePostalAddress) {
		this.Occupierotherstatepostaladdress.sendKeys(OccuOtherStatePostalAddress);
	}

	public void sendOccupierOtherStatePincode(String OccuOtherStatePincode) {
		this.Occupierotherstatepincode.sendKeys(OccuOtherStatePincode);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOwnerFullName(String OwnrFullName) {
		this.Ownerfullname.sendKeys(OwnrFullName);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOwnerMobileNumber(String OwnrMobileNumber) {
		this.Ownermobilenumber.sendKeys(OwnrMobileNumber);
	}

	public void sendOwnerEmailId(String OwnrEmailId) {
		this.Owneremailid.sendKeys(OwnrEmailId);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOwnerDoorNo(String OwnrDoorNo) {
		this.Ownerdoorno.sendKeys(OwnrDoorNo);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOwnerLocality(String OwnrLocality) {
		this.Ownerlocality.sendKeys(OwnrLocality);
	}

	public void selectOwnerState(String OwnrState) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Ownerstate, OwnrState);
	}

	public void selectOwnerdistrict(String Ownrdistrict) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Ownerdistrict, Ownrdistrict);
	}

	public void selectOwnerMandal(String OwnrMandal) {

		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Ownermandal, OwnrMandal);
	}

	public void selectOwnerVillage(String OwnrVillage) {

		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Ownervillage, OwnrVillage);
	}

	public void sendOwnerPinCode(String OwnrPinCode) {
		this.Ownerpincode.sendKeys(OwnrPinCode);
	}

	public void selectOwnerOtherStateName(String OwnrOtherStateName) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Ownerotherstatename, OwnrOtherStateName);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendOwnerOtherStatePostalAddress(String OwnrOtherStatePostalAddress) {
		this.Ownerotherstatepostaladdress.sendKeys(OwnrOtherStatePostalAddress);
	}

	public void sendOwnerOtherStatePincode(String OwnrOtherStatePincode) {
		this.Ownerotherstatepincode.sendKeys(OwnrOtherStatePincode);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectLicenseYears(String licenseYrs) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.Licenseyears, licenseYrs); 
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void selectTypeOfFactory(String TypeOfFact) {

		FunctionUtil.select_Option_In_DropDown_ByValue(this.Typeoffactory, TypeOfFact);
	}

	public void browseProposedInventoriesOfChemicls () {
		FunctionUtil.browseDocument(this.ProposedInventoriesOfChemicals,Constant.UPLOAD_FILE_PATH);
	}

	public void browseListOfPartnersAndDirectors() {
		FunctionUtil.browseDocument(this.ListOfPartnersAndDirectors,Constant.UPLOAD_FILE_PATH);
	}

	public void browsePartnershipDeed() {
		FunctionUtil.browseDocument(this.PartnershipDeed,Constant.UPLOAD_FILE_PATH);
		}

	public void browseLandOwnerShipDocuments() {
		FunctionUtil.browseDocument(this.LandOwnerShipDocuments,Constant.UPLOAD_FILE_PATH);
	}

	public void browseOccupierPhotoId() {
		FunctionUtil.browseDocument(this.OccupierPhotoId,Constant.UPLOAD_FILE_PATH);
	}

	public void browseReferenceByDirectories() {
		FunctionUtil.browseDocument(this.ReferenceByDirectories,Constant.UPLOAD_FILE_PATH);
	}

	public RegAndLicenceSubmitPage clickPreviewAndContinue() {
		FunctionUtil.acceptAlertIfAvailable();
		this.PreviewAndContinue.click();
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver, RegAndLicenceSubmitPage.class);

	}

	public boolean isRegistrationFormPageOpened() {
		WaitUtil.waitForElementClickable(Factorydoorno);
		try {
			return AssertionsUtil.isElementPresent(this.PreviewAndContinue);
		} catch (NoSuchElementException e) {
			return false;
		}

	}

}
