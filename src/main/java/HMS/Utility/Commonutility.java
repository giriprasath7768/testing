package HMS.Utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import HMS.base.TestBase;

public class Commonutility extends TestBase {

	//Mouse click
	public static void mouseclick(WebElement el)
	{
		Actions act=new Actions(driver);
		act.click(el).build().perform();
	}
	
	
	//file upload
	public static void fileuplload(String loc)
	{
		 StringSelection sel=new StringSelection(loc);
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
         try
         {
	      Thread.sleep(4000);
	      
	      Robot rb=new Robot();
	      
	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
	      
	      rb.keyPress(KeyEvent.VK_CONTROL);
	      rb.keyPress(KeyEvent.VK_V);
	      
	      rb.keyRelease(KeyEvent.VK_CONTROL);
	      rb.keyRelease(KeyEvent.VK_V);
	      
	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
         }
         catch(Exception e)
         {
        	 System.out.println(e);
         }
         
	}
	
	//to take screen shot
	public static void screenshotonfail()
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"./Screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
