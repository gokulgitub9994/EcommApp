package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver = null;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({@FindBy(linkText="Login"), @FindBy(xpath="//a[text()='Login']")})
	private WebElement logInLink;
	
	@FindAll({@FindBy(linkText="Logout"),@FindBy(xpath="//a[text()='Logout']")})
	private WebElement logOutLink;

	
	@FindAll({@FindBy(linkText="My Cart"), @FindBy(xpath="//a[text()='My Cart']")})
	private WebElement myCartLink;
	
	@FindAll({@FindBy(linkText="Wishlist"), @FindBy(xpath="//a[text()='Wishlist']")})
	private WebElement wishListLink;
	
	@FindAll({@FindBy(linkText="My Account"), @FindBy(xpath="//a[text()='My Account']")})
	private WebElement myAccountLink;
	
	@FindAll({@FindBy(linkText="Home"), @FindBy(xpath="//a[text()='Home']")})
	private WebElement homeLink;
	
	@FindAll({@FindBy(linkText="Track Order"), @FindBy(xpath="//span[text()='Track Order']")})
	private WebElement trackOrderLink;
	
	@FindAll({@FindBy(linkText="Books"), @FindBy(xpath="(//a[@href='category.php?cid=3'])[1]")})
	private WebElement booksLink;
	
	@FindAll({@FindBy(name="product"), @FindBy(xpath="//input[@class='search-field']")})
	private WebElement searchTxtField;
	
	@FindAll({@FindBy(name="search"), @FindBy(xpath="//button[@class='search-button']")})
	private WebElement searchBtn;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogInLink() {
		return logInLink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getWishListLink() {
		return wishListLink;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}
	
	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	
	
	
	
	

}
