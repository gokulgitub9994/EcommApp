package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;

public class IncreaseQtyOfPrdctInCart extends BaseClass {
	
	@Test
	public void increaseQtyOfPrdctInCart() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		MyCartPage mp = new MyCartPage(driver);
		mp.getIncrsQtyBtn().click();
		wLib.scrollByAmount(driver);
		mp.getUpdateShoppingCartBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		System.out.println("Qty Increased");

	}

}
