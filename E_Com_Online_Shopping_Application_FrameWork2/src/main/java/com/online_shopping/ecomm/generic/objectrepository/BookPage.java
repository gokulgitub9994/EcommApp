package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
	WebDriver driver = null;

	public BookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({@FindBy(xpath="(//button[@type='button'])[5]"),@FindBy(linkText="Add to cart")})
	private WebElement addToCrtBtn;
	
	@FindAll({@FindBy(xpath="(//i[@class='icon fa fa-heart']/parent::a[@title='Wishlist']/i)[2]"),@FindBy(xpath="//a[@title='Wishlist']")})
	private WebElement wishListBtn;

	public WebElement getAddToCrtBtn() {
		return addToCrtBtn;
	}

	public WebElement getWishListBtn() {
		return wishListBtn;
	}
	
	
	


}
