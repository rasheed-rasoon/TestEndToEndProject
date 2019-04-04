package com.cgg.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cgg.Pages.EntreprenuerLoggedinPage;
import com.cgg.Pages.HomePage;
import com.cgg.Pages.OfficerLoggedinPage;
import com.cgg.util.AssertionsUtil;
import com.cgg.util.FunctionUtil;
public class OfficerDashBoardTest extends TestBase {
//    private WebElement districtTable=null;
//   // public String appNumber=null;
//    private WebElement statusDropDown=null;
//    private String status=null;
    
   @Test()
     public void getApNumEntreprenuerLogin()  {
            driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
             HomePage home=PageFactory.initElements(driver,HomePage.class);
             EntreprenuerLoggedinPage    lp= home.Entreprenuerlogin("rasheed66","R@sheed66");
             //Thread.sleep(4000);

             //driver.findElement(By.xpath("html/body/div[1]/div[2]/center/div[2]/div/div[3]/div/a/div/span[1]")).click();
//System.out.println("previous application number is "+appNumber);
            WebElement  districtTable=driver.findElement(By.xpath("html/body/div[1]/div[2]/center/table/tbody/tr[2]/td/table"));
            
             List<WebElement> rows=districtTable.findElements(By.tagName("tr"));
            
     for(int i=0;i<rows.size();i++)
     {
        List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
                for(int j=0;j<cells.size();j++)
                {
                	System.out.println(cells.get(j).getText());
                    
            }            
                
     }
    
    
  
  

     }
}



//    @Test(enabled=false)
//    public void process() throws Exception
//    {
//    	
//       System.out.println("application number is "+appNumber);
//        driver.get("http://test.cgg.gov.in:8083/tsfactories/home.do");
//         HomePage home=PageFactory.initElements(driver,HomePage.class);
//         OfficerLoggedinPage    lp= home.officerlogin("DOF","guest");
//         driver.findElement(By.xpath("html/body/div[1]/div[2]/center/div[2]/div/div[2]/div/a/div/span[1]")).click();        
//         driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr[32]/td[4]")).click();
//         driver.findElement(By.xpath(".//*[@id='dynamic-table_filter']/label/input")).sendKeys("FRL0006155");
//         driver.findElement(By.xpath(".//*[@id='dynamic-table']/tbody/tr/td[8]/abbr/button")).click();
//         statusDropDown=driver.findElement(By.xpath(".//*[@id='status']"));
//         status="Query";
//         switch(status)
//         {
//         case "Query":
//         FunctionUtil.select_Option_In_DropDown_ByVisibleText(statusDropDown,"Query");
//            driver.findElement(By.name("userProperties(remarks)")).sendKeys("Hyderabad");
//        driver.findElement(By.cssSelector("input[onclick='updateData()']")).click();
//        AssertionsUtil.isElementPresent(driver.findElement(By.xpath("html/body/div[1]/div[2]/center/form/font")));
//       // lp.doOfficerLogout();
//        HomePage home1=PageFactory.initElements(driver,HomePage.class);
//        EntreprenuerLoggedinPage el=home1.Entreprenuerlogin("rasheed","R@sheed66");
//        break;
//        default:System.out.println("invalid statu");
//        break;
//             }
//         }
//}



