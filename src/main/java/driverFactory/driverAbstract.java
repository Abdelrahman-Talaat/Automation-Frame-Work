package driverFactory;

import org.openqa.selenium.WebDriver;

public abstract class  driverAbstract {

    protected static WebDriver driver ;

    public abstract void startDriver();

    public void quit(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
            startDriver();
        }
        return driver;
    }




}
