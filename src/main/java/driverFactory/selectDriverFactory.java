package driverFactory;


import ElementActions.ElementActions;
import constants.driverType;
import org.openqa.selenium.WebDriver;

public class selectDriverFactory {

    public static WebDriver driver;
    public selectDriverFactory(){

    }


    public static WebDriver getDriverFactory(driverType driverType){
           switch (driverType){
               case CHROME ->{
                 driver=new chromeDriverFactory().getDriver();
                 return driver;
               }
               case FIREFOX -> {
                 driver=new fireFoxDriverFactory().getDriver();
                   return driver;
               }
               case EDGE -> {
                   driver=new edgeDriverFactory().getDriver();
                   return driver;
               }
               default -> throw new IllegalStateException("Unexpected value: " + driverType);
           }
    }

     public void quit(){
        driver.quit();
}
public WebDriver getDriver(){
        return driver;
}
     public synchronized ElementActions element(){
        return new ElementActions(driver);
}

}
