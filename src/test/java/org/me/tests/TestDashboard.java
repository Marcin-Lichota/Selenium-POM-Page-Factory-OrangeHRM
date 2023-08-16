package org.me.tests;

import org.junit.jupiter.api.Test;
import org.me.base.TestBase;
import org.me.pages.DashboardPage;
import org.me.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

public class TestDashboard extends TestBase {

        @Test
        public void logoutOfSite(){
            LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
            DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
            loginPage.openLoginPage();
            loginPage.loginToSite();
            dashboardPage.logout();

        }

    }

