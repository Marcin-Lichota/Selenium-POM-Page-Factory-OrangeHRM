package org.me.pages;

import org.me.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class InfoPage extends BasePage {

    public InfoPage(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    @FindBy(xpath = "(//input[@placeholder='First Name'])[1]")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save'])[1]")
    WebElement personalDetailsSave;
    @FindBy(xpath = "//label[normalize-space()='Male']")
    WebElement genderMale;
    @FindBy(css = "div[class='oxd-radio-wrapper'] input[value='1']")
    WebElement maleRadio;
    @FindBy(xpath = "//label[normalize-space()='Male']/child::span[@class='oxd-radio-input oxd-radio-input--focus --label-right oxd-radio-input']")
    WebElement maleSelected;
    @FindBy(xpath = "//label[normalize-space()='Female']")
    WebElement genderFemale;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement uploadActivator;
    @FindBy(xpath = "//div[@class='oxd-file-button']" )
    WebElement uploadButton;

    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save'])[3]")
    WebElement saveAttachment;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement nameOnDashboard;
    @FindBy(xpath = "//div[contains(text(),'testfile.txt')]")
    WebElement attachmentFile;

    @FindBy(xpath = "(//div[contains(text(),'testfile')])[1]/parent::div/following-sibling::div/child::div/child::button[3]")
    WebElement attachmentDownloadButton;

    public void openPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

    }

    public void changingName() throws InterruptedException {
        //writeText(firstNameInput,"Paolo");
        Thread.sleep(1000);
        waitForClickable(personalDetailsSave);
        firstNameInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        firstNameInput.sendKeys("Paolo");
        lastNameInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        lastNameInput.sendKeys("Koalo");
        implicitWait(3);
        click(personalDetailsSave);


    }
    public String getName(){
        return nameOnDashboard.getText();
    }
    public String genderBender() throws InterruptedException {

        waitForClickable(personalDetailsSave);
        if (maleRadio.isSelected() ){
            waitForClickable(genderFemale);
            click(genderFemale);
            String a= "female";
            click(personalDetailsSave);
            return a;
        }else {
            click(genderMale);
            String a = "male";
            click(personalDetailsSave);
            return a;
        }

    }

    public WebElement getMaleRadio(){
        return maleRadio;
    }

    public void uploadFile() {
        click(uploadActivator);
        click(uploadButton);
        implicitWait(3);
        // creating object of Robot class
        try {Robot rb = new Robot();
            // copying File path to Clipboard
            StringSelection str = new StringSelection("C:\\Users\\Ja\\Desktop\\testfile.txt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            // for pressing and releasing Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }

        implicitWait(3);
        click(saveAttachment);
        implicitWait(3);

    }
    public WebElement getAttachment(){
        return attachmentFile;
    }
    public String downloadFile() throws InterruptedException {
        waitForClickable(attachmentDownloadButton);
        click(attachmentDownloadButton);
        Thread.sleep(3000);
        return fileToString();
    }
    public String fileToString(){
        Path filePath= Paths.get("C:\\Users\\Ja\\Downloads\\testfile.txt");
        try
        {
           return Files.readString(filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

