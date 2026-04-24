package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class OrderTest extends BaseTest {

    String user = "SravyaAlahari11";
    String pass = "1234";

    @Test
    public void placeOrderSuccessTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());
        OrderPage op = new OrderPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        op.placeOrder("Sravya", "522034");

        String message = op.getSuccessMessage();

        Assert.assertEquals(message, "Thank you for your purchase!");

        op.clickOk();

        System.out.println("Order placed successfully");
    }

    @Test
    public void placeOrderWithoutNameTest() {

        LoginPage lp = new LoginPage(driver, config.getTimeout());
        HomePage hp = new HomePage(driver, config.getTimeout());
        ProductPage pp = new ProductPage(driver, config.getTimeout());
        CartPage cp = new CartPage(driver, config.getTimeout());
        OrderPage op = new OrderPage(driver, config.getTimeout());

        lp.login(user, pass);

        hp.clickPhones();
        hp.selectFirstProduct();

        pp.addToCart();
        pp.waitForAlertAndAccept();

        cp.openCart();

        op.placeOrder("", "522034");

        Assert.fail("Order placed without name → BUG detected");
           System.out.println("order failed bcoz Name is not given");
        }
    }