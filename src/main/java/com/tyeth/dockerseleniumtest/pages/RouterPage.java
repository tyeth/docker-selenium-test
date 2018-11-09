package com.tyeth.dockerseleniumtest.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyeth.dockerseleniumtest.test.BaseTest;
import com.tyeth.dockerseleniumtest.test.WebUtil;

public class RouterPage {

	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private WebDriver driver;
	private Actions action;

	Consumer<By> hover = (By by) -> {
		action.moveToElement(driver.findElement(by)).perform();
	};

	public RouterPage(final WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);

	}

	public void goTo() {
		baseUrl = "http://admin:UtXwvc28@192.168.1.1/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		this.driver.get(baseUrl);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		this.driver.get(baseUrl);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e2) {

		}

		try {
			assertEquals(this.driver.findElement(By.xpath(
							"(.//*[normalize-space(text()) and normalize-space(.)='BASIC'])[1]/following::span[1]"))
					.getText().trim(), "ADVANCED");
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
			// TODO Auto-generated catch block
		}

		WebUtil.ClickFirstElement(this.driver,By
						.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BASIC'])[1]/following::span[1]"));
				 
		try {
			System.out.println("Waiting 3s before navigating to port forwarding");
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
		}
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 |
		// ]]
		WebUtil.ClickFirstElement(driver,By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Advanced Setup'])"));
				
		WebUtil.ClickFirstElement(driver,By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='Port Forwarding / Port Triggering'])"))
	;			 

		WebUtil.switchFrameTo(driver,By.name("page2"));
		
		try{
				System.out.println("Click Radio button of HTTP Service");
//				String s = 
				WebUtil.ClickFirstElement(driver,
				//	By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Service Name'])")	
				By.xpath(				"(.//*[normalize-space(text()) and normalize-space(.)=\"HTTP\"])[2]/parent::*/preceding-sibling::*[2]/input")
//					).getText();
						)
//				System.out.println(s);
	;
				System.out.println("Waiting 3s before asserting Edit Service");
					Thread.sleep(3000);
				} catch (Exception e1) {
					System.out.println("Exception");
				
				}
		ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("RouteSelect"));
		waitForElement(By.tagName("input"));
		waitForElement(By.name("RouteSelect"));

		
		System.out.println("Asserting Edit Service exists");
		try {
			assertEquals(WebUtil.FindElement(driver,By.cssSelector("[value=\"Edit Service\"]"))
					.getText().trim(), "Edit Service");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// this.driver
		// 		.findElement(
		// 				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HTTP'])[2]/following::span[7]"))
		// 		.click();
		// this.driver.findElement(By.name("server_ip4")).click();
		// this.driver.findElement(By.xpath(
		// 		"(.//*[normalize-space(text()) and normalize-space(.)='Ports - Custom Services'])[1]/following::span[1]"))
		// 		.click();

		System.out.println("Click Edit Service");
		WebUtil.ClickFirstElement( driver,By.cssSelector("[value='Edit Service']"));
		
		System.out.println("DONE.");

	}

	public void waitForElement(By bySelector) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver);
		wait.withTimeout(9, TimeUnit.SECONDS);
		wait.pollingEvery(250,TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver,WebElement>(){
			@Override public WebElement apply(WebDriver ld) {
				List<WebElement> elements = WebUtil.FindElements(bySelector, ld);
				WebElement element = (WebElement) elements.toArray()[0];					 
					 return element; 
			}
		});
		wait.ignoring(Throwable.class);
		wait.withMessage("Waiting");
	}

	private void assertEquals(String a, String b) {
		if (a.equals(b)) {
			System.out.println("### TRUE:");
			System.out.println(a);
			System.out.println('\t');
			System.out.println(b);
		} else {
			System.out.println("### FALSE:");
			System.out.println(a);
			System.out.println('\t');
			System.out.println(b);

		}

	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//
	// private boolean isAlertPresent() {
	// try {
	// this.driver.switchTo().alert();
	// return true;
	// } catch (Exception e) {
	// return false;
	// }
	// }
	//
	// private String closeAlertAndGetItsText() {
	// try {
	// Alert alert = this.driver.switchTo().alert();
	// String alertText = alert.getText();
	// if (acceptNextAlert) {
	// alert.accept();
	// } else {
	// alert.dismiss();
	// }
	// return alertText;
	// } finally {
	// acceptNextAlert = true;
	// }
	// }

}
