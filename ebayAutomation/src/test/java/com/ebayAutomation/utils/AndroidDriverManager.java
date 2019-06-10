package com.ebayAutomation.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AndroidDriverManager {
    public static String MobileDeviceName, AndroidVersion,
            MobileOperatingSystem, AppPackages, AppActivities;
    public static Properties config = null;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver androidDriver;

    public static  AndroidDriver getAndroidDriverDriver()  {
        try {
            if (androidDriver == null) androidDriver = initiateAndroidDriver();
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
        return androidDriver;
    }

    public static AndroidDriver initiateAndroidDriver() throws MalformedURLException {
        config = loadconfigurationfile("Configuration.properties");
        MobileDeviceName = config.getProperty("MobileDeviceName");
        MobileOperatingSystem = config.getProperty("MobileOS");
        AndroidVersion = config.getProperty("AndroidVersion");
        AppPackages = config.getProperty("appPackage");
        AppActivities = config.getProperty("activities");

        System.out.println(MobileDeviceName);
        System.out.println(MobileOperatingSystem);
        System.out.println(AndroidVersion);
        System.out.println(AppPackages);
        System.out.println(AppActivities);
        System.out.println( System.getProperty("user.dir")+ "/App/eBay.apk");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", MobileDeviceName);
        capabilities.setCapability("platformName", MobileOperatingSystem);
        capabilities.setCapability("platformVersion", AndroidVersion);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "True");
        capabilities.setCapability("app", System.getProperty("user.dir")+ "/App/com.ebay.mobile.apk");
        capabilities.setCapability("appPackage", AppPackages);
        capabilities.setCapability("appActivity", AppActivities);
        capabilities.setCapability("autoGrantPermission", "true");
        capabilities.setCapability("newCommandTimeout", 1000);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("automationName", "UiAutomator2");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return androidDriver;
    }

    public static Properties loadconfigurationfile(String name) {
        try {
            config = new Properties();
            String filePath = System.getProperty("user.dir")
                    + "//config//" + name;
            System.out.println("Properties File" + filePath);
            if (isFilePath(filePath)) {
                FileInputStream fileinp = new FileInputStream(filePath);
                config.load(fileinp);
                System.out.println("Fetching data from the path" + filePath
                        + name);
            } else {
                System.out.println("Not able to fetch data from config property file:"
                        + name); }
        } catch (IOException strInputOutputException) {
            System.out
                    .println("IOException occured in loading config configuration file"
                            + name);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Assert.fail("Some Exception occured in loading config properties file");
        }
        return config;
    }
    public static boolean isFilePath(String filePathvalue) {
        try {
            if ((filePathvalue).trim() == "") {
                return false;
            } else {
                File fs = new File(filePathvalue);
                boolean value = fs.exists();
                if (value) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
