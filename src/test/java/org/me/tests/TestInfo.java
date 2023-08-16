package org.me.tests;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.me.base.TestBase;
import org.me.pages.InfoPage;
import org.me.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class TestInfo extends TestBase {

    @Test
    public void changingName() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        InfoPage infoPage = PageFactory.initElements(driver, InfoPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        infoPage.openPage();
        Thread.sleep(3000);
        infoPage.changingName();
        Thread.sleep(3000);
        infoPage.openPage();
        Thread.sleep(3000);
        assertThat(infoPage.getName()).isEqualTo("Paolo Koalo");
    }
    @Test
    @Order(1)
    public void attachingFileToUser() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        InfoPage infoPage = PageFactory.initElements(driver, InfoPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        infoPage.openPage();
        infoPage.uploadFile();
        Thread.sleep(3000);
        assertThat(infoPage.getAttachment().isDisplayed()).isTrue();
    }
    @Test
    @Order(2)
    public void downloadAttachment() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        InfoPage infoPage = PageFactory.initElements(driver, InfoPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        infoPage.openPage();
        Thread.sleep(3000);
        assertThat(infoPage.downloadFile()).isEqualTo("test");

    }
    @Test
    public void changeGender() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        InfoPage infoPage = PageFactory.initElements(driver, InfoPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        infoPage.openPage();
        Thread.sleep(5000);
        String a = infoPage.genderBender();
        Thread.sleep(5000);
        if (Objects.equals(a, "female")) {
            assertThat(infoPage.getMaleRadio().isSelected()).isFalse();
        } else {
            assertThat(infoPage.getMaleRadio().isSelected()).isTrue();
        }
    }
}

