package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;
import com.online_shopping.ecomm.generic.objectrepository.TrackOrderPage;

public class TrackOrderUsingOrderId extends BaseClass{


	@Test
	public void trackOrderUsingOrderId() throws Throwable {
		String orderId = eLib.getDataFromExcel("product", 1, 1);
		String mailId = eLib.getDataFromExcel("product", 1, 2);
		MyCartPage mp = new MyCartPage(driver);
		mp.getTrackOrderLink().click();
		TrackOrderPage top = new TrackOrderPage(driver);
		Thread.sleep(1000);
		top.getOrderIdEdit().sendKeys(orderId);
		top.getRegistermailIdEdit().sendKeys(mailId);
		wLib.scrollByAmount(driver);
		top.getTrackButton().click();
	}
	
}
