package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass
{

  @Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)
  public void test_LoginDDT(String email,String password,String exp) 
  {

	  try
	  {
		  logger.info("*** Staring TC_003_LoginDDT Test ***");

	  HomePage hp=new HomePage(driver);
	  hp.ClickMyAccount();
	  logger.info("Clicked on MyAccount link");
	  hp.ClickLogin();
	  logger.info("Clicked on Login Link");

	  LoginPage lp=new LoginPage(driver);
	  
	  logger.info("Providing login details");
	  lp.setEmail(email);
	  lp.setPassword(password);
	  lp.clickLogin();
	  
	  logger.info("Validating expected message ");
	  MyAccountPage myacc=new MyAccountPage(driver);
	  boolean targetPage=myacc.chkMessage();
	  if(exp.equals("Valid"))
	  {
		  if(targetPage==true)
		  {
			  myacc.clickLogout();
			 Assert.assertTrue(true);
		  }
		  else
		  {
				 Assert.assertTrue(false);
			  
		  }
			  
	  }
	  if(exp.equals("Invalid"))
	  {
		  if(targetPage==true)
		  {
			  myacc.clickLogout();
			 Assert.assertTrue(false);
		  }
		  else
		  {
				 Assert.assertTrue(true);
			  
		  }
			  
	  }
	  }
	  catch(Exception e)
	  {
		  Assert.fail();
	  }
	  logger.info("*** finished TC_003_LoginDDT Test ***");



  }
}
