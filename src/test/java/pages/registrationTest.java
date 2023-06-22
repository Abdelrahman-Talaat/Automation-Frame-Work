package pages;

import BaseTest.BaseTest;
import Pages.RegistrationPage;
import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class registrationTest extends BaseTest {

    homePage home;
    RegistrationPage registrationPage;

    @Test
    public void registrationTest() {
        home = new homePage(driver.get().getDriver());
        registrationPage = new RegistrationPage(driver.get().getDriver());
        registrationPage = home.clickRegistrationPage();

    }
}
