package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    public WebDriver driver;

    public homePage (WebDriver driver){
        this.driver=driver;
    }

    public void clickLink(String linkLocator){
        driver.findElement(By.xpath(linkLocator)).click();
    }

    public RegistrationPage clickRegistrationPage(){
        clickLink("//a[@href='/register?returnUrl=%2F']");
         return new RegistrationPage(driver);
    }

    public LoginPage clickLoginPage(){
        clickLink("//a[@href='/login?returnUrl=%2F']");
        return new LoginPage(driver);
    }
}
