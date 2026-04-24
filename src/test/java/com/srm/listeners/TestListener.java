package com.srm.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.*;
import com.srm.utils.ExtentManager;
import com.srm.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test PASSED");
        System.out.println(result.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test FAILED");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String path = ScreenshotUtil.capture(driver, result.getName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.getName() + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test SKIPPED");
        System.out.println(result.getName() + " SKIPPED");
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); 
    }
}