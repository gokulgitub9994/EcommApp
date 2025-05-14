package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrderPage {

	WebDriver driver = null;
	public TrackOrderPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this );
		
	}
	
	@FindAll({@FindBy(id="exampleOrderId1"),@FindBy(xpath="//input[@name='orderid']")})
	private WebElement orderIdEdit;
	
	@FindAll({@FindBy(id="exampleBillingEmail1"),@FindBy(xpath="//input[@name='email']")})
	private WebElement registermailIdEdit;
	

	@FindAll({@FindBy(name="submit"),@FindBy(xpath="//button[text()='Track']")})
	private WebElement trackButton;
	
	public WebElement getOrderIdEdit() {
		return orderIdEdit;
	}


	public WebElement getRegistermailIdEdit() {
		return registermailIdEdit;
	}


	public WebElement getTrackButton() {
		return trackButton;
	}
	
	
	
	
	
	
	
}
