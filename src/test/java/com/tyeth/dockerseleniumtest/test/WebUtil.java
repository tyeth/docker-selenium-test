package com.tyeth.dockerseleniumtest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUtil {
	

    public static List<WebElement> FindElements(By bySelector, WebDriver ld) {
    	WaitDelay();
    	List<WebElement> elements = ld.findElements(bySelector);
		int x = elements.size();
		if(x==0) {
			System.out.println("Element not present " + GetSelectorDescription(bySelector)); 
			System.out.println(ld.getPageSource());
			return null;
		}
		System.out.println(x+" Element(s) Found " + GetSelectorDescription(bySelector)); 
		for (WebElement webElement : elements) {
				String txt = "\t Id:" + webElement.getAttribute("id") + 
						"\t Name:"+webElement.getAttribute("name")+
						"\t value:" + webElement.getAttribute("value")+
						"\t Text:" +webElement.getText()
						;
				
				System.out.println(txt);
			}
		return elements;
	}

    public static WebElement ClickFirstElement(WebDriver t,By by) {
    	System.out.println("Clicking first element below:");
    	WebElement a = FindElement(t,by);
    	a.click();
    	return a;
    }
    
    private static void WaitDelay() {

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

		}
	}

	public static WebElement FindElement(WebDriver t, By bySelector) {
    	return FindElements(bySelector, t).toArray(new WebElement[0])[0];
    }
    
	public static String GetSelectorDescription(By bySelector) {
		String s= "@@ " + bySelector.toString() + " @@";
		return s;
	} 
	

    public static void  switchFrameTo(WebDriver t,By bySelector) {
    	System.out.println("Switching to IFRAME " + bySelector.toString());
    	t.switchTo().frame(FindElement(t,bySelector));
    }

}