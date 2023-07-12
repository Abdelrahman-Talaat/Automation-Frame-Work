package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import static driverFactory.selectDriverFactory.driver;


public class Screenshot {
    public void getScreenShot(ITestResult result)  throws IOException {
        /*var camera=(TakesScreenshot)driver;
        File screenShot=camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenShot,new File("resources/screenShots"+"png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Date currentData=new Date();
        String screenshotFilename=currentData.toString().replace("","-").replace(":","-");
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(".//Screenshots//"+result.getName()+".png"));






    }
}