package com.exlhealthcare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.exlhealthcare.qa.base.TestBase;
import com.exlhealthcare.qa.util.Log;

public class GoogleMapsSearchPage extends TestBase{
	
	public String url = "";
	
	public GoogleMapsSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Directions')]")
	WebElement lnkDirections;
	
	public WebElement lnkDirections() {
		return lnkDirections;
	}
	
	public String searchPageURL() {
		Log.info("Get the current page url");
		url = driver.getCurrentUrl();
		return url;
	}
	
	public void clickDirectionsLink() {
		Log.info("Click Directions link");
		lnkDirections().click();
	}

}
