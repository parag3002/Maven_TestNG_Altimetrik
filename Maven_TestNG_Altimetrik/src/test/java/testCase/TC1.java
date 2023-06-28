package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import base.*;
import utility.*;


public class TC1 extends BaseClass
{
	Locators_ALL L;
	takeSS screenShot1;
	
	TC1() throws Exception // constructor
	{
		L = new Locators_ALL(); //  to instantiate locators class
		screenShot1 = new takeSS();
	}
	
	@Test(dataProviderClass = readDataExcel.class , dataProvider = "ExcelData1" , priority = 1)
	public void display(String userName , String Pass) throws Exception
	{
		
		
		D.findElement(By.xpath(L.sauceDemo_UserName)).sendKeys(userName);
		D.findElement(By.xpath(L.sauceDemo_pass)).sendKeys(Pass);
		screenShot1.ScreenShot();
		D.findElement(By.xpath(L.sauceDemo_LoginCTA)).click();
		
		Thread.sleep(1000);
		//AA // BB
		
		
		
		
	}
}
