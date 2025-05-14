package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyAccountPage;

public class ViewOrderHistory extends BaseClass {
	
	@Test
	public void viewOrderHistory() throws Throwable {
		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		hp.getMyAccountLink().click();
		wLib.scrollByAmount(driver);
		MyAccountPage map = new MyAccountPage(driver);
		Thread.sleep(2000);
		map.getOrderHistoryLink().click();
		
	}

}
