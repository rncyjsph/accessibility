package codemantra.ADH.util;

import java.util.ArrayList;

public class Utility {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader("src/test/java/sample/testdata.xlsx");
		}catch(Exception e)
		{
		}
		
		for (int rownum=2;rownum<=reader.getRowCount("Sheet1");rownum++)
		{
			String firstname=reader.getCellData("Sheet1", "firstname", rownum);
			String lastname=reader.getCellData("Sheet1", "lastname", rownum);
			String email=reader.getCellData("Sheet1", "email", rownum);
			String password=reader.getCellData("Sheet1", "password", rownum);
			//store all these in object array
			
			Object ob[]= {firstname,lastname,email,password}; //object array
			mydata.add(ob); //pass the object array to arraylist
		}
		
		
	
return mydata;
}
}