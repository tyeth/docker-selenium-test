package com.tyeth.dockerseleniumtest.test;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    protected WebDriver driver;
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();
        
       // dc.setVersion("ANY");
        dc.setPlatform(Platform.LINUX);
        String host = System.getProperty("seleniumHubHost");
        
        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
        
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }  
}
