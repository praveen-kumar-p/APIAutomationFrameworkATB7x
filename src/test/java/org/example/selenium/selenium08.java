package org.example.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class selenium08 {

    @Test
    public void testQuickVsClose(){
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://app.vwo.com");

        chromeDriver.close();
        // Close the Current Browser Window - not the full browser
        // Closed the window, Session id != null, Error - Invalid session ID

        chromeDriver.quit();
        // Close all the /sessions/windows and stop the browser
        // driver.quit(); // Closed All the window and Session = null, Error - Session ID is null
    }
}
