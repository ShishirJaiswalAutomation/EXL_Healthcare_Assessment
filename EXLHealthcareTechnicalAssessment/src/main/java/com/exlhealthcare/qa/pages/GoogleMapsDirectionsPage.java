package com.exlhealthcare.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exlhealthcare.qa.base.TestBase;
import com.exlhealthcare.qa.util.Log;

public class GoogleMapsDirectionsPage extends TestBase{
	
	public GoogleMapsDirectionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Choose starting point, or click on the map...']")
	WebElement searchFromLocationInputBox;
	
	@FindBy(xpath = "//div[@id='sb_ifc52']/input")
	WebElement searchToLocationInputBox;
	
	@FindBy(xpath = "//div[@class='directions-travel-mode-icon directions-drive-icon']")
	WebElement lnkTravelModeDrivingIcon;
	
	@FindBy(xpath = "//div[@class='section-layout']/div[contains(@id,'section-directions-trip')]")
	List<WebElement> numberOfRoutes;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-0']//div[@class='section-directions-trip-duration delay-light']")
	WebElement travel_time_route1;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-0']//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']")
	WebElement distance_miles_route1;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-0']//h1[@class='section-directions-trip-title'][1]")
	WebElement description_route1;

	@FindBy(xpath = "//div[@id='section-directions-trip-1']//div[@class='section-directions-trip-duration delay-light']")
	WebElement travel_time_route2;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-1']//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']")
	WebElement distance_miles_route2;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-1']//h1[@class='section-directions-trip-title'][1]")
	WebElement description_route2;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-2']//div[@class='section-directions-trip-duration delay-light']")
	WebElement travel_time_route3;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-2']//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']")
	WebElement distance_miles_route3;
	
	@FindBy(xpath = "//div[@id='section-directions-trip-2']//h1[@class='section-directions-trip-title'][1]")
	WebElement description_route3;
	
	public WebElement linkTravelModeDrivingIcon() {
		return lnkTravelModeDrivingIcon;
	}
	
	public WebElement searchFromLocationInputBox() {
		return searchFromLocationInputBox;
	}
	
	public WebElement searchToLocationInputBox() {
		return searchToLocationInputBox;
	}
	
	public List<WebElement> numberOfRoutes() {
		return numberOfRoutes;
	}
	
	public WebElement distanceMilesRoute1() {
		return distance_miles_route1;
	}
	
	public WebElement travelTimeRoute1() {
		return travel_time_route1;
	}
	
	public WebElement descriptionRoute1() {
		return description_route1;
	}
	
	public WebElement distanceMilesRoute2() {
		return distance_miles_route2;
	}
	
	public WebElement travelTimeRoute2() {
		return travel_time_route2;
	}
	
	public WebElement descriptionRoute2() {
		return description_route2;
	}
	
	public WebElement distanceMilesRoute3() {
		return distance_miles_route3;
	}
	
	public WebElement travelTimeRoute3() {
		return travel_time_route3;
	}
	
	public WebElement descriptionRoute3() {
		return description_route3;
	}
	
	public void setSearchFromLocation(String searchFromLocation) {
		Log.info("Set search From location input box");
		searchFromLocationInputBox().sendKeys(searchFromLocation);
		Log.info("Press Enter key to search the directions");
		searchFromLocationInputBox().sendKeys(Keys.ENTER);
	}
	
	public void setSearchToLocation(String searchToLocation) {
		Log.info("Set search To location input box");
		searchToLocationInputBox().sendKeys(searchToLocation);
	}
		
	public void clickTravelModeIcon() {
		Log.info("Click driving travel mode icon");
		linkTravelModeDrivingIcon().click();
	}

}
