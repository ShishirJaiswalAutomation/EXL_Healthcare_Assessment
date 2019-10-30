package com.exlhealthcare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exlhealthcare.qa.base.TestBase;
import com.exlhealthcare.qa.pages.GoogleMapsDirectionsPage;
import com.exlhealthcare.qa.pages.GoogleMapsHomePage;
import com.exlhealthcare.qa.pages.GoogleMapsSearchPage;
import com.exlhealthcare.qa.util.Log;

public class GoogleMapsSearch extends TestBase{
	
	GoogleMapsHomePage homePage;
	GoogleMapsSearchPage searchPage;
	GoogleMapsDirectionsPage directionsPage;
	
	public GoogleMapsSearch() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new GoogleMapsHomePage();
		searchPage = new GoogleMapsSearchPage();
		directionsPage = new GoogleMapsDirectionsPage();
	}

	@Test(priority=1)
	public void searchGoogleMaps() {
		try {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Google Maps");
		
		homePage.setSearchLocation("San Francisco, California");
		homePage.clickSearchButton();
		
		Thread.sleep(10000);
			
		String coordinates = "37.7576793,-122.5076402";
		String url = searchPage.searchPageURL();
		System.out.println(url);
		boolean coord = url.contains(coordinates);
		System.out.println(coord);
		Assert.assertTrue(url.contains(coordinates), "Co-ordinates are not correct");
		
		searchPage.clickDirectionsLink();
		
		directionsPage.clickTravelModeIcon();
		directionsPage.setSearchFromLocation("Chico, California");
		directionsPage.setSearchToLocation("San Francisco, California");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
