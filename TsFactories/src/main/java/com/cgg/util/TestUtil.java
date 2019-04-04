package com.cgg.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cgg.util.Xls_Reader;

import com.cgg.testcases.TestBase;

public class TestUtil extends TestBase{



	public static boolean isExecutable(String testname,Xls_Reader xls){

		for(int rowNum=2 ; rowNum<=xls.getRowCount("Test Cases");rowNum++){

			if(xls.getCellData("Test Cases", "TCID", rowNum).equals(testname)){

				if(xls.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))

					return true;
				else
					return false;
			}
		}

		return true;
	}

	// update results for a particular data set	
	public static void reportDataSetResult(Xls_Reader xls, String testCaseName, int rowNum,String result){	
		xls.setCellData(testCaseName, "Results", rowNum, result);
	}

	public static Object[][] getData(String testName,Xls_Reader xls){
		// find the row num from which test starts
		// number of cols in the test
		// number of rows
		// put the data in hastable and put hastable in array

		int testStartRowNum=0;
		// find the row num from which test starts
		for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
			if(xls.getCellData("Test Data", 0, rNum).equals(testName)){
				testStartRowNum=rNum;
				break;
			}
		}
		System.out.println("Test "+ testName +" starts from "+ testStartRowNum);

		int colStartRowNum=testStartRowNum+1;
		int totalCols=0;
		while(!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")){
			totalCols++;
		}
		System.out.println("Total Cols in test "+ testName + " are "+ totalCols);

		//rows
		int dataStartRowNum=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData("Test Data", 0, dataStartRowNum+totalRows).equals("")){
			totalRows++;
		}
		System.out.println("Total Rows in test "+ testName + " are "+ totalRows);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		// extract data
		Object[][] data = new Object[totalRows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum), xls.getCellData("Test Data", cNum, rNum));
				System.out.print(xls.getCellData("Test Data", cNum, rNum) +" -- ");
			}
			data[index][0]= table;
			index++;
			System.out.println();
		}

		System.out.println("Data Collected Done");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		return data;
	}



	// store screenshots
	public static void takeScreenShot(String fileName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   

	}

 
	/*// make zip of reports
	public static void zip(String filepath){
	 	try
	 	{
	 		File inFolder=new File(filepath);
	 		File outFolder=new File("Reports.zip");
	 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in = null;
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			int count;
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
  }
  out.flush();
  out.close();

}
  catch(Exception e)
  {
	  e.printStackTrace();
  } */

}





