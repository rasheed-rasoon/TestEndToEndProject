//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html
package com.cgg.util;

import java.io.File;
import java.util.Date;

import com.cgg.constants.Constant;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;




public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d= new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(Constant.EXTENT_REPORTS_PATH+fileName, true, DisplayOrder.NEWEST_FIRST);//
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportConfig.xml"));
			
			extent.addSystemInfo("Selenium Version", "2.53.1").addSystemInfo(
					"Environment", "TEST");
		}
		return extent;
	}
	
}
