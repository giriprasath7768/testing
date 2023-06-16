package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(tagName="img")WebElement loginlogo;
	@FindBy(css="h3.font-white")WebElement logintxt;
    @FindBy(css="input#email")WebElement username;
    @FindBy(css="input#password")WebElement password;
    @FindBy(css="button.btn")WebElement loginbtn;
    @FindBy(css="img.topuser-image")WebElement profileimg;
    @FindBy(xpath="//h5[text()='Super Admin']")WebElement profiletxt;
    @FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
    
    public LoginPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    //To get pagetitle
    public String getpagetitle()
    {
       return driver.getTitle();	
    }
    
   //To check the logo
    public boolean islogodisplayed()
    {
		return loginlogo.isDisplayed();
    }
    
    //TO get login text
    public String togetlogintxt()
    {
    	return logintxt.getText();
    }
    
    //Login to the app
    public void applogin(String uname,String upass)
    {
    	username.sendKeys(uname);
    	password.sendKeys(upass);
    	loginbtn.click();
    }
    
    //profile check
    public String profilecheck()
    {
    	profileimg.click();
    	return profiletxt.getText();
    }
    
    //logout
    public void applogout()
    {
    	logout.click();
    	
    }
    
}
