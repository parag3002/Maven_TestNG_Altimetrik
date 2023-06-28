package utility;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class takeSS extends BaseClass
{

	public takeSS() throws Exception
	{
		
	}

	//@Test
	public void ScreenShot() throws Exception
	{
		Date SSDate = new Date();
		String ssFileName = SSDate.toString().replace(" ", "_").replace(":", "_");
		File screenshotFile = ((TakesScreenshot) D).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\test-output\\\\ScreenShot\\" + ssFileName + ".png"));
		//FileUtils.copyFile(screenshotFile, new File("D:\\Workspaces_Ecplise\\Altimetrik_Automation\\Maven_TestNG_Altimetrik\\test-output\\ScreenShot\\"+ssFileName+".png"));
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\test-output\\ScreenShot\\"+ssFileName+".png"));
		
		
	
	}
	
	
}
