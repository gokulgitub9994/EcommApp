
package com.online_shopping.ecomm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this );
		
	}
	@FindAll({@FindBy(id="exampleInputEmail1"),@FindBy(name="email")})
	private WebElement emailEdit;
	
	@FindAll({@FindBy(id="exampleInputPassword1"),@FindBy(name="password")})
	private WebElement passwordEdit;
	
	@FindAll({@FindBy(xpath="Login"),@FindBy(name="login")})
	private WebElement loginBtn;

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String mailId,String password) {
		emailEdit.sendKeys(mailId);
		passwordEdit.sendKeys(password);
		Actions action = new Actions(driver);
		action.scrollByAmount(0,200).perform();
		loginBtn.click();
	}
	
	

}
