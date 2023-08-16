package org.me.tests;

import org.junit.jupiter.api.Test;
import org.me.base.TestBase;
import org.me.pages.AddAdminPage;
import org.me.pages.AdminPage;
import org.me.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

public class TestAddAdmin extends TestBase {

    @Test
    public void addAdmin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AddAdminPage addAdminPage = PageFactory.initElements(driver, AddAdminPage.class);
        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        loginPage.openLoginPage();
        loginPage.loginToSite();
        addAdminPage.openPage();
        addAdminPage.createAdmin();
        assertThat(adminPage.checkAdmin()).isTrue();



    }
}
