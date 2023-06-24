package driverFactory;


import constants.driverType;
import org.openqa.selenium.WebDriver;

public class selectDriverFactory {
    public static  ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    public static WebDriver getDriverFactory(driverType driverType){
           switch (driverType){
               case CHROME ->{
                 driverThreadLocal.set( new chromeDriverFactory().getDriver());
                 return driverThreadLocal.get();
               }
               case FIREFOx -> {
                   driverThreadLocal.set( new fireFoxDriverFactory().getDriver());
                   return driverThreadLocal.get();
               }
               case EDGE -> {
                   driverThreadLocal.set( new edgeDriverFactory().getDriver());
                   return driverThreadLocal.get();
               }
               default -> throw new IllegalStateException("Unexpected value: " + driverType);
           }
    }

public void quit(){
        driverThreadLocal.get().quit();
}

}
