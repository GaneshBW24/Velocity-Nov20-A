package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationLoginPage {

	@FindBy (xpath = "//input[@id='username']" )
	private WebElement userName;
	
	@FindBy (xpath = "//input[@name='pwd']" )
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='checkbox']" )
	private WebElement keepMeLoginCheckBox;
	
	@FindBy (xpath = "//a[@id='loginButton']" )
	private WebElement logIn;
	
	@FindBy (xpath = "//a[@id='loginButton']" )
	private WebElement logInButton;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationLoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 20); //yachi garaj nahi pan asach samjun ghene 
	}										// sathi apply kele (Explicit Wait)
	
	public void sendUserName()
	{
		userName.sendKeys("admin");
	}
	
	public void sendPassword()
	{
		password.sendKeys("manager");
	}
	
	public void clickOnKeepMeLoginCheckBox()
	{
		wait = new WebDriverWait(driver,30);
		keepMeLoginCheckBox.click();
	}
	
	public void clickOnLogIn()
	{
		wait.until(ExpectedConditions.visibilityOf(logIn));
		logIn.click();
		//actions.moveToElement(logIn).click().build().perform();
	}
}
