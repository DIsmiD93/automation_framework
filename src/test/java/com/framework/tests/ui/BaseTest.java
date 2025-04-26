package com.framework.tests.ui;

import com.framework.drivers.DriverManager;
import com.framework.tests.listeners.AllureListener;
import org.testng.annotations.*;

@Listeners(AllureListener.class)
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