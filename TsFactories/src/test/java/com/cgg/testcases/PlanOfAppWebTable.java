package com.cgg.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.OfficerLoggedinPage;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
import com.cgg.util.WaitUtil;

public class PlanOfAppWebTable extends TestBase {
	private WebDriver driver;

	private WebElement successMessage=null;
	private WebElement updateButton=null;

  @Test
  public void PlanOfApproval() throws Exception  {
		driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
		 HomePage home=PageFactory.initElements(driver,HomePage.class);
		 OfficerLoggedinPage	lp= home.officerlogin("DOF","guest");
		 //Thread.sleep(4000);

		 driver.findElement(By.xpath("html/body/div[1]/div[2]/center/div[2]/div/div[2]/div/a/div/span[1]")).click(); 
		 
		 //click on Regestration and grant of licence
		//driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr/td[4]/a[1]")).click();
		
	new Select(driver.findElement(By.xpath("//select[@id='appFrom']"))).selectByIndex(1);

	driver.findElement(By.xpath(".//*[@id='dynamic-table_filter']/label/input")).sendKeys("Adilabad");
	driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr/td[4]/a[1]")).click();

	driver.findElement(By.xpath(".//*[@id='dynamic-table_filter']/label/input")).sendKeys("FRL2016111565");
	driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr/td[8]/abbr/button")).click();
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath("//select[@id='status']"))).selectByIndex(1);
	//Thread.sleep(3000);
	driver.findElement(By.name(".//*[@id='remarks']")).sendKeys("Khammam");
	//Thread.sleep(3000);
	updateButton=driver.findElement(By.xpath(".//*[@id='form_div']/tbody/tr[37]/td/input[1]"));
	//WaitUtil.waitForElementClickable(updateButton);
	updateButton.click();
	FunctionUtil.acceptAlertIfAvailable();
	successMessage=driver.findElement(By.xpath("html/body/div[1]/div[2]/center/form/table/tbody/tr[1]/td/font"));
	WaitUtil.waitForElementClickable(successMessage);
	AssertionsUtil.isElementPresent(successMessage);

}
}
