package pages;

import Assertions.Assertion;
import BaseTest.BaseTest;
import Pages.computersPage;
import Pages.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class orderTest extends BaseTest {
    homePage home;
    computersPage computer;



    @Test
    public void computerOrderTest() throws InterruptedException {
        home=new homePage(driver.get());
        computer=home.clickComputers();
        computer.clickDesktop();
        computer.selectProduct();
        computer.selectComputerSpecs();
        System.out.println("The Total Price Of the Selected Computer Specs="+computer.getProductPrice());
        Assertion.assertEquals(computer.getProductPrice(),"$1,345.00");
        computer.addToCartBtn();
        System.out.println(computer.getAddingProductMessage());
        Assertion.assertEquals(computer.getAddingProductMessage(),"The product has been added to your shopping cart");
        computer.checkAddedProduct();
        computer.removeProduct();
        Assertion.assertEquals(computer.getSoppingCartMessage(),"Your Shopping Cart is empty!");
        /*Assertion.assertTrue(false);*/

    }
}
