package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.sql.Driver;

public class fireFoxDriverFactory extends driverAbstract{
    @Override
    public void startDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions option=new FirefoxOptions();
        option.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver=new FirefoxDriver(option);
    }
}
