package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage (WebDriver driver)
	{
		super(driver);//to invoke parent class constructor
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement LnkMyAccount;
	@FindBy(linkText="Register") WebElement LnkRegister ;
	@FindBy(linkText="Login") WebElement LnkLogin ;

	public void ClickMyAccount()
	{
		LnkMyAccount.click();
	}
	public void ClickRegister()
	{
		LnkRegister.click();
	}
	public void ClickLogin()
	{
		LnkLogin.click();
	}
	
}
