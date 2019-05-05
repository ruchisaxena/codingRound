package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import com.base.Base;
import com.utils.TestUtils;

public class HotelSearchPage extends Base{
	
	WebDriver driver;
	
	 @FindBy(linkText = "Hotels")
	    private WebElement hotelLink;

	    @FindBy(id = "Tags")
	    private WebElement localityTextBox;

	    @FindBy(id = "SearchHotelsButton")
	    private WebElement searchButton;

	    @FindBy(id = "travellersOnhome")
	    private WebElement travellerSelection;
	    
	    public HotelSearchPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
	    
	    public void clickOnHotelLink(){
	    	hotelLink.click();
		}
	    
	    public void searchForHotel(String where, String travellers){
	    	localityTextBox.sendKeys(where);
	    	WebDriverWait wait=new WebDriverWait(driver, TestUtils.EXPLICITLY_WAIT);
	    	travellerSelection= wait.until(ExpectedConditions.visibilityOf(travellerSelection));
	    	 new Select(travellerSelection).selectByVisibleText(travellers);
	    	         searchButton.click();
		}
}
