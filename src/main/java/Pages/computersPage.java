package Pages;

import ElementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class computersPage {
    public  WebDriver driver;
    ElementActions eAction;
    By desktopLocator=By.xpath("//h2/a[@href='/desktops']");
    By productLocator=By.xpath("//img[@alt='Picture of Build your own computer']");
    By processorLocator=By.xpath("//option[@data-attr-value='1']");
    By RamLocator=By.xpath("//option[@data-attr-value='4']");
    By HDDLocator=By.xpath("//input[@id='product_attribute_3_6']");
    By OsLocator=By.xpath("//input[@id='product_attribute_4_9']");
    By microsoftOfficeLocator=By.xpath("//input[@id='product_attribute_5_10']");
    By AcrobatReaderLocator=By.xpath("//input[@id='product_attribute_5_11']");
    By totalCommanderLocator=By.xpath("//input[@id='product_attribute_5_12']");
    public By priceLocator=By.xpath("//span[@class='price-value-1']");
    By addToCartLocator=By.xpath("//button[@id='add-to-cart-button-1']");
    By addingMessageProductLocator=By.xpath("//div[@class='bar-notification success']/p[@class='content']");
    By shoppingCartLocator=By.xpath("//a[@href='/cart']") ;
    By removeBtnLocator=By.xpath("//button[@class='remove-btn']");
    By shoppingCartMessageLocator=By.xpath("//div[@class='no-data']");
    public computersPage (WebDriver driver ){
        this.driver=driver;
        eAction=new ElementActions(driver);
    }

    public void clickDesktop(){
            eAction.click(desktopLocator);
    }

    public void selectProduct(){
        eAction.click(productLocator);
    }
    public void selectComputerSpecs() throws InterruptedException {
        eAction.click(processorLocator);
        eAction.click(RamLocator);
        eAction.click(HDDLocator);
        eAction.click(OsLocator);
        eAction.click(AcrobatReaderLocator);
        eAction.click(totalCommanderLocator);
        eAction.explicitWait(Duration.ofSeconds(200),priceLocator,"$1,345.00");
    }
    public String getProductPrice() throws InterruptedException {
        return eAction.getText(priceLocator);
    }
   public void addToCartBtn(){
        eAction.click(addToCartLocator);
   }
   public String getAddingProductMessage(){
        return eAction.getText(addingMessageProductLocator);
   }
   public void checkAddedProduct(){
        eAction.click(shoppingCartLocator);
   }
   public void removeProduct(){
        eAction.click(removeBtnLocator);
   }
   public String getSoppingCartMessage(){
       return eAction.getText(shoppingCartMessageLocator);
   }
}
