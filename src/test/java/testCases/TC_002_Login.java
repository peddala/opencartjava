package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	
	@Test(groups={"Sanity","Master"})
	public void test_login()
	{
		  logger.info("*** Staring TC_002_Login Test ***");
		  try
		  {
		  HomePage hp=new HomePage(driver);
		  hp.ClickMyAccount();
		  logger.info("Clicked on MyAccount link");
		  hp.ClickLogin();
		  logger.info("Clicked on Login Link");

		  LoginPage lp=new LoginPage(driver);
		  
		  logger.info("Providing login details");
		  lp.setEmail(rb.getString("email"));//get it from config.properties file
		  lp.setPassword(rb.getString("password"));//get it from config.properties file
		  lp.clickLogin();
		  logger.info("Validating expected message ");
		  MyAccountPage myacc=new MyAccountPage(driver);
		  Assert.assertEquals(myacc.chkMessage(),true,"Invalid dogin data/Test failed");
		  }
		  catch(Exception e)
		  {
			  logger.error("Invalid dogin data/Test failed");
				Assert.fail();	
		  }
			logger.info("*** Finished TC_002_Login Test ***");


		
	}

}
