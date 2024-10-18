package org.example.seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selebium10 {

    // Open the app.vwo.com
    // We want to verify the title by using the TestNG assertion.

    @Test
    public void testVWOLoginPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://app.vwo.com");

//        driver.manage().window().maximize();
//        driver.manage().window().minimize();
        Assert.assertEquals(webDriver.getTitle(), "Login - VWO");
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://app.vwo.com/#/login");
        webDriver.quit();
    }
}
