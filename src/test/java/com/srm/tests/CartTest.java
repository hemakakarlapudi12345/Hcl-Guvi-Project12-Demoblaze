package com.srm.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CartTest extends BaseTest {

    String user = "SravyaAlahari11";
    String pass = "1234";

    @Test
    public void addSingleProductToCartTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        String productName = pp.getProductName();

        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        String cartItem = driver.findElement(By.xpath("//td[2]")).getText();

        Assert.assertEquals(cartItem, productName);

        System.out.println("Single product verified");
    }

    @Test
    public void addMultipleProductsTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();
        pp.addToCart();
        pp.waitForAlertAndAccept();

        driver.navigate().back();
        driver.navigate().back();

        hp.selectFirstProduct();
        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        int items = driver.findElements(By.xpath("//tbody/tr")).size();

        Assert.assertTrue(items >= 2);

        System.out.println("Multiple products verified");
    }

    @Test
    public void deleteProductFromCartTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        cp.deleteItem();

        int count = driver.findElements(By.xpath("//tbody/tr")).size();

        Assert.assertTrue(count == 0);

        System.out.println("Delete verified");
    }

    @Test
    public void verifyWrongProductInCart_Negative() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        String cartItem = driver.findElement(By.xpath("//td[2]")).getText();

        Assert.assertEquals(cartItem, "Wrong Product"); 
    }
}