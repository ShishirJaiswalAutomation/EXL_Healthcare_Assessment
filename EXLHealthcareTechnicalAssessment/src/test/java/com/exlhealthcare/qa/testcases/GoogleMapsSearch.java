package com.exlhealthcare.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
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

	@Test
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
		System.out.println("Clicked travel mode icon");
		directionsPage.setSearchFromLocation("Chico, California");
		directionsPage.setSearchToLocation("San Francisco, California");
		
		List<WebElement> routes = (List<WebElement>) directionsPage.numberOfRoutes();
		
		int availableRoutes = routes.size();
		
		System.out.println("No. of available routes: " + availableRoutes);
		
		Assert.assertEquals(availableRoutes, 2);
		
		String title_route1 = directionsPage.descriptionRoute1().getText();
		System.out.println("Route1 title: " + title_route1);
		
		String distance_route1 = directionsPage.distanceMilesRoute1().getText();
		System.out.println("Route1 distance: " + distance_route1);
		
		String travel_time_route1 = directionsPage.travelTimeRoute1().getText();
		System.out.println("Route1 travel time: " + travel_time_route1);
		
		String title_route2 = directionsPage.descriptionRoute2().getText();
		System.out.println("Route2 title: " + title_route2);
		
		String distance_route2 = directionsPage.distanceMilesRoute2().getText();
		System.out.println("Route2 distance: " + distance_route2);
		
		String travel_time_route2 = directionsPage.travelTimeRoute2().getText();
		System.out.println("Route2 travel time: " + travel_time_route2);
		
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
