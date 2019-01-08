package com.ebayAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.ebayAutomation.utils.AndroidDriverManager;
import com.ebayAutomation.utils.Utils;

public class LoginPage  extends Utils {
	
	public LoginPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ebay.mobile:id/home']")
	public MobileElement btn_tab;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/profile_container']")
	public MobileElement btn_signIn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_classic']")
	public MobileElement btn_useEmail;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.ebay.mobile:id/edit_text_username']")
	public MobileElement txtbx_username;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.ebay.mobile:id/et_temp']")
	public MobileElement txtbx_pwd;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_sign_in']")
	public MobileElement btn_Login;
	
	public void clickOnTab()
	{
		Utils.waitUntilElementToBeClickable(btn_tab);
		btn_tab.click();;
		Utils.waitUntilElementToBeClickable(btn_signIn);
		btn_signIn.click();
		Utils.waitUntilElementToBeClickable(btn_useEmail);
		btn_useEmail.click();
		}	
	
	public void submitUsernandpwd()
	{
		 txtbx_username.clear();
		 txtbx_username.setValue("Ankittripathi.qa@gmail.com");;
		 txtbx_pwd.clear();
		 txtbx_pwd.setValue("Test@123");
		 btn_Login.click();
	}
	
	

}
