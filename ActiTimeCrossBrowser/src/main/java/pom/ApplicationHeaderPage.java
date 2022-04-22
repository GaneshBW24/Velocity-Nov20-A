package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {

	@FindBy (xpath = "(//td[@class='navItem relative'])[1]" )
	private WebElement timeTrack;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[2]" )
	private WebElement tasks;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[3]" )
	private WebElement reports;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[4]" )
	private WebElement users;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[5]" )
	private WebElement workShedule;
	
	@FindBy (xpath = "//a[@id='logoutLink']" )
	private WebElement logout;
	
	public ApplicationHeaderPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	public void clickOnTimeTrack()
	{
		timeTrack.click();
	}
	
	public void clickOnTasks()
	{
		tasks.click();
	}
	
	public void clickOnReports()
	{
		reports.click();
	}
	
	public void clickOnUsers()
	{
		users.click();
	}
	
	public void clickOnWorkShedule()
	{
		workShedule.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
}
