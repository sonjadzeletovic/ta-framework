package com.test.workshop.testta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage{

    @FindBy(css = ".panel-title")
    private WebElement welcomePageTitle;

    @FindBy(css = ".glyphicon-log-out")
    private WebElement logoutButton;

    private String expectedWelcomePage = "Hello, and welcome to our gamers page!";

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomePageTitle(){
        log.debug("getWelcomePageTitle()");
        return welcomePageTitle.getText();
    }

    public String getExpectedWelcomePageTitle(){
        return expectedWelcomePage;
    }

    public LoginPage clickOnLogoutButton(){
        log.debug("clickOnLogoutButton()");
        waitForElementToBeVisible(logoutButton);
        logoutButton.click();
        return new LoginPage(driver); // da bi drajver uvek imao aktuelne web elemente ako se nesto promeni
    }
}
