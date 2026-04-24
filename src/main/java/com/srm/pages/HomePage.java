package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By phones = By.linkText("Phones");
    By allProducts = By.cssSelector(".card-title a");

    public void clickPhones() {
        click(phones);

        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        driver.findElements(allProducts).get(0).click();
    }

    public void clickHome() {
        driver.findElement(By.linkText("Home")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
    }
}