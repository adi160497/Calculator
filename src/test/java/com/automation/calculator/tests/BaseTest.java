package com.automation.calculator.tests;

import com.automation.calculator.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriver webD;
        String browser = ConfigReader.getBrowserName();
        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                webD = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                  webD = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                 webD = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
        driver.set(webD);
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getBaseUrl());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        if(getDriver()!=null){
            getDriver().quit();
            driver.remove();
        }
    }
}
