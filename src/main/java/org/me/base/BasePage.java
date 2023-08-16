package org.me.base;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {



    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void implicitWait(int noOfSeconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(noOfSeconds));
    }

    public void waitForClickable(final WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void goToUrl(String url){
        driver.get(url);
    }

    public void writeText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public void clearWebField(WebElement element){
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
    public void click(WebElement element){
        element.click();
    }

    public void moveToElement(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();

    }

}
