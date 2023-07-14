package pages;

import BaseTest.BaseTest;
import Pages.computersPage;
import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
        Assert.assertEquals(computer.getProductPrice(),"$1,345.00");
        computer.addToCartBtn();
        System.out.println(computer.getAddingProductMessage());
        Assert.assertEquals(computer.getAddingProductMessage(),"The product has been added to your shopping cart");
        computer.checkAddedProduct();
        computer.removeProduct();
       /* driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));*/
        Assert.assertEquals(computer.getSoppingCartMessage(),"Your Shopping Cart is empty!");
        Assert.assertTrue(false);
    }
}
