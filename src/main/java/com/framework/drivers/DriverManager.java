package com.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThread =  new ThreadLocal<>();

    private DriverManager(){
    }

    public static void initDriver(String browserName){
        if(driverThread.get()==null){
            String runType = System.getProperty("runType", "local");
            WebDriver driver;
            if(runType.equalsIgnoreCase("remote")) {
                //Todo add to properties file
                String seleniumGridUrl = "http://selenium-hub:4444/wd/hub";
                try {
                    switch (browserName.toLowerCase()) {
                        case "firefox":
                            driver = new RemoteWebDriver(new URL(seleniumGridUrl), new FirefoxOptions());
                            break;
                        case "edge":
                            driver = new RemoteWebDriver(new URL(seleniumGridUrl), new EdgeOptions());
                            break;
                        case "chrome":
                        default:
                            driver = new RemoteWebDriver(new URL(seleniumGridUrl), new ChromeOptions());
                            break;
                    }
                } catch (MalformedURLException malformedURLException){
                    throw new RuntimeException(String.format("Invalid Selenium Grid URL: %s", seleniumGridUrl));
                }
            }else {
                switch (browserName.toLowerCase()) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "chrome":
                    default:
                        driver = new ChromeDriver();
                        break;
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driverThread.set(driver);
        }
    }

    public static WebDriver getDriver(){
        return driverThread.get();
    }

    public static void quitDriver(){
        if(driverThread.get()!=null){
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}
