package ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ElementActions {
    /** Set the Thread local driver **/
    public static ThreadLocal<WebDriver> actionDriver=new ThreadLocal<>();
    //pass the driver that will be used
    public ElementActions (WebDriver driver){
        actionDriver.set(driver);
    }


    public void click(By buttonLocator){
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
    public void implicitWait(int timeOut){
        actionDriver.get().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public void explicitWait(Duration timeOut,By element,String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(actionDriver.get(),timeOut);
        wait.until(ExpectedConditions.textToBe(element, text));
    }
    public void fluentWait(){
        FluentWait wait=new FluentWait<>(actionDriver).withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
    }

    public void selectFromDropDownList(String option,By selectedOption){
        Select selectOption=new Select(actionDriver.get().findElement(selectedOption));
        selectOption.selectByVisibleText(option);

    }
    public List<String> getSelectFromDropDownList(By selectedOption){
       Select option=new Select(actionDriver.get().findElement(selectedOption));
       List<WebElement> selected=option.getAllSelectedOptions();
       return selected.stream().map(e->e.getText()).collect(Collectors.toList());

   }
    public void hoverOverItem(By hoveredElement){
       Actions action=new Actions(actionDriver.get());
       action.moveToElement(actionDriver.get().findElement(hoveredElement)).perform();
  }
     public void uploadFile(String pathOfTheFileOnPc,By uploadBtnLocator){
          actionDriver.get().findElement(uploadBtnLocator).sendKeys(pathOfTheFileOnPc);
     }
}
