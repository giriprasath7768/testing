package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HMS.Utility.Commonutility;
import HMS.Utility.Datepicker;
import HMS.base.TestBase;

public class VistorPage extends TestBase
{
	
	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="a.btn-sm")WebElement addvistorbtn;
	@FindBy(xpath = "//h4[text()=' Add Visitor']")WebElement screentitle;

	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="form#formadd textarea[name='note1']")WebElement note;
	public VistorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettabletitle()
	{
		return tabletitle.getText();
				
	}
	
	public void clickonaddvistor()
	{
		addvistorbtn.click();
	}
	
	public String getscreentitle()
	{
		Waitfor(screentitle);
		return screentitle.getText();
	}
	
	
	public void addvistordetails(String td[])
	{
		Select drp= new Select(purpose);
		drp.selectByVisibleText(td[0]);
		pname.sendKeys(td[1]);
		idpro.sendKeys(td[3]);
		noper.sendKeys(td[5]);
		phno.sendKeys(td[2]);
		note.sendKeys(td[6]);
		datepicker.click();
		Datepicker dt=new Datepicker();
		dt.datpicker(td[4]);
		Commonutility.mouseclick(upfile);
		Commonutility.fileuplload(td[7]);
	}
	
	
	
	
}
