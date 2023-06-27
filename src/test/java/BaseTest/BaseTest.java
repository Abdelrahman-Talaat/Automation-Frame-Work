package BaseTest;


import constants.driverType;
import driverFactory.selectDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;

public class BaseTest  {
     public ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    @BeforeClass
    @Parameters
    public synchronized void setUp(@Optional("CHROME") String browser){
         driver.set(selectDriverFactory.getDriverFactory(driverType.valueOf(browser)));
         driver.get().get("https://demo.nopcommerce.com/");
    }
    /*@AfterClass
    public void tearDown(){
        driver.get().quit();
        *//*new AllureReportBuilder("1.5.4", new File("target/allure-report")).unpackFace();
        new AllureReportBuilder("1.5.4", new File("target/allure-report")).processResults(new
                File("target/allure-results"));*//*
    }*/
}
