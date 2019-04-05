package com.test.workshop.TestTA;

import com.test.workshop.testTA.LoginPage;
import com.test.workshop.testTA.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutTest {

    @Test
    public void testLoginLogout() {

        String username = "user";
        String password = "password";

       /* //Incijalizacija web drivera
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        //otvori login stranu i uloguj se
        LoginPage loginPage = new LoginPage();
        loginPage.openAs("http://192.168.5.157:9091/");

        WelcomePage welcomePage = loginPage.login(username,password);

        //Verifikuj da se welcome strana otvorila

        Assert.assertEquals(welcomePage.getWelcomePageTitle(),welcomePage.getExpectedWelcomePageTitle());

        //Logout i vrati se nazad na logIn stranu

        loginPage = welcomePage.clickOnLogoutButton();

        //Verifikuj da se adekvatna poruka prikazala na login strani
        Assert.assertEquals(loginPage.getAlertSuccessMessageLogout(),loginPage.getExpectedWelcomePageTitle() );

        loginPage.quitWebDriver();
    }
}
