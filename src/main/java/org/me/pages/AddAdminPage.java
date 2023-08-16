package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddAdminPage extends BasePage {
    WebDriver driver;
    public AddAdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
    WebElement adminRoleListActivator;
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement adminRoleAdmin;
    @FindBy(xpath = "//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
    WebElement adminStatusListActivator;
    @FindBy(xpath = "//div[@role='listbox']//div[2]")
    WebElement adminStatusEnabled;
    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement adminNameInput;
    @FindBy(xpath = "//span[contains(text(),'Paolo')]")
    WebElement placeholder1;
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement adminUsernameInput;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement adminPasswordInput;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement adminCheckPasswordInput;
    @FindBy(css = "button[type='submit']")
    WebElement adminSaveButton;


    public void openPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
    }

    // Tried to use Select class here but element's type is div
    public void setSelAdminRole()    {
        click(adminRoleListActivator);
        click(adminRoleAdmin);
    }
    public void setSelAdminStatus(){
        click(adminStatusListActivator);
        click(adminStatusEnabled);
    }

    public void setAdminName(){
        writeText(adminNameInput,"Paolo" );
        waitForClickable(placeholder1);
        click(placeholder1);
    }
    public void setAdminUsername(){
        writeText(adminUsernameInput, "123456");
    }
    public void setAdminPassword(){
        writeText(adminPasswordInput, "bubu123");
        writeText(adminCheckPasswordInput,"bubu123");
    }
    public void createAdmin(){
        setSelAdminRole();
        setSelAdminStatus();
        setAdminName();
        setAdminUsername();
        setAdminPassword();
        click(adminSaveButton);
    }
}

