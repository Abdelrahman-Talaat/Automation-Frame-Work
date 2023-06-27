package ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    public static ThreadLocal<WebDriver> actionDriver=new ThreadLocal<>();
    //pass the driver that will be used
    public ElementActions (WebDriver driver){
        actionDriver.set(driver);
    }


    public void clickButton(By buttonLocator){
        actionDriver.get().findElement(buttonLocator).click();
    }
    public void sendData(String data,By DataLocator){
        actionDriver.get().findElement(DataLocator).sendKeys(data);
    }

    public String getText(By textLocator){
        return actionDriver.get().findElement(textLocator).getText();
    }
    public ElementActions element(){
        return new ElementActions(getDriver());
    }
    public WebDriver getDriver(){
        return actionDriver.get();
    }


}
