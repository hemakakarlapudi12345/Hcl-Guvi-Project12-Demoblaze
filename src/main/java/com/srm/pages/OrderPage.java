package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By placeOrder = By.xpath("//button[text()='Place Order']");
    By name = By.id("name");
    By card = By.id("card");
    By purchase = By.xpath("//button[text()='Purchase']");

    By successMsg = By.xpath("//h2[text()='Thank you for your purchase!']");
    By okBtn = By.xpath("//button[text()='OK']");

    public void placeOrder(String n, String c) {

        click(placeOrder);

        wait.until(ExpectedConditions.visibilityOfElementLocated(name));

        type(name, n);
        type(card, c);

        click(purchase);
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return getText(successMsg);
    }

    public void clickOk() {
        click(okBtn);
    }
}