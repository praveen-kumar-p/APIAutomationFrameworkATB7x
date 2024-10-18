package org.example.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class selenium09 {

    //get VS Navigate.to()

    public static void main(String[] args) throws MalformedURLException {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://app.vwo.com");
        // No back, forward allowed in case of get


        chromeDriver.navigate().to("https://app.vwo.com");
        chromeDriver.navigate().to(new URL("https://google.com"));
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();
    }
}
