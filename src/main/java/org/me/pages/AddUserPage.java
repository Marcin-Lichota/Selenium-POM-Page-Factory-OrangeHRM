package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends BasePage {
    WebDriver driver;
    public AddUserPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void openPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
    }

    @FindBy(css = "input[placeholder='First Name']")
    WebElement firstNameInput;
    @FindBy(css = "input[placeholder='Last Name']")
    WebElement lastNameInput;
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement idInput;
    @FindBy(css = "button[type='submit']")
    WebElement saveUserButton;


    public void addUser(){
        writeText(firstNameInput, "qwer");
        writeText(lastNameInput, "123");
        writeText(idInput, "6");
        click(saveUserButton);

    }

}
