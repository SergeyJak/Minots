package org.selenium.example.resources;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntegrationTestParent {

    protected static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty(Constants.WEB_DRIVER, Constants.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Constants.SPORT_DER_URL);
        driver.manage().window().fullscreen();
    }

    @After
    public void testEnd(){
        driver.close();
    }
}
