package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.TestBase;

public class FrontofficePage extends TestBase {
	
	@FindBy(css="ul.sidebar-menu>li")WebElement fomenu;
    @FindBy(css="h3.box-title")WebElement fotabletitle;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement vistorbk;
	
	public FrontofficePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonfomenu()
	{
		fomenu.click();
	}
	
	public String  gettabletitle()
	{
		return fotabletitle.getText();		
	}
	
	public void clickonvistorbook()
	{
		vistorbk.click();
	}
	
	
	
	
}
