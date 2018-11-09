//package com.tyeth.dockerseleniumtest.test;
//
//import java.net.MalformedURLException;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.tyeth.dockerseleniumtest.pages.SearchPage;
//
//public class SearchTest extends BaseTest {
//
//    private SearchPage google;
////    
//    
//
//    
////    public SearchTest(){
////    	if(driver==null) {
////    		try {
////				setUp();
////			} catch (MalformedURLException e) {
////			}
////    		
////    	}
////    }
//    @BeforeTest
//    public void setUp() throws MalformedURLException {
//        super.setUp();
//        google = new SearchPage(super.driver);
//    }
//
//    @Test(dataProvider = "search-keywords")
//    public void googleTest(String searchKeyword) {
//        google.goTo();
//        google.searchFor(searchKeyword);
//        Assert.assertTrue(google.getResults().size()>0);
//    }
//   
//    @DataProvider(name = "search-keywords")
//    public static Object[][] credentials() {
//          return new Object[][] {
//              { "test automation guru" },
//              { "selenium webdriver" },
//              { "dockerized selenium grid" },
//              { "test automation blog" },
//              { "jmeter docker" } ,
//              { "test automation guru" },
//              { "selenium webdriver" },
//              { "dockerized selenium grid" },
//              { "test automation blog" },
//              { "jmeter docker" }               
//          };
//    }
//
//}
