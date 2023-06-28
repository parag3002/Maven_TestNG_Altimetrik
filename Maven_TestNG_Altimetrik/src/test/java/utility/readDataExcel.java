package utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class readDataExcel 

{
	
	public static Properties RPS;
	public static FileInputStream FIS_PS;
	public static FileInputStream FISexcel;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	
	
	public readDataExcel() throws Exception
	{

	
		//FISexcel = new FileInputStream("D:\\Workspaces_Ecplise\\Altimetrik_Automation\\Maven_TestNG_Altimetrik\\src\\test\\resources\\testdata\\testData.xlsx");
		//FIS_PS = new FileInputStream("D:\\Workspaces_Ecplise\\Altimetrik_Automation\\Maven_TestNG_Altimetrik\\src\\test\\resources\\configfiles\\config.properties");
		FISexcel = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testData.xlsx");
		FIS_PS = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
				
		
		workbook = new XSSFWorkbook(FISexcel);
		sheet = workbook.getSheet("LogIn");
		row = sheet.getRow(1);
		RPS = new Properties();
		RPS.load(FIS_PS);
		RPS.getProperty("testDataSheet");
		
	}
	
	@DataProvider(name="ExcelData1") // Providing data to TC1
	public String[][] provideData() throws Exception
	{
		readDataExcel obj = new readDataExcel();
		
		int i,j; int totalRow,totalCol;
		
		totalRow=sheet.getLastRowNum();
		totalCol=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Row-->"+totalRow +" Total Col-->"+totalCol);
		String arr[][] = new String[totalRow][totalCol];
		DataFormatter Format = new DataFormatter();
		
		for(i=1;i<=totalRow;i++)
		{
			
			for(j=0;j<totalCol;j++)
			{
				arr[i-1][j] = Format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
	
		// Just for printing purpose----------
		for(i=1;i<=totalRow;i++)
		{
			
			for(j=0;j<totalCol;j++)
			{
				System.out.print(arr[i-1][j]+" ");
				
			}
			System.out.println();
		}
		
		//System.out.println(row.getCell(1).toString());
		//System.out.println(RPS.getProperty("testDataSheet"));
		
		return arr;
	} // end of DataProvide Method-----------
	
	

	
}
