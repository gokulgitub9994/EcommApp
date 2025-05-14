package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.WishListPage;

public class RemovePrdctFrmWishlist extends BaseClass {
	
	@Test
	public void removePrdctFrmWishlist() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getWishListBtn().click();
		Thread.sleep(3000);
		WishListPage wlp = new WishListPage(driver);
		wlp.getCancelBtn().click();
		Thread.sleep(3000);
		wLib.switchToAlertAndAccept(driver);

	}

}
