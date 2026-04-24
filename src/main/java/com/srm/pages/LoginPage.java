package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By signupBtn = By.id("signin2");
    By signupUser = By.id("sign-username");
    By signupPass = By.id("sign-password");
    By signupSubmit = By.xpath("//button[text()='Sign up']");

    By loginBtn = By.id("login2");
    By loginUser = By.id("loginusername");
    By loginPass = By.id("loginpassword");
    By loginSubmit = By.xpath("//button[text()='Log in']");
    By welcomeUser = By.id("nameofuser");

    public void signUp(String user, String pass) {

        click(signupBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupUser));
        type(signupUser, user);
        type(signupPass, pass);

        click(signupSubmit);
    }

    public void login(String user, String pass) {

        click(loginBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUser));

        type(loginUser, user);
        type(loginPass, pass);

        click(loginSubmit);

        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeUser));
    }

    public String getWelcomeText() {
        return getText(welcomeUser);
    }
}