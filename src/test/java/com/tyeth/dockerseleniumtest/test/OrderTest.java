//package com.tyeth.dockerseleniumtest.test;
//
//
//import java.net.MalformedURLException;
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.tyeth.dockerseleniumtest.pages.OrderPage;
//
//public class OrderTest extends BaseTest{
//
//    private OrderPage store;
//  
////    public OrderTest(){
////    	if(this.driver==null) {
////    		try {
////				setUp();
////			} catch (MalformedURLException e) {
////			}
////    		
////    	}
////    }
//    
//    @BeforeTest
//    public void setUp() throws MalformedURLException {
//        super.setUp();
//        store = new OrderPage(super.driver);
//    }
//   
//    @Test(dataProvider = "category")
//    public void googleTest(String category) {
//        store.goTo();
//        store.goToCategory(category);
//        List<String> itemPrice = store.getListOfItems();
//        itemPrice.stream()
//                 .forEach(System.out::println);
//        System.out.println("----------------------------");
//        Assert.assertTrue(itemPrice.size()>0);
//    }
//        
//    @DataProvider(name = "category")
//    public static Object[][] credentials() {
//          return new Object[][] {
//              { "Accessories" },
//              { "iMacs" },
//              { "iPads" },
//              { "iPhones" },
//              { "iPods" }, 
//              { "MacBooks" },
//              { "Accessories" },
//              { "iMacs" },
//              { "iPads" },
//              { "iPhones" },
//              { "iPods" }, 
//              { "MacBooks" }              
//          };
//    }
//
//}
