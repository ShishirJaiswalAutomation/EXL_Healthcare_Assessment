package com.exlhealthcare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exlhealthcare.qa.base.TestBase;
import com.exlhealthcare.qa.util.Log;

public class GoogleMapsHomePage extends TestBase {

	public GoogleMapsHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchboxinput")
	WebElement searchboxLocation;

	@FindBy(id = "searchbox-searchbutton")
	WebElement searchButton;
	
	public WebElement searchboxLocation() {
		return searchboxLocation;
	}
	
	public WebElement searchButton() {
		return searchButton;
	}

	// Actions
	public String validateHomePageTitle() {
		Log.info("Get the page title");
		return driver.getTitle();
	}
	
	public void setSearchLocation(String searchLocation) {
		Log.info("Set search location input box");
		searchboxLocation().sendKeys(searchLocation);
	}
	
	public void clickSearchButton() {
		Log.info("Click search button");
		searchButton().click();
	}

}
