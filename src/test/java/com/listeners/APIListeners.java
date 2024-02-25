package com.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.runner.Runner;

public class APIListeners implements ITestListener {
	private ExtentReports extentReports;
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;
	private static final String REPORT_DIR = System.getProperty("user.dir") + "/reports";

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		System.out.println("Test Case: " + result.getMethod().getMethodName() + " started...");
		System.out.println("Description: " + result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getTestName() + " PASSED!!!!");
		ITestContext testContext = result.getTestContext();
		extentTest.log(Status.INFO, (String) testContext.getAttribute("Data"));
		System.out.println("Test Case: " + result.getMethod().getMethodName() + " PASSED!!!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String errorMessage = result.getThrowable().getMessage();
		extentTest.log(Status.FAIL, errorMessage);
		extentTest.fail(result.getTestName() + " FAILED!!!!");
		System.out.println("Test Case: " + result.getMethod().getMethodName() + " FAILED!!!!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getTestName() + " Skipped!!!!");
		String errorMessage = result.getThrowable().getMessage();
		extentTest.log(Status.FAIL, errorMessage);
		System.out.println("Test Case: " + result.getMethod().getMethodName() + " skipped!!!!");
	}

	@Override
	public void onStart(ITestContext context) {
		extentReports = new ExtentReports();

		File reportDir = new File(REPORT_DIR);
		try {
			if (reportDir.exists()) {
				FileUtils.forceDelete(reportDir);
			}
			FileUtils.forceMkdir(reportDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
		String date = formatter.format(new Date());
		extentSparkReporter = new ExtentSparkReporter(
				REPORT_DIR + "/" + Runner.componentType + " " + Runner.testType + "reports-" + date + ".html");
		extentReports.attachReporter(extentSparkReporter);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("***************** Generating Reports for the tests..........");
		System.out.println("Report is CREATED at" + REPORT_DIR);
		extentReports.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
}
