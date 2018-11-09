package com.tyeth.dockerseleniumtest.test;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class KatalonStudioTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
   }

//  @Test
  public void KatalonStudioTest(WebDriver rDriver) throws Exception {
    driver = rDriver;
	  driver.get("http://admin:UtXwvc28@192.168.1.1/");
    try {
      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BASIC'])[1]/following::span[1]")).getText(), "ADVANCED");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BASIC'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2] | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2]")).click();
    try {
      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='On'])[7]/following::td[2]")).getText(), "Allow guests to see each other and access my local network");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Router Update'])[1]/following::span[1]")).click();
    try {
      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Wireless AP'])[1]/following::span[1]")).getText(), "Port Forwarding / Port Triggering");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Wireless AP'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    try {
      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HTTP'])[2]/following::span[7]")).getText(), "Edit Service");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("RouteSelect")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HTTP'])[2]/following::span[7]")).click();
    driver.findElement(By.name("server_ip4")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ports - Custom Services'])[1]/following::span[1]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

