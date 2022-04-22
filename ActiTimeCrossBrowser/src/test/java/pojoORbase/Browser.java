package pojoORbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\Lenovo\\Downloads\\exeFile's\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		System.out.println("Edge Browser");
		return driver;
	}
	
	public static WebDriver launchOperaBrowser() {
		System.setProperty("webdriver.opera.driver", 
				"C:\\Users\\Lenovo\\Downloads\\exeFile's\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		System.out.println("Opera Browser");
		return driver;
	}
	
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Lenovo\\Downloads\\exeFile's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser");
		return driver;
	}
}
