package Pages;

import ElementActions.ElementActions;
import driverFactory.selectDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UserFormData;

import static driverFactory.selectDriverFactory.driver;

public class homePage {


     public WebDriver driver;
     ElementActions eActions;


   public homePage (WebDriver driver){
        this.driver=driver;
        eActions=new ElementActions(driver);
    }

    public void clickLink(String linkLocator){
        eActions.click(By.xpath(linkLocator));
    }

    public RegistrationPage clickRegistrationPage(){
        clickLink("//a[@href='/register?returnUrl=%2F']");
         return new RegistrationPage(driver);
    }

    public LoginPage clickLoginPage(){
        clickLink("//a[@href='/login?returnUrl=%2F']");
        return new LoginPage(driver);
    }
    //    By computerOrderLocator=By.xpath();

    public computersPage clickComputers(){
      clickLink("//a[@href='/computers']");
        return new computersPage(driver);
    }

    public shopCart clickOnShopCart(){
       clickLink("//span[@class='cart-label']");
       return new shopCart(driver);
    }
}
