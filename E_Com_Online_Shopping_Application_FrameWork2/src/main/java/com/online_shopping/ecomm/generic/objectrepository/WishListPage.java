package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	WebDriver driver = null;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//a/parent::td[@class='col-md-2 close-btn']//i)[1]")
	private WebElement cancelBtn;

	@FindBy(linkText="My Cart")
	private WebElement myCartLink;
	
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getMyCartLink() {
		return myCartLink;
	}
	
	

	

	

	

	
	
	

}
