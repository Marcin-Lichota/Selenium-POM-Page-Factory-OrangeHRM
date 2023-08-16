package org.me.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.me.utilities.DriverManager;
import org.openqa.selenium.WebDriver;


public class TestBase extends DriverManager  {

    public WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = getDriver();
    }
    @AfterEach
    public void tearDown(){
        driver.quit();

    }



}
