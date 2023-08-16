package org.me.tests;

import org.junit.jupiter.api.Test;
import org.me.base.TestBase;
import org.me.pages.*;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAddUser extends TestBase {

    @Test
    public void addAndDeleteUser() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AddUserPage addUserPage = PageFactory.initElements(driver, AddUserPage.class);
        PimPage pimPage = PageFactory.initElements(driver, PimPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        addUserPage.openPage();
        addUserPage.addUser();
        pimPage.openPage();
        pimPage.implicitWait(3);
        pimPage.searchForUser();
        assertThat(pimPage.checkUser()).isTrue();
        pimPage.implicitWait(3);
        pimPage.deleteUser();
        pimPage.implicitWait(3);
        assertThat(pimPage.checkUser()).isFalse();

    }
}
