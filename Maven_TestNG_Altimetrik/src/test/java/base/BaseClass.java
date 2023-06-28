package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public  static WebDriver D;
	public  FileInputStream FIS_Properties;
	public  Properties PS;
	
	
	public BaseClass() throws Exception // constructor
	{
		FIS_Properties = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		PS = new Properties();
		PS.load(FIS_Properties);
		
	}
	
	
	@BeforeMethod
	public void setup() throws Exception
	{
		BaseClass obj1 = new BaseClass(); // calling the constructor in order to instantiate variables
		//System.out.println(System.getProperty("user.dir"));
		if(PS.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			D = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			D.get(PS.getProperty("testurl"));
			D.manage().window().maximize();
		}
		
		if(PS.getProperty("browser").equalsIgnoreCase("Edge"))
		{
			D = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			D.get(PS.getProperty("testurl"));
			D.manage().window().maximize();
			
		}
		
		
				
	}

	@AfterMethod
	public void tearDown()
	{
		D.close();
		
	}
	
}
