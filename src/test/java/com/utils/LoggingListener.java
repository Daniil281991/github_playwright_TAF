package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoggingListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerHandler.info(result.getMethod().getMethodName() + " started!");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerHandler.info(result.getMethod().getMethodName() + " Passed!");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerHandler.info(result.getMethod().getMethodName() + " Failed because of " + result.getThrowable());
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerHandler.info(result.getMethod().getMethodName() + " Skipped because of " + result.getThrowable());
        ITestListener.super.onTestSkipped(result);
    }
}
