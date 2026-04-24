package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class SignupTest extends BaseTest {

    public static String user;

    @Test
    public void signUpTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());

        user = "DoremonTesting" ;

        lp.signUp(user, "1234");

        String alert = lp.getAlertText();
        lp.waitForAlertAndAccept();

        Assert.assertTrue(alert.contains("Sign up successful"));
    }
}