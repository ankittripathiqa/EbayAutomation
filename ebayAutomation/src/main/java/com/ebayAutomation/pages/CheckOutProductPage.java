package com.ebayAutomation.pages;

import javax.rmi.CORBA.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class CheckOutProductPage extends Utils{
	
	AndroidDriver<WebElement> driver;

	public CheckOutProductPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/search_box']")
	public MobileElement txtbx_search;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.ebay.mobile:id/search_src_text']")
	public MobileElement txtbx_searchPhone;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id='com.ebay.mobile:id/text'])[1]")
	public MobileElement txtbx_selectPhone;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout[@resource-id='com.ebay.mobile:id/cell_collection_item'])[1]")
	public MobileElement btn_phone;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_add_to_cart']")
   	public MobileElement btn_addBasket;
	
	@AndroidFindBy(xpath="(//android.widget.Spinner[@resource-id='com.ebay.mobile:id/spinner_selection_option'])[1]")
   	public MobileElement btn_colour;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gold']")
   	public MobileElement sel_gol;
	
	@AndroidFindBy(xpath="(//android.widget.Spinner[@resource-id='com.ebay.mobile:id/spinner_selection_option'])[2]")
   	public MobileElement btn_cap;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='16GB']")
   	public MobileElement btn_16gb;
	
	@AndroidFindBy(xpath="(//android.widget.Spinner[@resource-id='com.ebay.mobile:id/spinner_selection_option'])[3]")
   	public MobileElement btn_pack;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Yes']")
   	public MobileElement btn_pro;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_add_to_cart']")
	public MobileElement btn_addcart;
	
	public void searchforProduct(String product)
	{
		txtbx_search.click();
		waitUntilElementVisible(txtbx_searchPhone);
		txtbx_searchPhone.sendKeys(product);
		waitUntilElementToBeClickable(txtbx_selectPhone);
		txtbx_selectPhone.click();
		}
	
	public void clickOnProduct()
	{
		waitUntilElementToBeClickable(btn_phone);
		btn_phone.click();
		
	}
	
	public void addphoneincart()
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"BUY IT NOW\"))");
		waitUntilElementToBeClickable(btn_colour);
		btn_colour.click();
		waitUntilElementToBeClickable(sel_gol);
		sel_gol.click();
		waitUntilElementToBeClickable(btn_cap);
		btn_cap.click();
		waitUntilElementToBeClickable(btn_16gb);
		btn_16gb.click();
		waitUntilElementToBeClickable(btn_pack);
		btn_pack.click();
		waitUntilElementToBeClickable(btn_pro);
		btn_pro.click();
		waitUntilElementToBeClickable(btn_addcart);
		btn_addcart.click();
	}


	
}
	
	
	
