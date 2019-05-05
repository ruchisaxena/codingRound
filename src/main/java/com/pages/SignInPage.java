package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;

public class SignInPage extends Base{
	
	WebDriver driver;
	
	@FindBy(linkText = "Your trips")
	private WebElement yourTrips;
	
	@FindBy(id = "SignIn")
	private WebElement signIn;
	
	@FindBy(id = "signInButton")
	private WebElement signInButton;
	
	@FindBy(id = "errors1")
	private WebElement errorText;
	
	private static String iframe = "modal_window";
	
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnYourTrips(){
		yourTrips.click();
	}
	
	public void clickOnSignIn(){
		signIn.click();
	}
	
	public void switchToFrame(){
		 driver.switchTo().frame(driver.findElement(By.id(iframe)));
	}
	
	public void clickOnSignInButton(){
		signInButton.click();
	}
	
	public void checkErrorMessage(String msg){
		String error1 = errorText.getText();
		Assert.assertTrue(error1.contains("There were errors in your submission"));
	}
	
	
	

}
