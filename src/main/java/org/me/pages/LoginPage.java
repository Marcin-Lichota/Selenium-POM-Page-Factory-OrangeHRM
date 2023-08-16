package org.me.pages;

import org.me.base.BasePage;
import org.me.utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(css="input[placeholder='Username']")
    WebElement userName;
    @FindBy(name="password")
    WebElement password;
    @FindBy(css="button[type='submit']")
    WebElement loginButton;


    public void openLoginPage() {
        goToUrl(PropertyReader.readItem("url"));
    }

    public void loginToSite(){
        implicitWait(5);
        writeText(userName, PropertyReader.readItem("username"));
        writeText(password, PropertyReader.readItem("password"));
        click(loginButton);
    }

//    public String signInText(){
//        String e = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']")).getText();
//        return e;
//    }
//    public DashboardPage afterLogin(){
//        return new DashboardPage(driver);
//    }


}

