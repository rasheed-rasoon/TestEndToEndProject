
package com.cgg.Pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.AmendmentOfLicenseFormPageConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class AmendmentOfLicenseFormPage extends TestBase {

	private WebDriver driver;

	public AmendmentOfLicenseFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=AmendmentOfLicenseFormPageConstants.AMENDMENTOFLICENCEHEADING)
	private WebElement AmendmentOfLicenceHeading;

	@FindBy(xpath=".//*[@id='collapseOne3']/div/table/tbody/tr/td/a")
	private WebElement AmendmentClickOnContinue;

	public void amendmentClickOnContinue()
	{
		APP_LOGS.info("going to click  continue for fill amendment form");
		clickOnButton(this.AmendmentClickOnContinue);
	}


	@FindBy(css = AmendmentOfLicenseFormPageConstants.REGISTRATIONNUMBER)
	private WebElement RegistrationNumber;


	public void sendRegistrationNumber(String registrationNumber) {
		APP_LOGS.info("going to enter Registration number ");
		sendKeysToTextBox(this.RegistrationNumber, registrationNumber);
		clickOnButton(this.ExistingFactoryNameText);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.EXISTINGFACTORYNAMEYES)
	private WebElement ExistingFactoryNameYes;

	public void clickExistingFactoryNameYes() {
		APP_LOGS.info("going to click the radio button Existing factory name as Yes");
		clickOnButton(this.ExistingFactoryNameYes);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.EXISTINGFACTORYNAMETEXT)
	private WebElement ExistingFactoryNameText;



	public void sendExistingFactoryNameText(String existingFactoryNameText) {
		this.ExistingFactoryNameText.clear();
		APP_LOGS.info("going to enter Existing Factory name ");
		sendKeysToTextBox(this.ExistingFactoryNameText, existingFactoryNameText);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.EXISTINGHORSEPOWERYES)
	private WebElement ExistingHorsePowerYes;

	public void clickExistingHorsePowerYes() {
		APP_LOGS.info("going to enter Existing Factory name Horse power");
		clickOnButton(this.ExistingHorsePowerYes);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.REGULARHORSEPOWERVALUE)
	private WebElement RegularHorsePowerValue;

	public void sendRegularHorsePowerValue(String regularHorsePowerValue) {
		this.RegularHorsePowerValue.clear();
		APP_LOGS.info("going to enter Regular horse power");
		sendKeysToTextBox(this.RegularHorsePowerValue, regularHorsePowerValue);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.REGULARHORSEPOWERUNITS)
	private WebElement RegularHorsePowerUnits;

	public void selectRegularHorsePowerUnits(String regularHorsePowerUnits) {
		APP_LOGS.info("going to select Regular horse power units");
		select_Option_In_DropDown_ByVisibleText(this.RegularHorsePowerUnits, regularHorsePowerUnits);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.STANDBYHORSEPOWERVALUE)
	private WebElement StandbyHorsePowerValue;

	public void sendStandbyHorsePowerValue(String standbyHorsePowerValue) {
		APP_LOGS.info("going to enter stand by horse power value");
		sendKeysToTextBox(this.StandbyHorsePowerValue, standbyHorsePowerValue);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.STANDBYHORSEPOWERUNITS)
	private WebElement StandbyHorsePowerUnits;

	public void selectStandbyHorsePowerUnits(String standbyHorsePowerUnits) {
		APP_LOGS.info("going to enter stand by horse power units");
		select_Option_In_DropDown_ByVisibleText(this.StandbyHorsePowerUnits, standbyHorsePowerUnits);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.NOOFWORKERSYES)
	private WebElement NoOfWorkersYes;

	public void clickNoOfWorkersYes() {
		APP_LOGS.info("going to click Radio button Number Of workers chaged or not as Yes");
		clickOnButton(this.NoOfWorkersYes);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.ADULTSMALE)
	private WebElement AdultsMale;

	public void sendAdultsMale(String adultsMale) {
		APP_LOGS.info("going to enter number of Adult male ");
		sendKeysToTextBox(this.AdultsMale, adultsMale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.ADULTSFEMALE)
	private WebElement AdultsFemale;

	public void sendAdultsFemale(String adultsFemale) {
		APP_LOGS.info("going to enter number of Adult Female ");
		sendKeysToTextBox(this.AdultsFemale, adultsFemale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.ADOLESCENTSMALE)
	private WebElement AdolescentsMale;

	public void sendAdolescentsMale(String adolescentsMale) {
		APP_LOGS.info("going to enter number of adolescent male ");
		sendKeysToTextBox(this.AdolescentsMale, adolescentsMale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.ADOLESCENTSFEMALE)
	private WebElement AdolescentsFemale;

	public void sendAdolescentsFemale(String adolescentsFemale) {
		APP_LOGS.info("going to enter number of adolescent Female ");
		sendKeysToTextBox(this.AdolescentsFemale, adolescentsFemale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.CHILDRENMALE)
	private WebElement ChildrenMale;

	public void sendChildrenMale(String childrenMale) {
		APP_LOGS.info("going to enter number of Children male ");
	sendKeysToTextBox(this.ChildrenMale, childrenMale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.CHILDRENFEMALE)
	private WebElement ChildrenFemale;

	public void sendChildrenFemale(String childrenFemale) {
		APP_LOGS.info("going to enter number of Children male ");
		sendKeysToTextBox(this.ChildrenFemale, childrenFemale);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYDOORNO)
	private WebElement FactoryDoorno;

	public void sendFactoryDoorno(String factoryDoorno) {
		APP_LOGS.info("going to enter Factory Door Number ");
		sendKeysToTextBox(this.FactoryDoorno, factoryDoorno);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYLOCALITY)
	private WebElement FactoryLocality;

	public void sendFactoryLocality(String factoryLocality) {
		APP_LOGS.info("going to enter Factory locality details");
		sendKeysToTextBox(this.FactoryLocality, factoryLocality);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYDISTRICT)
	private WebElement FactoryDistrict;

	public void selectFactoryDistrict(String factoryDistrict) {
		APP_LOGS.info("going to select Factory District ");
		select_Option_In_DropDown_ByVisibleText(this.FactoryDistrict, factoryDistrict);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYMANDAL)
	private WebElement FactoryMandal;

	public void selectFactoryMandal(String factoryMandal) {
		APP_LOGS.info("going to select Factory Mandal ");
	select_Option_In_DropDown_ByVisibleText(this.FactoryMandal, factoryMandal);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYVILLAGE)
	private WebElement FactoryVillage;

	public void selectFactoryVillage(String factoryVillage) {
		APP_LOGS.info("going to select Factory Village ");
		select_Option_In_DropDown_ByVisibleText(this.FactoryVillage, factoryVillage);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYPINCODE)
	private WebElement FactoryPincode;

	public void sendFactoryPincode(String factoryPincode) {
		APP_LOGS.info("going to enter Factory Pincode ");
		sendKeysToTextBox(this.FactoryPincode, factoryPincode);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.FACTORYCOMMUNICATIONADDRESS)
	private WebElement FactoryCommunicationAddress;

	public void sendFactoryCommunicationAddress(String factoryCommunicationAddress) {
		APP_LOGS.info("going to select Factory Communication address ");
		sendKeysToTextBox(this.FactoryCommunicationAddress, factoryCommunicationAddress);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANUFACTURINGPROCESSMAIN)
	private WebElement ManufacturingProcessMain;

	public void sendManufacturingProcessMain(String manufacturingProcessMain) {
		APP_LOGS.info("going to enter Manufacturing process main");
		sendKeysToTextBox(this.ManufacturingProcessMain, manufacturingProcessMain);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANUFACTURINGPROCESSSECONDARY)
	private WebElement ManufacturingProcessSecondary;

	public void sendManufacturingProcessSecondary(String manufacturingProcessSecondary) {
		APP_LOGS.info("going to enter manufacturing process Secondary ");
	sendKeysToTextBox(this.ManufacturingProcessSecondary, manufacturingProcessSecondary);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.REFERENCEPLANS)
	private WebElement ReferencePlans;

	public void sendReferencePlans(String referencePlans) {
		APP_LOGS.info("going to enter Reference Plans ");
		sendKeysToTextBox(this.ReferencePlans, referencePlans);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERFULLNAME)
	private WebElement ManagerFullName;

	public void sendManagerFullName(String managerFullName) {
		APP_LOGS.info("going to enter Manager Full name ");
		sendKeysToTextBox(this.ManagerFullName, managerFullName);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERMOBILENUMBER)
	private WebElement ManagerMobileNumber;

	public void sendManagerMobileNumber(String managerMobileNumber) {
		APP_LOGS.info("going to select Manager Mobile Number ");
		sendKeysToTextBox(this.ManagerMobileNumber, managerMobileNumber);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGEREMAILID)

	private WebElement ManagerEmailId;

	public void sendManagerEmailId(String managerEmailId) {
		APP_LOGS.info("going to select Manager EmailId ");
	sendKeysToTextBox(this.ManagerEmailId, managerEmailId);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERDOORNO)
	private WebElement ManagerDoorno;

	public void sendManagerDoorno(String managerDoorno) {
		APP_LOGS.info("going to select Manager Doorno ");
	sendKeysToTextBox(this.ManagerDoorno, managerDoorno);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERLOCALITY)
	private WebElement ManagerLocality;

	public void sendManagerLocality(String managerLocality) {
		APP_LOGS.info("going to select Manager Locality ");
		sendKeysToTextBox(this.ManagerLocality, managerLocality);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERDISTRICT)
	private WebElement ManagerDistrict;

	public void selectManagerDistrict(String managerDistrict) {
		APP_LOGS.info("going to select Manager District ");
	select_Option_In_DropDown_ByVisibleText(this.ManagerDistrict, managerDistrict);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERMANDAL)
	private WebElement ManagerMandal;

	public void selectManagerMandal(String managerMandal) {
		APP_LOGS.info("going to select Manager Mandal ");
		select_Option_In_DropDown_ByVisibleText(this.ManagerMandal, managerMandal);
	}

	@FindBy(css = AmendmentOfLicenseFormPageConstants.MANAGERVILLAGE)
	private WebElement ManagerVillage;

	public void selectManagerVillage(String managerVillage) {
		APP_LOGS.info("going to select Manager Village ");
		select_Option_In_DropDown_ByVisibleText(this.ManagerVillage, managerVillage);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.MANAGERPINCODE)
	private WebElement ManagerPincode;

	public void sendManagerPincode(String managerPincode) {
		APP_LOGS.info("going to select Manager Pincode ");
		sendKeysToTextBox(this.ManagerPincode, managerPincode);
		
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERDATE)
	private WebElement OccupierDate;

	public void dateOccupierDate() throws Exception {
		APP_LOGS.info("going to Pick Date of occupation of the factory by the occupier");
		clickOnButton(this.OccupierDate);
		FunctionUtil.acceptAlertIfAvailable();
		FunctionUtil.datePicker();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERFULLNAME)
	private WebElement OccupierFullName;

	public void sendOccupierFullName(String occupierFullName) {
		APP_LOGS.info("going to enter occupier Full Name");
	 sendKeysToTextBox(this.OccupierFullName, occupierFullName);
	}

	@FindBy(xpath=AmendmentOfLicenseFormPageConstants.OCCUPIERMOBILENUMBER)
	private WebElement OccupierMobileNumber;

	public void sendOccupierMobileNumber(String occupierMobileNumber) {
		APP_LOGS.info("going to enter occupier Mobile Number");
		sendKeysToTextBox(this.OccupierMobileNumber, occupierMobileNumber);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIEREMAILID)
	private WebElement OccupierEmailId;

	public void sendOccupierEmailId(String occupierEmailId) {
		APP_LOGS.info("going to enter occupier Email Id");
		sendKeysToTextBox(this.OccupierEmailId, occupierEmailId);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERDOORNO)
	private WebElement OccupierDoorno;

	public void sendOccupierDoorno(String occupierDoorno) {
		APP_LOGS.info("going to enter occupier Door Number");
		sendKeysToTextBox(this.OccupierDoorno, occupierDoorno);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERLOCALITY)
	private WebElement OccupierLocality;

	public void sendOccupierLocality(String occupierLocality) {
		APP_LOGS.info("going to enter occupier Locality");
		sendKeysToTextBox(this.OccupierLocality, occupierLocality);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERDISTRICT)
	private WebElement OccupierDistrict;

	public void selectOccupierDistrict(String occupierDistrict) {
		APP_LOGS.info("going to select occupier District");
		select_Option_In_DropDown_ByVisibleText(this.OccupierDistrict, occupierDistrict);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERMANDAL)
	private WebElement OccupierMandal;

	public void selectOccupierMandal(String occupierMandal) {
		APP_LOGS.info("going to select occupier Mandal");
		select_Option_In_DropDown_ByVisibleText(this.OccupierMandal, occupierMandal);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERVILLAGE)
	private WebElement OccupierVillage;

	public void selectOccupierVillage(String occupierVillage) {
		APP_LOGS.info("going to select occupier Village");
		select_Option_In_DropDown_ByVisibleText(this.OccupierVillage, occupierVillage);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OCCUPIERPINCODE)
	private WebElement OccupierPincode;

	public void sendOccupierPincode(String occupierPincode) {
		APP_LOGS.info("going to enter occupier Pin code");
		sendKeysToTextBox(this.OccupierPincode, occupierPincode);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.POSITIONINTHECOMPANY)
	private WebElement PositionInTheCompany;

	public void sendPositionInTheCompany(String positionInTheCompany) {
		APP_LOGS.info("going to enter occupier Position in the company");
	sendKeysToTextBox(this.PositionInTheCompany, positionInTheCompany);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERFULLNAME)
	private WebElement OwnerFullname;

	public void sendOwnerFullname(String ownerFullname) {
		APP_LOGS.info("going to enter occupier Position in the company");
		sendKeysToTextBox(this.OwnerFullname, ownerFullname);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERMOBILENUMBER)
	private WebElement OwnerMobileNumber;

	public void sendOwnerMobileNumber(String ownerMobileNumber) {
		APP_LOGS.info("going to enter owner Mobile Number");
		sendKeysToTextBox(this.OwnerMobileNumber, ownerMobileNumber);
		FunctionUtil.acceptAlertIfAvailable();
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNEREMAILID)
	private WebElement OwnerEmailId;

	public void sendOwnerEmailId(String ownerEmailId) {
		APP_LOGS.info("going to enter owner Email Id");
	sendKeysToTextBox(this.OwnerEmailId, ownerEmailId);
		FunctionUtil.acceptAlertIfAvailable();
	}


	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERDOORNO)
	private WebElement OwnerDoorno;

	public void sendOwnerDoorno(String ownerDoorno) {
		APP_LOGS.info("going to enter owner Door Number");
		sendKeysToTextBox(this.OwnerDoorno, ownerDoorno);
	}


	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERLOCALITY)
	private WebElement OwnerLocality;

	public void sendOwnerLocality(String ownerLocality) {
		APP_LOGS.info("going to enter owner Locality");
	sendKeysToTextBox(this.OwnerLocality, ownerLocality);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERDISTRICT)
	private WebElement OwnerDistrict;

	public void selectOwnerDistrict(String ownerDistrict) {
		APP_LOGS.info("going to select owner District");
		select_Option_In_DropDown_ByVisibleText(this.OwnerDistrict, ownerDistrict);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERMANDAL)
	private WebElement OwnerMandal;

	public void selectOwnerMandal(String ownerMandal) {
		APP_LOGS.info("going to select owner Mandal");
select_Option_In_DropDown_ByVisibleText(this.OwnerMandal, ownerMandal);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERVILLAGE)
	private WebElement OwnerVillage;

	public void selectOwnerVillage(String ownerVillage) {
		APP_LOGS.info("going to select owner Village");
		select_Option_In_DropDown_ByVisibleText(this.OwnerVillage, ownerVillage);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.OWNERPINCODE)
	private WebElement OwnerPincode;

	public void sendOwnerPincode(String ownerPincode) {
		APP_LOGS.info("going to enter owner Pincode");
	sendKeysToTextBox(this.OwnerPincode, ownerPincode);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.AMENDMENTYEAR)
	private WebElement AmendmentYear;

	public void selectAmendmentYear(String amendmentYear) {
		APP_LOGS.info("going to pick amendment Year for which amendment is sought ");
		select_Option_In_DropDown_ByVisibleText(this.AmendmentYear, amendmentYear);
		FunctionUtil.acceptAlertIfAvailable();
		
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.BROWSEORIGINALLICENSEFORM)
	private WebElement OriginalLicenseForm;

	public void browseOriginalLicenseForm(String originalLicenseForm) {
		APP_LOGS.info("going to browse Attachment for change in Name of Factory/number of workers and/or change in installed Horse Power  ");
		browseDocument(this.OriginalLicenseForm, originalLicenseForm);
	}

	@FindBy(xpath=AmendmentOfLicenseFormPageConstants.BROWSECHANGEPARTNERSHIORSALEDEED)
	private WebElement BrowseChangePartnerShipOrSaleDeed;

	public void browseChangePartnerShipOrSaleDeed(String refenenveNum) {
		APP_LOGS.info("going to browse Change in Partnership or Sale Deed");
		browseDocument(this.BrowseChangePartnerShipOrSaleDeed, refenenveNum);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.BROWSEREFERENCENUMBER)
	private WebElement ReferenceNumber;

	public void browseReferenceNumber(String refenenveNum) {
		APP_LOGS.info("going to browse Reference number of the latest Plan approved by the Director of Factories ");
	browseDocument(this.ReferenceNumber, refenenveNum);
	}

	@FindBy(xpath = AmendmentOfLicenseFormPageConstants.AMENDMENTPREVIEWANDCONTINUE)
	private WebElement ClickPreviewAndContinueAmendment;

	public AmendmentSubmitPage clickPreviewAndContinue() {
		APP_LOGS.info("going to click Preview and continue ");
		clickOnButton(this.ClickPreviewAndContinueAmendment);
		FunctionUtil.acceptAlertIfAvailable();
		return PageFactory.initElements(driver,AmendmentSubmitPage.class);
	}
	public boolean isAmendmentOfLicenseFormPageOpened()
	{
		try 
		{
			return AssertionsUtil.isElementPresent(this.RegistrationNumber);
		} catch (NoSuchElementException e) 
		{
			return false;
		}
	}	

	@FindBy(xpath=".//*[@id='form1Form']/tbody/tr[19]/td/button[2]")
	private WebElement ClickOnSubmitAmendment;

	@FindBy(xpath=".//*[@id='declaration']")
	private WebElement ClickOnDeclarationAmendment;

	@FindBy(xpath=".//*[@id='paymentTab']/form/table/tbody/tr[6]/td/button")
	private WebElement AmendmentPaymentButton;


//	public boolean isAmendmentPaymentPageOpened() 
//	{
//
//
//	}

	public void clickOnPaymentButton()
	{
		clickOnButton(this.AmendmentPaymentButton);
	}
	public void clickOnDeclarationAmendment()
	{
		clickOnButton(this.ClickOnDeclarationAmendment);
		
	}

	public boolean clickOnSubmitAmendment()
	{
		clickOnButton(this.ClickOnSubmitAmendment);
	   // click on submit  then application will be displayed an alert
		FunctionUtil.acceptAlertIfAvailable(); 
		WaitUtil.waitForElementClickable(this.AmendmentPaymentButton);
		// again click on submit to submit the application 
		return AssertionsUtil.isElementPresent(this.AmendmentPaymentButton);

	}
}
