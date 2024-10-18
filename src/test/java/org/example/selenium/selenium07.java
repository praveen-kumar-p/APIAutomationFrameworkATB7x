package org.example.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class selenium07 {

    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/test/java/org/example/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_9_3_0.crx"));

        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://app.vwo.com");
        chromeDriver.quit();
    }
}
