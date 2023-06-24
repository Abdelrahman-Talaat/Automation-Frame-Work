package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

public class edgeDriverFactory extends driverAbstract{
    @Override
    public void startDriver() {
        WebDriverManager.edgedriver().setup();
        System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        EdgeOptions option=new EdgeOptions();
        option.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver=new EdgeDriver(option);
    }
}
