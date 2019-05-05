package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Base;

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
	    	 new Select(travellerSelection).selectByVisibleText(travellers);
	         searchButton.click();
		}
}
