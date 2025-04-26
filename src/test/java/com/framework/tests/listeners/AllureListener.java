package com.framework.tests.listeners;

import com.framework.drivers.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener extends AllureTestNg implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        saveScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type="image/png")
    private byte[] saveScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
