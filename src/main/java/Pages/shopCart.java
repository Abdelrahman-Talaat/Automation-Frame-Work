package Pages;

import ElementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class shopCart {
    By pageTitleLocator= By.xpath("//div[@class='page-title']/h1");
    By orderSummaryLocator=By.xpath("//div[@class='order-summary-content']/div");
    public WebDriver driver;
    ElementActions eActions;
    public shopCart(WebDriver driver){
        this.driver=driver;
        eActions=new ElementActions(driver);
    }
    public String getPageTitle(){
        return eActions.getText(pageTitleLocator);
    }
   public String getOrderSummary(){
        return eActions.getText(orderSummaryLocator);
   }
}
