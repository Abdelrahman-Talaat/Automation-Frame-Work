package pages;

import Assertions.Assertion;
import BaseTest.BaseTest;
import Pages.homePage;
import Pages.shopCart;
import org.testng.annotations.Test;

public class ShopCartTest extends BaseTest {
    homePage homePage;
    shopCart shopCart;

    @Test
    public void shopCartTest(){
        homePage=new homePage(driver.get());
        shopCart= homePage.clickOnShopCart();
        Assertion.assertEquals(shopCart.getPageTitle(),"Shopping cart");
    }
}
