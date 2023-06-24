package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeDriverFactory extends driverAbstract{
    @Override
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
         driver=new ChromeDriver(option);


    }
}
