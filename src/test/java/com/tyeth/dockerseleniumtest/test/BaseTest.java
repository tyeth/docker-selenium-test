package com.tyeth.dockerseleniumtest.test;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.CapabilityType;

public class BaseTest {

    protected WebDriver driver;

	@BeforeTest
    public void setUp() throws MalformedURLException {
       if(this.driver==null) { 
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        String s = System.getProperty("browser");
        //if (s!=null && s.equals("firefox"))
            dc = DesiredCapabilities.firefox();
            
       // dc.setVersion("ANY");
        dc.setPlatform(Platform.ANY);
        String host = System.getProperty("seleniumHubHost");
        if(host==null || host.equals(""))host=new String("localhost");
        
        LoggingPreferences logPref = new LoggingPreferences(); 
        logPref.enable(LogType.DRIVER, Level.ALL); 
        dc.setCapability(CapabilityType.LOGGING_PREFS, logPref);


        try {
        	driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
            	
        }
        catch(Exception e) {
        	System.out.println("Driver Creation Exception, retrying in 5seconds...");
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {

			}
        	driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
            
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
       }
   }
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
        driver = null;
    }  
}
