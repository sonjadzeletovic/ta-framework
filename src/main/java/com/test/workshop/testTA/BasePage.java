package com.test.workshop.testTA;

import com.test.workshop.testTA.utilis.Time;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.test.workshop.testTA.utilis.Time.SHORT;

public class BasePage {

    protected WebDriver driver = null; // koristicemo u celoj biblioteci, bilo ko iz biblioteke moze da pristupi promenljivoj
    // zato je protected

    protected static Log log = LogFactory.getLog(BasePage.class); // log je staticki objekat i vezan je za base page

    public BasePage(WebDriver driver){

        this.driver = driver;
        log = LogFactory.getLog(this.getClass());
        PageFactory.initElements(driver,this); // sve varijable se refresh pri novom pozivu, uzima
        // naziv varijable i to trazi po strani
    }

    public BasePage waitForElementToBeVisible(WebElement webElement) {
        log.debug("waitForElementToBeVisible()");
        try {
            WebDriverWait wait = new WebDriverWait(driver, SHORT);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public void quitWebDriver(){
        log.debug("quitWebDriver()");
        if (driver != null){
            driver.quit();
        }
    }
}
