package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture
{

	public static void getScreenShot(WebDriver driver) throws IOException
	{
		Date date = new Date();
		String y = String.valueOf(date.getYear());
		String m = String.valueOf(date.getMonth());
		String d = String.valueOf(date.getDay());
		String h = String.valueOf(date.getHours());
		String min = String.valueOf(date.getMinutes());
		String sec = String.valueOf(date.getSeconds());
		
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = "image_"+y+"_"+m+""+d+""+h+"_"+min+""+sec;
		FileUtils.copyFile(srcFile,new File("F:\\Seema\\Screenshots\\"+fileName+".png"));
	}
}