package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
	
	WebDriver driver = null;
	
	public MyCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindAll({@FindBy(xpath="(//span[@class='ir'])[1]"),@FindBy(xpath="//i[@class='icon fa fa-sort-asc']/parent::span")})
	private WebElement incrsQtyBtn;
	
	@FindAll({@FindBy(xpath="(//span[@class='ir'])[2]"),@FindBy(xpath="//i[@class='icon fa fa-sort-asc']/parent::span")})
	private WebElement decrsQtyBtn;
	
	
	@FindAll({@FindBy(xpath="//input[@name='submit']"),@FindBy(xpath="//input[@value='Update shopping cart']")})
	private WebElement updateShoppingCartBtn;
	
	@FindAll({@FindBy(name="ordersubmit"),@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")})
	private WebElement checkOutBtn;
	
	@FindAll({@FindBy(linkText="Logout"),@FindBy(xpath="//i[@class='icon fa fa-sign-out']")})
	private WebElement logoutLink;
	
	@FindAll({@FindBy(name="billingaddress"),@FindBy(xpath="(//textarea[@required='required'])[1]")})
	private WebElement billingAddField;
	
	@FindAll({@FindBy(name="bilingstate"),@FindBy(xpath="//input[@id='bilingstate']")})
	private WebElement billingStateField;
	
	@FindAll({@FindBy(name="billingcity"),@FindBy(xpath="//input[@id='billingcity']")})
	private WebElement billingCityField;
	
	@FindAll({@FindBy(name="billingpincode"),@FindBy(xpath="//input[@id='billingpincode']")})
	private WebElement billPincodeField;
	
	@FindAll({@FindBy(name="update"),@FindBy(xpath="//button[text()='Update']")})
	private WebElement billingUpdateBtn;
	
	@FindAll({@FindBy(name="shippingaddress"),@FindBy(xpath="(//textarea[@required='required'])[1]")})
	private WebElement shippingAddField;
	
	@FindAll({@FindBy(name="shippingstate"),@FindBy(xpath="//input[@id='shippingstate']")})
	private WebElement shippingStateField;
	
	@FindAll({@FindBy(name="shippingcity"),@FindBy(xpath="//input[@id='shippingcity']")})
	private WebElement shippingCityField;
	
	@FindAll({@FindBy(name="shippingpincode"),@FindBy(xpath="//input[@id='shippingpincode']")})
	private WebElement shipPincodeField;
	
	@FindAll({@FindBy(name="shipupdate"),@FindBy(xpath="//button[text()='Update']")})
	private WebElement shippingUpdateBtn;
	
	@FindAll({@FindBy(name="remove_code[]"),@FindBy(xpath="//input[@type='checkbox']")})
	private WebElement checkbox;
	
	@FindAll({@FindBy(name="submit"),@FindBy(xpath="//input[@value='submit']")})
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement trackOrderLink;
	
	


	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}

	public WebElement getIncrsQtyBtn() {
		return incrsQtyBtn;
	}

	public WebElement getDecrsQtyBtn() {
		return decrsQtyBtn;
	}



	public WebElement getUpdateShoppingCartBtn() {
		return updateShoppingCartBtn;
	}


	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}

	public WebElement getBillingAddField() {
		return billingAddField;
	}

	public WebElement getBillingStateField() {
		return billingStateField;
	}

	public WebElement getBillingCityField() {
		return billingCityField;
	}

	public WebElement getBillPincodeField() {
		return billPincodeField;
	}

	public WebElement getBillingUpdateBtn() {
		return billingUpdateBtn;
	}

	public WebElement getShippingAddField() {
		return shippingAddField;
	}

	public WebElement getShippingStateField() {
		return shippingStateField;
	}

	public WebElement getShippingCityField() {
		return shippingCityField;
	}

	public WebElement getShipPincodeField() {
		return shipPincodeField;
	}

	public WebElement getShippingUpdateBtn() {
		return shippingUpdateBtn;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void addShippingAddrs(String address,String state,String city,String pincode) {
		shippingAddField.clear();
		shippingAddField.sendKeys(address);
		shippingStateField.clear();
		shippingStateField.sendKeys(state);
		shippingCityField.clear();
		shippingCityField.sendKeys(city);
		shipPincodeField.clear();
		shipPincodeField.sendKeys(pincode);
		shippingUpdateBtn.click();
	}
	
	public void addBillingAddrs(String address,String state,String city,String pincode) {
		billingAddField.clear();
		billingAddField.sendKeys(address);
		billingStateField.clear();
		billingStateField.sendKeys(state);
		billingCityField.clear();
		billingCityField.sendKeys(city);
		billPincodeField.clear();
		billPincodeField.sendKeys(pincode);
		billingUpdateBtn.click();
	}
	
	
	
	
	
	
	
	
	
	

}
