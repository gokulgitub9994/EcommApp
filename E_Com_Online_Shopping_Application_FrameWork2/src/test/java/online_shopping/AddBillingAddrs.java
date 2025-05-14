package online_shopping;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;

public class AddBillingAddrs extends BaseClass {
	@Test
	public void addBillingAddrs() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Product Category", title);
		
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
	
		bp.getAddToCrtBtn().click();
		SoftAssert soft = new SoftAssert();
		
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		wLib.scrollByAmount(driver);

		String ADDRESS = eLib.getDataFromExcel("Billing", 1, 1);
		String STATE = eLib.getDataFromExcel("Shipping", 2, 1);
		String CITY = eLib.getDataFromExcel("Shipping", 3, 1);
		String PINCODE = eLib.getDataFromExcel("Shipping", 4, 1);
		MyCartPage mp = new MyCartPage(driver);
		mp.addBillingAddrs(ADDRESS, STATE, CITY, PINCODE);
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
	}

}
