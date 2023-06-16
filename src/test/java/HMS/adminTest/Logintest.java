package HMS.adminTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HMS.base.TestBase;
import HMS.pages.LoginPage;

public class Logintest extends TestBase {
	
	LoginPage objlog;
	
	public Logintest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialsetup();
		objlog=new LoginPage();
	}
	
	@Test
	public void adminlogintest()
	{
		String Expectedpagetitle="Smart Hospital : Hospital Management System";
		String Actualpagetitle=objlog.getpagetitle();
		Assert.assertEquals(Actualpagetitle, Expectedpagetitle);
		
		Assert.assertTrue(objlog.islogodisplayed());
		
		String Expectedtxt="Admin Login";
		String Actualtxt=objlog.togetlogintxt();
		Assert.assertEquals(Actualtxt, Expectedtxt);
		
		
		objlog.applogin(prop.getProperty("username"), prop.getProperty("password"));
	
		String Expectedprfiletxt="Super Admin";
		String Actualprfiletxt=objlog.profilecheck();
		
		Assert.assertEquals(Actualprfiletxt, Expectedprfiletxt);
		
		objlog.applogout();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
