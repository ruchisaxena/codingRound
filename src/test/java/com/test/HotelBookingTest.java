package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HotelSearchPage;
import com.utils.TestUtils;

public class HotelBookingTest extends Base{

	HotelSearchPage hotelSearch;
	
	@BeforeMethod
	public void setup(){
		initialization();
		hotelSearch = new HotelSearchPage(driver);
	}
	
	@DataProvider
	public Object[][] getHotelSearchData(){
		Object[][] data = TestUtils.getTestData("Sheet1");
		return data;
	}

    @Test(dataProvider = "getHotelSearchData")
    public void shouldBeAbleToSearchForHotels(String where, String travlleres) {
    	hotelSearch.clickOnHotelLink();
    	hotelSearch.searchForHotel(where, travlleres);
    	
    }

    @AfterMethod
    public  void tearDown(){
		driver.quit();
	}

}
