package com.srm.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class ProductTest extends BaseTest {

    String user = "SravyaAlahari11";
    String pass = "1234";
    

    @Test
    public void verifyPhonesCategoryLoaded() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();

        int productCount = driver.findElements(By.cssSelector(".card-title")).size();

        Assert.assertTrue(productCount > 0, "Phones category not loaded");

        System.out.println("Phones Category Loaded");
    }

    @Test
    public void verifyProductDetailsDisplayed() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        String productName = pp.getProductName();

        Assert.assertTrue(productName.length() > 0, "Product name not displayed");

        System.out.println("Product Details Verified");
    }

    @Test
    public void verifyHomeReloadsProducts() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.clickHome();

        int totalProducts = driver.findElements(By.cssSelector(".card-title")).size();

        Assert.assertTrue(totalProducts > 0, "Home page did not reload products");

        System.out.println("Home Reload Verified");
    }
}