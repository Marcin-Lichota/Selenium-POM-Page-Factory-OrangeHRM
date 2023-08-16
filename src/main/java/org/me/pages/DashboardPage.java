package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {


    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement userMenu;
    @FindBy (xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;
    @FindBy (xpath = "//a[normalize-space()='']")
    WebElement adminLink;

    public void logout(){
        click(userMenu);
        click(logoutButton);

    }

}
