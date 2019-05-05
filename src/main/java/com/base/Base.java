package com.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.sun.javafx.PlatformUtil;
import com.utils.TestUtils;

public class Base {
	
	public static  WebDriver driver;
	
	
	public static  void initialization() {
    	/*
    	 * Added if - else block
    	 */
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        else if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL PC\\git\\chromedriver_win32\\chromedriver.exe");
        }
        else if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
        // For block the browser notification
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
         driver = new ChromeDriver(options);
         driver.get("https://www.cleartrip.com/");
         driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtils.IMPLESIT_WAIT,TimeUnit.SECONDS);
         
    }
	
	
	 public void waitFor(int durationInMilliSeconds) {
	        try {
	            Thread.sleep(durationInMilliSeconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }
	    }

}
