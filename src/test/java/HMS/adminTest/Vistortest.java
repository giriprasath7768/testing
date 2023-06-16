package HMS.adminTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HMS.Utility.ReadExcel;
import HMS.base.TestBase;
import HMS.pages.FrontofficePage;
import HMS.pages.LoginPage;
import HMS.pages.VistorPage;

public class Vistortest extends TestBase {

	LoginPage objlog;
	FrontofficePage objfo;
	VistorPage objvis;
	
	public Vistortest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialsetup();
		objlog=new LoginPage();
		objfo=new FrontofficePage();
		objlog.applogin(prop.getProperty("username"), prop.getProperty("password"));
		objfo.clickonfomenu();
		objfo.clickonvistorbook();
		objvis=new VistorPage();
	}
	
	@DataProvider
	public Object[][] getvisdata()
	{
		Object[][]visdt=ReadExcel.getTestData("testdata");
		return visdt;
		
	}
	
	@Test(dataProvider="getvisdata")
	public void vistortest(String tsd[])
	{
		String Expectedtabletitle="Visitor List";
		String Actualtabletitlle=objvis.gettabletitle();
		
		Assert.assertEquals(Actualtabletitlle, Expectedtabletitle);
		
		objvis.clickonaddvistor();
		
		String Expectedscreentitle="Add Visitor";
		String Actualscreentitlle=objvis.getscreentitle();
		Assert.assertEquals(Actualscreentitlle, Expectedscreentitle);
		
		objvis.addvistordetails(tsd);
		
		
	}
	
	
	
}
