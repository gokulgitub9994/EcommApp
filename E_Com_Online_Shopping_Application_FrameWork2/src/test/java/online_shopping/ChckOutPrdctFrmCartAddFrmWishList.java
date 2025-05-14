package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;
import com.online_shopping.ecomm.generic.objectrepository.WishListPage;

public class ChckOutPrdctFrmCartAddFrmWishList  extends BaseClass{
	
	@Test
	public void chckOutPrdctFrmCartAddFrmWishList() {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getWishListBtn().click();
		
		WishListPage wlp = new WishListPage(driver);
		wlp.getAddToCartBtn().click();
		wlp.getMyCartLink().click();
		wLib.scrollByAmount(driver);
		
		MyCartPage mp = new MyCartPage(driver);
		mp.getCheckOutBtn().click();
		mp.getSubmitBtn().click();
		
	}
	

}
