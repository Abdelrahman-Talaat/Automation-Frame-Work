package BaseTest;


import BrowserActions.BrowserActions;
import com.google.common.io.Files;
import constants.driverType;
import driverFactory.selectDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.report.AllureReportBuilderException;

import java.io.File;
import java.io.IOException;

import static constants.driverType.CHROME;

public  class BaseTest  {
     public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
     BrowserActions  bActions;
    @BeforeClass
    @Parameters
    public synchronized void setUp(@Optional("CHROME") String browserName){
         driver.set(selectDriverFactory.getDriverFactory(driverType.valueOf(browserName)));
         bActions=new BrowserActions(driver.get());
         bActions.getToUrl("https://demo.nopcommerce.com/");
         bActions.maximizePage();
    }
    @AfterMethod
  /*  public void ScreenShot (ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera=(TakesScreenshot)driver.get();
            File screenShot=camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot,new File("resources/screenShots"+result.getName()+"png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }}*/

    @AfterClass
    public void tearDown(){
        bActions.closeWindows();
    }
}


