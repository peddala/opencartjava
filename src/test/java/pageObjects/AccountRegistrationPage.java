package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public   AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}

	@FindBy(name="firstname") WebElement txtFirstName;
	@FindBy(name="lastname") WebElement txtLastName;
	@FindBy(name="email") WebElement txtEmail;
	@FindBy(name="telephone") WebElement txtTelephone;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="confirm") WebElement txtConfirmPassword;
	@FindBy(name="agree") WebElement chkPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;


	public void SetFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void SetLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void SetEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void SetTelephone(String phone)
	{
		txtTelephone.sendKeys(phone);
	}

	public void Setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void SetConfirmpassword(String confirmpwd)
	{
		txtConfirmPassword.sendKeys(confirmpwd);
	}
	public void ClickPrivacyPolicy()
	{
		chkPolicy.click();
	}
	public void ClickOnContinue()
	{
		btnContinue.click();
	}
	
	public String CheckCofirmMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}


	
}
