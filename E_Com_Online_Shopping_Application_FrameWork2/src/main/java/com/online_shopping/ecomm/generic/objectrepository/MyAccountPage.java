package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver = null;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindAll({@FindBy(className="collapsed"),@FindBy(xpath="//a[contains(text(),'My Profile')]")})
	private WebElement myProfileLink;
	
	@FindAll({@FindBy(name="name"),@FindBy(xpath="//input[@id='name']")})
	private WebElement userNameField;
	
	@FindAll({@FindBy(name="update"),@FindBy(xpath="//button[text()='Update']")})
	private WebElement updateBtn;
	
	@FindAll({@FindBy(linkText="Order History"),@FindBy(xpath="//a[text()='Order History']")})
	private WebElement orderHistoryLink;

	public WebElement getMyProfileLink() {
		return myProfileLink;
	}

	public WebElement getUserNameField() {
		return userNameField;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}
	
	
	
	
}
