package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimPage extends BasePage {

    public PimPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @FindBy(xpath = "//div[contains(text(),'qwer')]")
    WebElement userCheker;
    @FindBy(xpath = "(//div[contains(text(),'qwer')])[1]/parent::div/following-sibling::div/child::div/child::button[1]")
    WebElement deleteUserButton;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement deleteConfirmButton;
    @FindBy (xpath  ="(//input[@placeholder='Type for hints...'])[1]")
    WebElement employeeNameInput;
    @FindBy(xpath = "//span[contains(text(),'qwer')]")
    WebElement placeholder2;
    @FindBy(css = "button[type='submit']")
    WebElement searchUserButton;
    public void searchForUser(){
        writeText(employeeNameInput, "qwer");
        click(placeholder2);
        click(searchUserButton);
    }
    public void openPage(){
        goToUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }
    public boolean checkUser(){

    try {
        return userCheker.isDisplayed();
    } catch (Exception e ) {
            System.out.println("No such user");
        return false;
    }

    }
    public void deleteUser(){
        click(deleteUserButton);
        click(deleteConfirmButton);
    }

}
