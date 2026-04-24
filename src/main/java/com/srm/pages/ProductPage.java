package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By productName = By.className("name");
    By addToCart = By.linkText("Add to cart");

    public String getProductName() {
        return getText(productName);
    }

    public void addToCart() {
        click(addToCart);
    }
}