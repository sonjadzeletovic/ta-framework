package com.test.workshop.testta;

import com.test.workshop.testta.webDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    // Locators
    @FindBy( id = "username") // da pronadjemo locatore
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(css = ".btn-primary")
    private WebElement loginButton;

    @FindBy(xpath = "//div/div[@class = 'panel-body']/div[@class = 'alert alert-success']")
    private  WebElement alertSuccessMessageLogout;

    private String expectedLogotMessage = "You have been logged out.";
    //Constructor

    public LoginPage(){
        super(WebDriverFactory.getDriver());
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage openAs(String url){
        log.debug("openAs()");
        driver.get(url);
        return this;
    }

    public LoginPage typeUsername(String username){
        log.debug("typeUsername()");
        waitForElementToBeVisible(usernameTextField);
        usernameTextField.clear();
        usernameTextField.sendKeys(username);
        return this; //metode koje ne vracaju nista trebalo bi da vrate tu stranu
    }

    public LoginPage typePassword(String password){
        log.debug("typePassword()");
        waitForElementToBeVisible(passwordTextField);
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
        return this;
    }

    public WelcomePage clickOnLogin(){ //navigacione metode
        log.debug("clickOnLogin()");
        waitForElementToBeVisible(loginButton);
        loginButton.click();
        return new WelcomePage(driver);
    }

    public WelcomePage login(String username, String password){
        log.debug("login as " +username);
        typeUsername(username);
        typePassword(password);
        return clickOnLogin();
    }

    public String getExpectedWelcomePageTitle(){
        log.debug("getExpectedWelcomePageTitle()");
        return  expectedLogotMessage;
    }

    public String getAlertSuccessMessageLogout(){
        log.debug("getAlertSuccessMessageLogout");
        waitForElementToBeVisible(alertSuccessMessageLogout);
        return alertSuccessMessageLogout.getText();
    }

}
