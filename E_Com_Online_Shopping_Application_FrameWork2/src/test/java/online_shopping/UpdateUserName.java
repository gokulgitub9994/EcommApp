package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyAccountPage;

public class UpdateUserName extends BaseClass {
	
	@Test
	public void updateUserName() throws Throwable {
		String username = eLib.getDataFromExcel("product", 1, 3);
		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);
		hp.getMyAccountLink().click();
		Thread.sleep(5000);
		MyAccountPage map = new MyAccountPage(driver);
		map.getUserNameField().clear();
		map.getUserNameField().sendKeys(username);
		wLib.scrollByAmount(driver);
		map.getUpdateBtn().click();
		Thread.sleep(1000);
		wLib.switchToAlertAndAccept(driver);
	}

}
