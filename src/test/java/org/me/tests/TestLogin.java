package org.me.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.me.base.TestBase;
import org.me.pages.LoginPage;

public class TestLogin extends TestBase {

    @Test
    @Disabled
    public void testingLoginToVWO(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToSite();
    }


}

