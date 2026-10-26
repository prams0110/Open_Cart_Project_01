package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\TestData\\OpenCart_TestData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getrowcount("Sheet1");
		int totalcols = xlutil.getcellcount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; //created a 2 dimensional array to read rows and cols
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j] = xlutil.getcelldata("Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
