package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;

public class AddProductToWishlist extends BaseClass {
	@Test
	public void addProductToWishList() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getWishListBtn().click();

	}

}
