package com.cgg.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;

public class EntreprenuerDashboard extends TestBase {
	private static WebElement districtTable=null;
	private static String appNumber=null;
	

	@Test
	public void  getApNumEntreprenuerLogin()  {

		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		HomePage home=PageFactory.initElements(driver,HomePage.class);
		EntreprenuerLoggedinPage    lp= home.Entreprenuerlogin("rasheed","R@sheed66");
		System.out.println("previous application number is "+appNumber);
		districtTable=driver.findElement(By.xpath("html/body/div[1]/div[2]/center/table/tbody/tr[2]/td/table"));

		List<WebElement> rows=districtTable.findElements(By.tagName("tr"));
		outerloop:
			for(int i=0;i<rows.size();i++)
			{
				List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<cells.size();j++)
				{
					if(cells.get(j).getText().equals("Payment Done")&&cells.get(j+1).getText().equals("Pre-Scrutiny-Pending"))
					{
						System.out.println("updated application number is "+cells.get(j-3).getText());
						appNumber=cells.get(j-3).getText();
						break outerloop;               
					}
				}
			}
		//lp.doLogout();
		


	}




}
