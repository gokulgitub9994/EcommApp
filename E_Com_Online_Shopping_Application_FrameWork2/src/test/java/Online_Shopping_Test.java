import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.BookPage;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;
import com.online_shopping.ecomm.generic.objectrepository.MyAccountPage;
import com.online_shopping.ecomm.generic.objectrepository.MyCartPage;
import com.online_shopping.ecomm.generic.objectrepository.TrackOrderPage;
import com.online_shopping.ecomm.generic.objectrepository.WishListPage;
@Listeners(com.onlineshopping.ecom.generic.listenerutility.ListImpClass.class)
public class Online_Shopping_Test extends BaseClass {

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

	@Test
	public void addProductToWishList() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getWishListBtn().click();

	}

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

	@Test
	public void decreaseQtyOfPrdctInCart() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		MyCartPage mp = new MyCartPage(driver);
		mp.getDecrsQtyBtn().click();
		wLib.scrollByAmount(driver);
		mp.getUpdateShoppingCartBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		System.out.println("Qty Decreased");

	}

	@Test
	public void addShippingAddrs() throws Throwable {
		ExtentTest test = report.createTest("addShippingAddrs");
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		wLib.scrollByAmount(driver);

		String ADDRESS = eLib.getDataFromExcel("Shipping", 1, 1);
		String STATE = eLib.getDataFromExcel("Shipping", 2, 1);
		String CITY = eLib.getDataFromExcel("Shipping", 3, 1);
		String PINCODE = eLib.getDataFromExcel("Shipping", 4, 1);
		MyCartPage mp = new MyCartPage(driver);
		mp.addShippingAddrs(ADDRESS, STATE, CITY, PINCODE);
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
	}

	@Test
	public void addBillingAddrs() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
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
	
	@Test
	public void searchForProduct() throws Throwable {
		String product = eLib.getDataFromExcel("product", 1, 0);
		HomePage hp = new HomePage(driver);
		hp.getSearchTxtField().sendKeys(product);
		hp.getSearchBtn().click();
		
	}
	
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
	
	@Test
	public void removeProductFromCart() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		BookPage bp = new BookPage(driver);
		wLib.scrollByAmount(driver);
		bp.getAddToCrtBtn().click();
		Thread.sleep(2000);
		wLib.switchToAlertAndAccept(driver);
		MyCartPage mp = new MyCartPage(driver);
		mp.getCheckbox().click();
		wLib.scrollByAmount(driver);
		mp.getUpdateShoppingCartBtn().click();
		Thread.sleep(3000);
		wLib.switchToAlertAndAccept(driver);
		wLib.switchToAlertAndAccept(driver);
		
		
	}
	
	
	
	
}
