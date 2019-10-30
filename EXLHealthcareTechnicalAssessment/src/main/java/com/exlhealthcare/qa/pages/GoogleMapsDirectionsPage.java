package com.exlhealthcare.qa.pages;

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
	
	@FindBy(id = "sb_ifc51")
	WebElement searchFromLocationInputBox;
	
	@FindBy(id = "sb_ifc52")
	WebElement searchToLocationInputBox;
	
	@FindBy(xpath = "//div[@class='directions-travel-mode-icon directions-drive-icon']")
	WebElement lnkTravelModeDrivingIcon;
	
	//Actions
	public void setSearchFromLocation(String searchFromLocation) {
		Log.info("Set search From location input box");
		searchFromLocationInputBox.sendKeys(searchFromLocation);
	}
	
	public void setSearchToLocation(String searchToLocation) {
		Log.info("Set search To location input box");
		searchToLocationInputBox.sendKeys(searchToLocation);
		Log.info("Press Enter key to search the directions");
		searchToLocationInputBox.sendKeys(Keys.ENTER);
	}
		
	public void clickTravelModeIcon() {
		Log.info("Click driving travel mode icon");
		lnkTravelModeDrivingIcon.click();
	}

}
