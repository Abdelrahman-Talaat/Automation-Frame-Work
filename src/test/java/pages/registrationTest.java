package pages;

import Assertions.Assertion;
import BaseTest.BaseTest;
import Pages.RegistrationPage;
import Pages.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public  class RegistrationTest extends BaseTest {
    homePage home;
    RegistrationPage registration;


    @Test  (suiteName = "registration"/*,retryAnalyzer = IRetryAnalyzerClass.class*/)

    public void registrationTest(){
        home=new homePage(driver.get());
        registration=home.clickRegistrationPage();
        registration.selectGender();
        registration.enterFirstName();
        registration.enterLastName();
        registration.enterDOB();
        registration.enterEmail();
        registration.enterCompanyName();
        registration.enterPassword();
        registration.enterConfirmPassword();
        registration.clickRegisterButton();
        registration.getRegistrationMessage();
        registration.clickContinueButton();
        registration.getWelcomeMessage();
        /* Assertion.assertTrue(false);*/
    }


}
