package com.ebayAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Utils {
		
		
		static AndroidDriver androidDriver;

	    //Constructor
	    public Utils(AndroidDriver androidDriver) {
	        this.androidDriver = androidDriver;
	    }
		  public void writeText(WebElement webElement, String text) {
		        webElement.clear();
		        webElement.sendKeys(text);
		    }
		  
		  //Explicit Wait
		    public static void waitUntilElementVisible(WebElement webElement) {
		        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
		        wait.until(ExpectedConditions.visibilityOf(webElement));
		    }

		    //Explicit
		    public static void waitUntilElementToBeClickable(WebElement webElement) {
		        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
		        wait.until(ExpectedConditions.elementToBeClickable(webElement));
		    }
		    
		 
	}

