package HMS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HMS.Utility.Acitivitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eve;
	public static  Acitivitycapture acp;
	
	//config reader
	
	public TestBase()
	{
		try {
			
		FileInputStream ip=new FileInputStream("./src/main/java/HMS/config/Appconfig.properties");
		prop=new Properties();
		prop.load(ip);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//inital setup
	
	public static void initialsetup()
	{
		String browsername=prop.getProperty("browser");
		String headless=prop.getProperty("headlessmode");
		if(browsername.equals("chrome"))
		{
			ChromeOptions copt=new ChromeOptions();
			if(headless.equals("true"))
			{
				
				copt.addArguments("--headless");
				copt.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(copt);
				
			}else
			{
				copt.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(copt);
				
			}
			
		}
		else if(browsername.equals("firefox"))
		{
			
			driver=new FirefoxDriver();
			
		}else if(browsername.equals("edge"))
		{
			
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Incorrect browser Name: "+browsername);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	   eve=new EventFiringWebDriver(driver);
	   acp=new Acitivitycapture();
	   eve.register(acp);
	   driver=eve;
		
		
			
	}
	
	public static void Waitfor(WebElement el)
	{
		
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(70));
		wt.until(ExpectedConditions.visibilityOf(el));
	}
	
	
	
	
	

}
