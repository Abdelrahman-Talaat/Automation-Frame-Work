package Pages;

import ElementActions.ElementActions;
import driverFactory.selectDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import static ElementActions.ElementActions.actionDriver;
import static driverFactory.selectDriverFactory.driver;

public class RegistrationPage {



    By genderMaleLocator= By.xpath("//input[@id='gender-male']");
    By firstNameLocator=By.xpath("//input[@id='FirstName']");
    By lastNameLocator=By.xpath("//input[@id='LastName']");
    By selectDateOfBirthDay=By.xpath("//div[@class='inputs date-of-birth']/div/select[@name='DateOfBirthDay']/option[8]");
    By selectDateOfBirthMonth=By.xpath("//div[@class='inputs date-of-birth']/div/select[@name='DateOfBirthMonth']/option[7]");
    By selectDateOfBirthYear=By.xpath("//div[@class='inputs date-of-birth']/div/select[@name='DateOfBirthYear']/option[87]");
    By enterEmailLocator=By.xpath("//input[@id='Email']");
    By enterCompanyName=By.xpath("//input[@id='Company']");
    By enterPassword=By.xpath("//input[@id='Password']");
    By enterConfirmPassword=By.xpath("//input[@id='ConfirmPassword']");
    By buttonLocator=By.xpath("//button[@id='register-button']");
    By registrationMessageLocator=By.xpath("//div[@class='result']");

    protected WebDriver driver;
 /*   public ThreadLocal<selectDriverFactory> eDriver=new ThreadLocal<>();*/
        public RegistrationPage (WebDriver driver){

      this.driver=driver;
    }
    ElementActions eAction=new ElementActions(this.driver);


    public void selectGender(){
     /*   driver.findElement(genderMaleLocator).click();*/
         /*driver.clickButton(genderMaleLocator);*/
        /*eDriver.get().element().clickButton(genderMaleLocator);*/
        eAction.clickButton(genderMaleLocator);

    }

    public void enterFirstName( String firstName){
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void enterDOB(){
        driver.findElement(selectDateOfBirthDay).click();
        driver.findElement(selectDateOfBirthMonth).click();
        driver.findElement(selectDateOfBirthYear).click();
    }

    public void enterEmail(String email){
        driver.findElement(enterEmailLocator).sendKeys(email);
    }

    public void enterCompanyName(String companyName){
        driver.findElement(enterCompanyName).sendKeys(companyName);
    }

    public void enterPassword(String password){
        driver.findElement(enterPassword).sendKeys(password);
    }

    public void enterConfirmPassword(String ConfirmPassword){
        driver.findElement(enterConfirmPassword).sendKeys(ConfirmPassword);
    }

    public void clickRegisterButton(){
        driver.findElement(buttonLocator).click();
    }

    public void getRegistrationMessage(){
        Assert.assertEquals(driver.findElement(registrationMessageLocator).getText(),"Your registration completed");
    }




}
