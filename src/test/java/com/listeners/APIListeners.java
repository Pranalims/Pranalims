package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class APIListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("--------------------- " + result.getTestName() + "--------------------- ");
		System.out.println("--------------------- " + result.getMethod().getMethodName() + "--------------------- ");
		System.out.println("--------------------- " + result.getMethod().getDescription() + "---------------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("--------------------- " + result.getTestName() + " PASSED!!!! ---------------------");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("--------------------- " + result.getTestName() + " FAILED!!!! ---------------------");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("--------------------- " + result.getTestName() + " skipped!!!! ---------------------");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
