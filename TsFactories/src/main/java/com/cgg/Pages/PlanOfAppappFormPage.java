package com.cgg.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cgg.constants.Constant;
import com.cgg.constants.PlanOfAppappFormPageConstants;
import com.cgg.testcases.TestBase;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class PlanOfAppappFormPage extends TestBase{
	private WebDriver driver;

	public PlanOfAppappFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = PlanOfAppappFormPageConstants.CONTINUE)
	private WebElement ClickOnContinue;

	@FindBy(xpath = PlanOfAppappFormPageConstants.FACTORYNAME)
	private WebElement FactoryName;

	@FindBy(xpath = PlanOfAppappFormPageConstants.FACTORYPLANTYPENEW)
	private WebElement FactoryPlanTypeNew;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYDOORNO)
	private WebElement FactoryPlanTypeDoorNo;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYLOCALITY)
	private WebElement FactoryLocality;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYDISTRICT)
	private WebElement FactoryDistrict;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYMANDAL)
	private WebElement FactoryMandal;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYVILLAGE)
	private WebElement FactoryVillage;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALFACTORYPINCODE)
	private WebElement FactoryPincode;

	@FindBy(xpath = PlanOfAppappFormPageConstants.COMMUNICATIONADDRESS)
	private WebElement FactoryCommunicationAddress;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALMOBILENUMBER)
	private WebElement MobileNumber;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALEMAILADDRESS)
	private WebElement EmailAddress;

	@FindBy(xpath = PlanOfAppappFormPageConstants.NOOFWORKERSTOBEEMPLOYEDMEN)
	private WebElement NumberOfWorkersMen;

	@FindBy(xpath = PlanOfAppappFormPageConstants.NOOFWORKERSTOBEEMPLOYEDWOMEN)
	private WebElement NumberOfWorkersWomen;

	@FindBy(xpath = PlanOfAppappFormPageConstants.LISTOFPLANTANDMACHINERY)
	private WebElement ListOfPlantMachinery;

	@FindBy(xpath = PlanOfAppappFormPageConstants.INSTALLEDHORSEPOWER)
	private WebElement InstalledHorsePower;

	@FindBy(xpath = PlanOfAppappFormPageConstants.RAWMATERIALUSEDINMANUFACTURING)
	private WebElement RawMaterialUsed;

	@FindBy(xpath = PlanOfAppappFormPageConstants.MANUFACTURINGPROCESS)
	private WebElement ManufacturingProcess;

	@FindBy(xpath = PlanOfAppappFormPageConstants.FINALPRODUCTS)
	private WebElement FinalProducts;

	@FindBy(xpath = PlanOfAppappFormPageConstants.FINALOUTPUTS)
	private WebElement FinalOutputs;

	@FindBy(xpath = PlanOfAppappFormPageConstants.TYPEANDNATUREOFWASTES)
	private WebElement TypeOfWaste;

	@FindBy(xpath = PlanOfAppappFormPageConstants.EXTENTIONSORADDITIONALINSTALLATIONS)
	private WebElement AdditionsOrExtensions;

	@FindBy(xpath = PlanOfAppappFormPageConstants.SIGNATUREOFOCCUPIERWITHNAMEANDDESIGNATION)
	private WebElement OccupierSign;

	@FindBy(xpath = PlanOfAppappFormPageConstants.TYPEOFINDUSTRYSSI)
	private WebElement IndustryTypeSsi;

	@FindBy(xpath = PlanOfAppappFormPageConstants.TYPEOFINDUSTRYNONSSI)
	private WebElement IndustryTypeNonSsi;

	@FindBy(xpath = PlanOfAppappFormPageConstants.REGISTEREDSALEDEED)
	private WebElement LeaseDeed;

	@FindBy(xpath = PlanOfAppappFormPageConstants.SITEPLAN)
	private WebElement SitePlan;

	@FindBy(xpath = PlanOfAppappFormPageConstants.DETAILEDBUILDINGPLAN)
	private WebElement DetaildedBuildingPlan;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PARTNERSHIPDEED)
	private WebElement PartnershipDeed;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PROCESSFLOWCHART)
	private WebElement ProcessFlowChart;

	@FindBy(xpath = PlanOfAppappFormPageConstants.COPYOFPANCARDAADHARCARD)
	private WebElement CopyOfPan;

	@FindBy(xpath = PlanOfAppappFormPageConstants.SSICERTIFICATEISSUEDBYDIC)
	private WebElement SsiCertificate;

	@FindBy(xpath = PlanOfAppappFormPageConstants.PLANOFAPPROVALDECLARATION)
	private WebElement Declaration;

	@FindBy(xpath = PlanOfAppappFormPageConstants.SAVEAPPLICATION)
	private WebElement SaveApplication;

	@FindBy(xpath = PlanOfAppappFormPageConstants.SUBMITAPPLICATION)
	private WebElement SubmitApplication;

	@FindBy(xpath ="html/body/div[1]/div[2]/center/form/table/tbody/tr[4]/td/button")
	private WebElement clickOnPlanOfApprovalPaymentButton;

	public void clickContinue() {
		APP_LOGS.info("Going to click on Continue");
		this.ClickOnContinue.click();
	}

	public void clickFactoryPlanTypeNew() {
		APP_LOGS.info("Going to click the radio button Factory plan type as New");
		this.FactoryPlanTypeNew.click();
	}
	public void sendFactoryName(String factoryName) {
		APP_LOGS.info("Going to Enter Factory name");
		this.FactoryName.sendKeys(factoryName);
	}

	public void sendFactoryPlanTypeDoorNo(String factoryPlanTypeDoorNo) {
		APP_LOGS.info("Going to enter Factory Door Number");
		this.FactoryPlanTypeDoorNo.sendKeys(factoryPlanTypeDoorNo);

	}

	public void sendFactoryLocality(String factoryLocality) {
		APP_LOGS.info("Going to enter Factory Locality");
		this.FactoryLocality.sendKeys(factoryLocality);

	}

	public void selectFactoryDistrict(String factoryDistrict) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.FactoryDistrict, factoryDistrict);
	}

	public void selectFactoryMandal(String factoryMandal) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.FactoryMandal, factoryMandal);
	}

	public void selectFactoryVillage(String factoryVillage) {
		FunctionUtil.select_Option_In_DropDown_ByVisibleText(this.FactoryVillage, factoryVillage);
	}

	public void sendFactoryPincode(String factoryPincode) {
		APP_LOGS.info("Going to enter Factory pincode");
		this.FactoryPincode.sendKeys(factoryPincode);
	}

	public void sendFactoryCommunicationAddress(String factoryCommunicationAddress) {
		APP_LOGS.info("Going to enter Factory communication address");
		FunctionUtil.acceptAlertIfAvailable();
		this.FactoryCommunicationAddress.sendKeys(factoryCommunicationAddress);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendMobileNumber(String mobileNumber) {
		APP_LOGS.info("Going to enter Mobile Number");
		this.MobileNumber.sendKeys(mobileNumber);
		FunctionUtil.acceptAlertIfAvailable();

	}

	public void sendEmailAddress(String emailAddress){
		APP_LOGS.info("Going to enter Email address");
		this.EmailAddress.sendKeys(emailAddress);
		FunctionUtil.acceptAlertIfAvailable();
	}

	public void sendNumberOfWorkersMen(String numberOfWorkersMen) {
		APP_LOGS.info("Going to enter Number of workers Men");
		FunctionUtil.acceptAlertIfAvailable();
		this.NumberOfWorkersMen.sendKeys(numberOfWorkersMen);
	}

	public void sendNumberOfWorkersWomen(String numberOfWorkersWomen) {
		APP_LOGS.info("Number of workers women");
		FunctionUtil.acceptAlertIfAvailable();
		this.NumberOfWorkersWomen.sendKeys(numberOfWorkersWomen);
	}

	public void browselistOfPlantMachinery(String path) {
		APP_LOGS.info("Going to upload List Of Plant Machinery");
		this.ListOfPlantMachinery.sendKeys(path);
	}

	public void sendInstalledHorsePower(String installedPower) {
		APP_LOGS.info("Going to enter Installed horse power");
		this.InstalledHorsePower.sendKeys(installedPower);
	}

	public void sendRawMaterialUsed(String rawMaterialUsed) {
		APP_LOGS.info("Going to enter list of raw meterials used ");
		this.RawMaterialUsed.sendKeys(rawMaterialUsed);
	}

	public void browseManufacturingProcess(String path) {
		APP_LOGS.info("Going to upload manufacturing process file");
		this.ManufacturingProcess.sendKeys(path);
	}

	public void sendFinalProducts(String finalProducts) {
	APP_LOGS.info("Going to enter Final product details");
		this.FinalProducts.sendKeys(finalProducts);
	}

	public void sendFinalOutputs(String finalOutputs) {
		APP_LOGS.info("Going to enter list of Final output details");
		this.FinalOutputs.sendKeys(finalOutputs);
	}

	public void browseTypeOfWaste(String path) {
		APP_LOGS.info("Going to upload type of waste details");
		this.TypeOfWaste.sendKeys(path);
	}

	public void sendAdditionsOrExtensions(String additionsOrExtensions) {
		APP_LOGS.info("Going to enter additions or extensions");
		this.AdditionsOrExtensions.sendKeys(additionsOrExtensions);
	}

	public void browseOccupierSign(String path) {
		APP_LOGS.info("Going to browse occupier signature ");
		this.OccupierSign.sendKeys(path);
	}

	public void clickIndustryTypeSsi() {
		APP_LOGS.info("Going to click the radio button Industry type as SSI");
		this.IndustryTypeSsi.click();
	}

	public void clickIndustryTypeNonSsi() {
		APP_LOGS.info("Going to click the radio button Industry type as Non SSI");
		this.IndustryTypeNonSsi.click();
	}

	public void browseLeaseDeed(String path) {
		APP_LOGS.info("Going to upload Lease deed details");
		this.LeaseDeed.sendKeys(path);
	}

	public void browseSitePlan(String path) {
		APP_LOGS.info("Going to upload site plan details");
		this.SitePlan.sendKeys(path);
	}

	public void browseDetaildedBuildingPlan(String path) {
		APP_LOGS.info("Going to upload build plan details");
		this.DetaildedBuildingPlan.sendKeys(path);
	}

	public void browsePartnershipDeed(String path) {
		APP_LOGS.info("Going to upload Partnership deed details ");
		this.PartnershipDeed.sendKeys(path);
	}

	public void browseProcessFlowChart(String path) {
		APP_LOGS.info("Going to upload process flow chart details");
		this.ProcessFlowChart.sendKeys(path);
	}

	public void browseCopyOfPan(String path) {
		APP_LOGS.info("Going to upload copy of lan details");
		this.CopyOfPan.sendKeys(path);
	}

	public void browseSsiCertificate(String path) {
		APP_LOGS.info("Going to upload SSI certificate");
		this.SsiCertificate.sendKeys(path);
	}

	public void clickSaveApplication(String path) {
		APP_LOGS.info("Going to click the button save Applcation");
		this.SaveApplication.click();
	}

	public void clickDeclaration() {
		APP_LOGS.info("Going to click on the declaration");
		this.Declaration.click();
	}

	public void clickSubmitApplication() {
		APP_LOGS.info("Going to click click on suabmit button");
		this.SubmitApplication.click();
		FunctionUtil.acceptAlertIfAvailable();
	}
	
	public boolean isPlanOfApprovalPaymentPageOpened()
	{
		APP_LOGS.info("Going to check wheather  navigated to Approval of payment page or not");
		try {
			return AssertionsUtil.isElementPresent(this.clickOnPlanOfApprovalPaymentButton);
		} catch (NoSuchElementException e) {
			
			return false;
		}

	}
	

	public boolean isPlanOfApprovalFormPageOpened()
	{
		try {
			return AssertionsUtil.isElementPresent(this.SubmitApplication);
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	// public PaymentPage PlanApproval_FormFilling() {
	//
	// new Select(Mandal).selectByVisibleText("Adilabad");
	// new Select(Village).selectByVisibleText("Ankapoor");
	//
	// LeaseDeed.sendKeys("Libraries\\Documents\\1.docx");
	// SitePlan.sendKeys("Libraries\\Documents\\1.docx");
	// DetaildedBuildingPlan.sendKeys("Libraries\\Documents\\1.docx");
	// PartnershipDeed.sendKeys("Libraries\\Documents\\1.docx");
	// ProcessFlowChart.sendKeys("Libraries\\Documents\\1.docx");
	// CopyOfPan.sendKeys("Libraries\\Documents\\1.docx");
	// Ssi_certificate.sendKeys("Libraries\\Documents\\1.docx");
	// Declaration.click();
	//
	// return PageFactory.initElements(driver, PaymentPage.class);
	// }

}
