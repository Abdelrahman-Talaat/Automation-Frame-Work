package BaseTest;

import driverFactory.selectDriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static constants.driverType.CHROME;
import static constants.driverType.FIREFOx;

public class BaseTest {
    public static ThreadLocal<driverFactory.selectDriverFactory> driver=new ThreadLocal<>();
    @BeforeClass
    public synchronized void setUp(){
        driver.set(new selectDriverFactory());
        driver.get().getDriverFactory(CHROME).get("https://demo.nopcommerce.com/");






    }
    @AfterClass
    public void tearDown(){
       driver.get().quit();
    }
}
