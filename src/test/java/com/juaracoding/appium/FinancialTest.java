package com.juaracoding.appium;

import com.juaracoding.appium.pages.Financial;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FinancialTest {
    private static AndroidDriver<MobileElement> driver;
    private Financial financial;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "POCO");
        capabilities.setCapability("udid", "219c0dcc");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void pageObject() {
        financial = new Financial(driver);
    }

    @Test (priority = 1)
    public void testIncome(){
        financial.add();
        financial.income();
        financial.getTextNoteIncome();
        System.out.println(financial.getTextNoteIncome());
        Assert.assertEquals(financial.getTextNoteIncome(), "Bonus");
    }

    @Test (priority = 2)
    public void testOutcome(){
        financial.add();
        financial.outcome();
        financial.getTextNoteOutcome();
        System.out.println(financial.getTextNoteOutcome());
        Assert.assertEquals(financial.getTextNoteOutcome(), "Pizza Hut");
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}
