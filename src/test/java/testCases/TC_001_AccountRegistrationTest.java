package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"Master","Regression"})
	void test_Account_Registraion() 
	{
		logger.info("*** Strating TC_001_AccountRegistrationTest ***");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.ClickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.ClickRegister();
			logger.info("Clicked on Register link");

			AccountRegistrationPage ar=new AccountRegistrationPage(driver);
			logger.info("Providing customer details");

			ar.SetFirstName(randomeString().toUpperCase());
			ar.SetLastName(randomeString().toUpperCase());
			ar.SetEmail(randomeString()+"@gmail.com");
			ar.SetTelephone(randomeNumber());
			ar.Setpassword("hello123");
			ar.SetConfirmpassword("hello123");
			ar.ClickPrivacyPolicy();
			ar.ClickOnContinue();
			logger.info("Clicked on continue button");
			logger.info("Validating expected message");

			Assert.assertEquals(ar.CheckCofirmMsg(),"Your Account Has Been Created!","Test failed");
		}
		catch(Exception e) 
		{
			logger.error("Test failed");
			Assert.fail();	
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");

		
	}
}
