package driverFactory;


import constants.driverType;
import org.openqa.selenium.WebDriver;

public class selectDriverFactory {
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public selectDriverFactory(driverType driverType){
        getDriverFactory(driverType);
    }

    public void getDriverFactory(driverType driverType) {
        switch (driverType) {
            case CHROME -> {
                driverThreadLocal.set(new chromeDriverFactory().getDriver());
            }
            case FIREFOx -> {
                driverThreadLocal.set(new fireFoxDriverFactory().getDriver());
            }
            case EDGE -> {
                driverThreadLocal.set(new edgeDriverFactory().getDriver());

            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }

    public WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public void quit() {
        driverThreadLocal.get().quit();
    }

}
