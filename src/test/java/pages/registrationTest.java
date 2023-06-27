package pages;

import BaseTest.BaseTest;
import ElementActions.ElementActions;
import Pages.RegistrationPage;
import Pages.homePage;
import driverFactory.selectDriverFactory;
import org.testng.annotations.Test;

public  class RegistrationTest extends BaseTest {
    homePage home;
    RegistrationPage registration;

    @Test (suiteName = "registration")
    public void registrationTest(){
        home=new homePage(driver.get());
        registration=new RegistrationPage(driver.get());
        registration=home.clickRegistrationPage();
        registration.selectGender();
      /*  registration.enterFirstName("Abdelrahman");
        registration.enterLastName("Talaat");
        registration.enterDOB();
        registration.enterEmail("abdelrahmantalaat26@gmail.com");
        registration.enterCompanyName("Etisalat");
        registration.enterPassword("Abdelrahman");
        registration.enterConfirmPassword("Abdelrahman");
        registration.clickRegisterButton();
        registration.getRegistrationMessage();*/
    }

}
