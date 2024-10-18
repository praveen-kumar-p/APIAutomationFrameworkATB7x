package org.example.KatalonActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumkatalon {

        @Test
        public void testKatalonPage() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");

            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get("https://katalon-demo-cura.herokuapp.com/");

            Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
            Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

            driver.findElement(By.id("btn-make-appointment")).click();

            driver.quit();
        }

    }
