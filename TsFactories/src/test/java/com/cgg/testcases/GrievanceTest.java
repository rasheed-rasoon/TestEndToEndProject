package com.cgg.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cgg.Pages.GrievanceHomePages;
import com.cgg.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class GrievanceTest extends TestBase{
@Test(dataProvider="getData")
	
	public void testLogin(Hashtable <String,String>data) throws Exception{
		test=report.startTest("Testing Grievance functionality");
		
		if(!TestUtil.isExecutable(this.getClass().getSimpleName(), xls)|| data.get("Runmode").equalsIgnoreCase("N"))
			throw new SkipException("Skipping the Test Case Number");

		driver.get("http://testghmc.cgg.gov.in/IGRS/citizen.aspx");
		test.log(LogStatus.INFO,"navigated to url");
		

		GrievanceHomePages home=PageFactory.initElements(driver,GrievanceHomePages.class);
		home.sendCitizenName(data.get("citizenName"));
		home.sendMobNum(data.get("mobNum"));
		home.sendLocality(data.get("PartialLocality"),data.get("fullLocality"));
		home.sendLandmark(data.get("landmark"));
		home.selectCategory(data.get("category"));
		home.selectSubCategory(data.get("subCategory"));
		home.sendGrievanceDescription(data.get("grievanceDescription"));
		home.clickSubmit();
		if(data.get("DataFlag").equalsIgnoreCase("P")){
			Assert.assertTrue(home.iscitizenAppSubmittedSuccessfully(),"submitted succesfully");
		}else
			if(data.get("DataFlag").equalsIgnoreCase("P")){
				Assert.assertTrue(!home.iscitizenAppSubmittedSuccessfully(),"not submitted succesfully");
			}
		
		
		

	}




	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData(this.getClass().getSimpleName(),xls);
	}

}
