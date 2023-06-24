package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    protected WebDriver driver;
    By registeredEmailLocator= By.xpath("//input[@id='Email']");
    By passwordLocator=By.xpath("//input[@id='Password']");
    By clickLoginButton=By.xpath("//div/button[@type='submit']");
    By getWelcomeMessageLocator=By.xpath("//div[@class='topic-block-title']");
    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    public void enterRegisteredEmail(String Email){
        driver.findElement(registeredEmailLocator).sendKeys(Email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(clickLoginButton).click();
    }

    public void getMessage(){
        Assert.assertEquals(driver.findElement(getWelcomeMessageLocator).getText(),"Welcome to our store");
    }

}
