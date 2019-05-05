package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HotelSearchPage;

public class HotelBookingTest extends Base{

	HotelSearchPage hotelSearch;
	
	@BeforeMethod
	public void setup(){
		initialization();
		hotelSearch = new HotelSearchPage(driver);
	}

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	hotelSearch.clickOnHotelLink();
    	hotelSearch.searchForHotel("Indiranagar, Bangalore", "1 room, 2 adults");
    	
    }

    @AfterMethod
    public  void tearDown(){
		driver.quit();
	}

}
