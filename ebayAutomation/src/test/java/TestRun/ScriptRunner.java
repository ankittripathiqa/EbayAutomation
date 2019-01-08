package TestRun;

import io.appium.java_client.android.AndroidDriver;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebayAutomation.pages.CheckOutProductPage;
import com.ebayAutomation.pages.LoginPage;
import com.ebayAutomation.utils.AndroidDriverManager;




public class ScriptRunner {
	
	AndroidDriver androidDriver;
	LoginPage loginPage;
	CheckOutProductPage checkOutProductPage;
	
	@BeforeMethod
	public void startUp() throws Throwable
	{  
		AndroidDriverManager.initiateAndroidDriver();
		androidDriver=AndroidDriverManager.getAndroidDriverDriver();
	    loginPage=new LoginPage(androidDriver);
	    checkOutProductPage=new CheckOutProductPage(androidDriver);
		
	}
	
	@Test
	public void validation()
	{  
		
		loginPage.clickOnTab();
		loginPage.submitUsernandpwd();
		checkOutProductPage.addToCart();
		
		
	}

}
