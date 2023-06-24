package BaseTest;

import driverFactory.selectDriverFactory;
import org.aspectj.weaver.CrosscuttingMembers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static constants.driverType.CHROME;

public class BaseTest {
    public static ThreadLocal<driverFactory.selectDriverFactory> driver=new ThreadLocal<>();
    @BeforeClass
    public void setUp(){
        driver=new ThreadLocal<>();
        driver.set(new selectDriverFactory());
        driver.get().getDriverFactory(CHROME);




    }
    /*@AfterClass
    public void tearDown(){
      driver=new ThreadLocal<>();
        driver.get().quit();
    }*/
}
