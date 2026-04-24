package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By cart = By.id("cartur");
    By deleteBtn = By.linkText("Delete");
    By rows = By.xpath("//tbody/tr");

    public void openCart() {
        click(cart);
        wait.until(ExpectedConditions.visibilityOfElementLocated(rows));
    }

    public void deleteItem() {
        waitForElement(deleteBtn);
        click(deleteBtn);

        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(rows, 1));
    }
}