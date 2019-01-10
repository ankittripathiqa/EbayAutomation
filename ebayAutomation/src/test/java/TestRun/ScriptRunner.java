package TestRun;

import javax.net.ssl.SSLEngineResult.Status;

import io.appium.java_client.android.AndroidDriver;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebayAutomation.pages.CheckOutProductPage;
import com.ebayAutomation.pages.LoginPage;
import com.ebayAutomation.utils.AndroidDriverManager;
import com.ebayAutomation.utils.ExcelFileReader;
import com.ebayAutomation.utils.ExtLogger;






public class ScriptRunner {
	
	AndroidDriver androidDriver;
	LoginPage loginPage;
	CheckOutProductPage checkOutProductPage;
	ExtLogger log;
	
	@BeforeMethod
	public void startUp() throws Throwable
	{  
		AndroidDriverManager.initiateAndroidDriver();
		androidDriver=AndroidDriverManager.getAndroidDriverDriver();
	    loginPage=new LoginPage(androidDriver);
	    checkOutProductPage=new CheckOutProductPage(androidDriver);
	    log.testStepLog("Before Method");
		
	}
	
	@Test(priority=1)
	public void clickOnLoginTab()
	{  
		loginPage.clickOnTab();
		log.stepLog("Login to the application");
		
	
	}
	
	@Test(priority=2)
	public void submitUserandpwd()
	{
		loginPage.submitUsernandpwd(ExcelFileReader.getCellValue("Login.xlsx","LoginUser",2, "A"),ExcelFileReader.getCellValue("Login.xlsx","LoginUser",2, "B"));
		log.stepLog("fill the user information and click on submit");
	}
	
	@Test(priority=3)
	public void searchTheptoduct()
	{
	checkOutProductPage.searchforProduct(ExcelFileReader.getCellValue("Login.xlsx","LoginUser",2, "C"));	
	log.stepLog("Search for the product");
	}
	
	@Test(priority=4)
	public void selectTheproduct()
	{
		checkOutProductPage.clickOnProduct();
		log.stepLog("Select the product");
	}
	
	@Test(priority=5)
	public void addTocart()
	{
		checkOutProductPage.addphoneincart();
		log.stepLog("Add product in the cart");
	}
	
	
	

}
