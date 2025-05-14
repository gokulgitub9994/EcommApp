package online_shopping;

import org.testng.annotations.Test;

import com.online_shopping.ecom.generic.baseclass.BaseClass;
import com.online_shopping.ecomm.generic.objectrepository.HomePage;

public class SearchForProduct extends BaseClass{
	
	@Test
	public void searchForProduct() throws Throwable {
		String product = eLib.getDataFromExcel("product", 1, 0);
		HomePage hp = new HomePage(driver);
		hp.getSearchTxtField().sendKeys(product);
		hp.getSearchBtn().click();
		
	}

}
