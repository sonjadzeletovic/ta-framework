package com.test.workshop.testta.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
  /*      //Incijalizacija web drivera
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();*/

  //podrska za 4 browser-a
        WebDriver driver = null;
        String browser = System.getProperty("browser");
        String chromeBrowser = "chrome";
        String firefoxBrowser = "firefox";
        String edgeBrowser = "edge";
        String ieBrowser = "explorer";

       /* WebDriverManager.chromedriver().setup(); //storuje u maven putanji
        driver = new ChromeDriver();*/
        if (browser.equalsIgnoreCase(chromeBrowser)) {
            WebDriverManager.chromedriver().setup(); //storuje u maven putanji
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(firefoxBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase(edgeBrowser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase(ieBrowser)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Uneli smo nepodrzani browser");
        }

        return driver;
    }
}
