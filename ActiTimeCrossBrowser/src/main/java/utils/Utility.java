package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void screenshot (WebDriver driver, String testID) throws IOException {
		
		Date date = new Date ();
		System.out.println(date);
		
		String S = date.toString();
		
		String a = S.replace(':', '-');
		
		System.out.println(a);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	  	File dest = new File("C:\\ProgrammUse\\Test "+ testID + a + ".jpg");
	  	
	  	FileHandler.copy(source, dest);
	  
	}
	

}
