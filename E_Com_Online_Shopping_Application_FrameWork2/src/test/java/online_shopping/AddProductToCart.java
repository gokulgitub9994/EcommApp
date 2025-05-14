package online_shopping;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
@Listeners(com.onlineshopping.ecom.generic.listenerutility.ListImpClass.class)
public class AddProductToCart extends BaseClass{
	
	@Test
	public void addProductToCartTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
	}

}
