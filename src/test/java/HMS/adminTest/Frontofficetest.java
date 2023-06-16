package HMS.adminTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HMS.base.TestBase;
import HMS.pages.FrontofficePage;
import HMS.pages.LoginPage;

public class Frontofficetest extends TestBase {
	
	LoginPage objlog;
	FrontofficePage objfo;
	
	public Frontofficetest()
	{
		super();
	}

	
	@BeforeMethod
	public void setup()
	{
		initialsetup();
		objlog=new LoginPage();
		objlog.applogin(prop.getProperty("username"), prop.getProperty("password"));
		objfo=new FrontofficePage();
	}
	
	@Test
	public void frontTest()
	{
		objfo.clickonfomenu();
		
		String ExpectedTabletitle="Appointment Details";
		String ActualTabletitle=objfo.gettabletitle();
		
		Assert.assertEquals(ExpectedTabletitle,ActualTabletitle);
		
		objfo.clickonvistorbook();
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
}
