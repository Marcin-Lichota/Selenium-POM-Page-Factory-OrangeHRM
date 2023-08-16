package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement adminSearchBar;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement adminSubmitButton;
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement adminResetButton;
    @FindBy(xpath = "(//div[contains(text(),'123456')])[1]")
    WebElement adminChecker;

    public boolean checkAdmin(){
        implicitWait(5);
        return adminChecker.isDisplayed();
    }

}

