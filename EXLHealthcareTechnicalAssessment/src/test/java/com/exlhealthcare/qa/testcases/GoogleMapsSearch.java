package com.exlhealthcare.qa.testcases;

import java.util.HashMap;
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
import com.exlhealthcare.qa.util.Utilities;

public class GoogleMapsSearch extends TestBase {

	GoogleMapsHomePage homePage;
	GoogleMapsSearchPage searchPage;
	GoogleMapsDirectionsPage directionsPage;
	Utilities util;

	public GoogleMapsSearch() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new GoogleMapsHomePage();
		searchPage = new GoogleMapsSearchPage();
		directionsPage = new GoogleMapsDirectionsPage();
		util = new Utilities();
	}

	@Test
	public void searchGoogleMaps() {
		try {
			
			Log.startTestCase("searchGoogleMaps");
			String chromecoordinates = prop.getProperty("chromecoordinates");
			String firefoxcoordinates = prop.getProperty("firefoxcoordinates");
			String iecoordinates = prop.getProperty("iecoordinates");
			String searchFromLocation = prop.getProperty("searchFromLocation");
			String searchToLocation = prop.getProperty("searchToLocation");
			String numberOfExpectedAvailableRoutes = prop.getProperty("numberOfExpectedAvailableRoutes");
					
			String title = homePage.validateHomePageTitle();
			util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
			Assert.assertEquals(title, "Google Maps");
			
			Log.info("Set the value of To Location to: '" + searchToLocation + "'");
			homePage.setSearchLocation(searchToLocation);
			util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
			homePage.clickSearchButton();
			
			util.waitforPageToLoad(10000);
			
			String url = searchPage.searchPageURL();		

			if (prop.getProperty("browser").equals("chrome")) {
				util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
				Assert.assertTrue(url.contains(chromecoordinates), "Co-ordinates are not correct");
				Log.info("Coordinates exist");
			} else if (prop.getProperty("browser").equals("firefox")) {
				util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
				Assert.assertTrue(url.contains(firefoxcoordinates), "Co-ordinates are not correct");
				Log.info("Coordinates exist");
			} else if (prop.getProperty("browser").equals("IE")) {
				util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
				Assert.assertTrue(url.contains(iecoordinates), "Co-ordinates are not correct");
				Log.info("Coordinates exist");
			}

			Log.info("Clicked Directions link");
			searchPage.clickDirectionsLink();
			util.takeScreenshot("GoogleMapSearch" + driver.getTitle());
			Log.info("Clicked travel mode icon");
			directionsPage.clickTravelModeIcon();
			
			Log.info("Set the value of From Location field to: '" + searchFromLocation + "'");
			directionsPage.setSearchFromLocation(searchFromLocation);
			util.takeScreenshot("GoogleMapSearch" + driver.getTitle());

			List<WebElement> routes = (List<WebElement>) directionsPage.numberOfRoutes();
			String availableRoutes = String.valueOf(routes.size());
			Log.info("No. of actual available routes: " + availableRoutes);
			Log.info("No. of expected available routes: " + numberOfExpectedAvailableRoutes);
			Assert.assertEquals(availableRoutes, numberOfExpectedAvailableRoutes);
			util.takeScreenshot("GoogleMapSearch" + driver.getTitle());

			String title_route1 = directionsPage.descriptionRoute1().getText();
			Log.info("Route1 title: " + title_route1);

			String distance_route1 = directionsPage.distanceMilesRoute1().getText();
			Log.info("Route1 distance: " + distance_route1);

			String travel_time_route1 = directionsPage.travelTimeRoute1().getText();
			Log.info("Route1 travel time: " + travel_time_route1);

			String title_route2 = directionsPage.descriptionRoute2().getText();
			Log.info("Route2 title: " + title_route2);

			String distance_route2 = directionsPage.distanceMilesRoute2().getText();
			Log.info("Route2 distance: " + distance_route2);

			String travel_time_route2 = directionsPage.travelTimeRoute2().getText();
			Log.info("Route2 travel time: " + travel_time_route2);

//		String title_route3 = directionsPage.descriptionRoute3().getText();
//		Log.info("Route3 title: " + title_route3);
//		
//		String distance_route3 = directionsPage.distanceMilesRoute3().getText();
//		Log.info("Route3 distance: " + distance_route3);
//		
//		String travel_time_route3 = directionsPage.travelTimeRoute3().getText();
//		Log.info("Route3 travel time: " + travel_time_route3);

			Log.info("Storing the details in HashMap");
			HashMap<String, String> routeDetails = new HashMap<String, String>();
			routeDetails.put("Route1 Title", title_route1);
			routeDetails.put("Route1 Distance", distance_route1);
			routeDetails.put("Route1 Travel Time", travel_time_route1);
			routeDetails.put("Route2 Title", title_route2);
			routeDetails.put("Route2 Distance", distance_route2);
			routeDetails.put("Route2 Travel Time", travel_time_route2);
//		routeDetails.put("Route3 Title", title_route3);
//		routeDetails.put("Route3 Distance", distance_route3);
//		routeDetails.put("Route3 Travel Time", travel_time_route3);

			Log.info("Writing the details from HashMap to text file 'routes.txt'");
			util.writeDataToTextFile(routeDetails, "..\\routes.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		Log.endTestCase("searchGoogleMaps");
		driver.quit();
	}

}
