package com.test.workshop.TestTA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolsSQAPracticeForm {

    @Test
    public void testToolsSQA() throws InterruptedException {

        String expectedText = "Practice Automation Form";
        String firstName = "Sonja";
        String lastName = "Dzeletovic";
        String date = "29/3/2019";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();



        driver.get("https://www.toolsqa.com/automation-practice-form/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement titleTextElement = driver.findElement(By.xpath("//div[@class = 'wpb_text_column wpb_content_element ']/div/h1[contains(text(),'Practice Automation Form')]"));

        Assert.assertEquals(titleTextElement.getText(),expectedText);

        WebElement firstNameTextField = driver.findElement(By.name("firstname"));
        WebElement lastNameTextField = driver.findElement(By.name("lastname"));

        firstNameTextField.sendKeys(firstName);
        Thread.sleep(2000);
        lastNameTextField.sendKeys(lastName);
        Thread.sleep(2000);

        WebElement maleRadioButton = driver.findElement(By.id("sex-0"));
        WebElement femaleRadioButton = driver.findElement(By.id("sex-1"));

        femaleRadioButton.click();

        WebElement yearsOfExperienceRadioButton = driver.findElement(By.id("exp-2"));
        yearsOfExperienceRadioButton.click();

        Thread.sleep(2000);

        WebElement datePickerTextField = driver.findElement(By.id("datepicker"));
        datePickerTextField.sendKeys(date);
        Thread.sleep(2000);

        WebElement professionCheckBox = driver.findElement(By.id("profession-1"));
        professionCheckBox.click();
        Thread.sleep(2000);


        WebElement automationToolCheckBox = driver.findElement(By.id("tool-2"));
        automationToolCheckBox.click();
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        driver.quit();
    }
}
