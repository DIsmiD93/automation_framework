package com.framework.tests.ui;

import com.framework.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){
        DriverManager.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}