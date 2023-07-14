package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import static driverFactory.selectDriverFactory.driver;


public  class Screenshot {
    public static void getScreenShot(ITestResult result)  throws IOException {
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="E:/testing/java/projects/nopCommerceFrameWork/Screenshots";
        FileUtils.copyFile(screenshotFile,new File(".//Screenshots//"+result.getName()+".png"));
      /*  Reporter.log( "'> <img src='"+ path + "' height='100' width='100'/> </a>");*/







    }



}