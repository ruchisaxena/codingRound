package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.SignInPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class SignInTest  extends Base{

	SignInPage sIn;
	
	@BeforeMethod
	public void setup(){
		initialization();
		 sIn = new SignInPage(driver);
	}
	

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {    	
    	String errMsg = "There were errors in your submission";
        waitFor(2000);
        sIn.clickOnYourTrips();
        sIn.clickOnSignIn();
        sIn.switchToFrame();
        sIn.clickOnSignInButton();
        sIn.checkErrorMessage(errMsg);
        
        
    }
    
    @AfterMethod
    public  void tearDown(){
		driver.quit();
	}

   

    


}
