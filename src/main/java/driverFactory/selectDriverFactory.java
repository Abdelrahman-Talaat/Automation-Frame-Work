package driverFactory;


import constants.driverType;
import org.openqa.selenium.WebDriver;

import static driverFactory.driverAbstract.driver;

public class selectDriverFactory {
    public ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    public driverAbstract getDriverFactory(driverType driverType){
           switch (driverType){
               case CHROME ->{
                  return new chromeDriverFactory();
               }
               case FIREFOx -> {
                   return new fireFoxDriverFactory();
               }
               case EDGE -> {
                   return new edgeDriverFactory();
               }
               default -> throw new IllegalStateException("Unexpected value: " + driverType);
           }
    }

}
