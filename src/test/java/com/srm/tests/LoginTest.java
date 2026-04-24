package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class LoginTest extends BaseTest {

    public static String user;

    @Test(priority = 1)
    public void signUpTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());

        user = "SravyaAlahari11";

        lp.signUp(user, "1234");

        String alert = lp.getAlertText();
        lp.waitForAlertAndAccept();

        Assert.assertTrue(alert.contains("Sign up successful"));

        System.out.println("Signup Done: " + user);
    }

    @Test(priority = 2)
    public void loginTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());

        lp.login(user, "1234");

        Assert.assertTrue(lp.getWelcomeText().contains(user));

        System.out.println("Login Successful with: " + user);
    }
}