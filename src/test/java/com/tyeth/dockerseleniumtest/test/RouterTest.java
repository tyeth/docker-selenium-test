package com.tyeth.dockerseleniumtest.test;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import com.tyeth.dockerseleniumtest.pages.RouterPage;

public class RouterTest extends BaseTest{
	
    private RouterPage store;
    private String baseUrl;


    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
//    
//    
//    public RouterTest(){
//    	if(this.driver==null) {
//    		try {
//				setUp();
//			} catch (MalformedURLException e) {
//			}
//    		
//    	}
//    }
    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        store = new RouterPage(super.driver);
        
    }

    @Test()//dataProvider = "assertions")
    public void googleTest() throws MalformedURLException {//String category) {
        if(store==null) {
        	setUp();
        }
    	store.goTo();
    }
   
    
    //"\"authenticated\": true"


//    @DataProvider(name = "assertions")
//    public static Object[][] credentials() {
//          return new Object[][] {
//              { "\"authenticated\":\ttrue," },
//              { "\"user\":\t\"user\"" }           
//          };
//    }
    
}
