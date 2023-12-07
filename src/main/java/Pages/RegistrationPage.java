package Pages;

import Assertions.Assertion;
import ElementActions.ElementActions;
import driverFactory.selectDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import utilities.UserFormData;

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
    By continueButtonLocator=By.xpath("//a[@ class='button-1 register-continue-button']");
    By welcomeMessageLocator=By.xpath("//div[@class='topic-block'] /div/h2");


    protected WebDriver driver;
    ElementActions eAction  ;
    UserFormData userData;
 /*   public ThreadLocal<selectDriverFactory> eDriver=new ThreadLocal<>();*/
        public RegistrationPage (WebDriver driver){
            this.driver=driver;
            eAction=new ElementActions(driver);
            userData=new UserFormData(driver);
    }



    public void selectGender(){
        eAction.click(genderMaleLocator);
    }

    public void enterFirstName(){
        eAction.sendData(userData.getFirstName(),firstNameLocator);
    }

    public void enterLastName(){

            eAction.sendData(userData.getLastName(),lastNameLocator);
    }

    public void enterDOB(){
        eAction.click(selectDateOfBirthDay);
        eAction.click(selectDateOfBirthMonth);
        eAction.click(selectDateOfBirthYear);
    }

    public void enterEmail(){
            eAction.sendData(userData.getEmail(),enterEmailLocator);
    }

    public void enterCompanyName(){
        eAction.sendData(userData.getCompanyName(),enterCompanyName);
    }

    public void enterPassword(){
        eAction.sendData(userData.getNewPassword(),enterPassword);
    }

    public void enterConfirmPassword(){
        eAction.sendData(userData.getNewPassword(), enterConfirmPassword);
    }

    public void clickRegisterButton(){
        eAction.click(buttonLocator);
    }

    public void clickContinueButton(){
            eAction.click(continueButtonLocator);
    }

    public void getWelcomeMessage(){
        Assertion.assertEquals(eAction.getText(welcomeMessageLocator),"Welcome to our store");
    }

    public void getRegistrationMessage(){
        Assertion.assertEquals(eAction.getText(registrationMessageLocator),"Your registration completed");
    }





}
