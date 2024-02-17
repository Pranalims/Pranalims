package com.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class APIListeners implements ITestListener {
	private ExtentReports extentReports;
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		System.out.println("--------------------- " + result.getTestName() + "--------------------- ");
		System.out.println("--------------------- " + result.getMethod().getMethodName() + "--------------------- ");
		System.out.println("--------------------- " + result.getMethod().getDescription() + "---------------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.pass(result.getTestName() + " PASSED!!!!");
		ITestContext testContext = result.getTestContext();
		extentTest.log(Status.INFO, (String) testContext.getAttribute("Data"));

		System.out.println("--------------------- " + result.getTestName() + " PASSED!!!! ---------------------");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String errorMessage = result.getThrowable().getMessage();
		extentTest.log(Status.FAIL, errorMessage);
		extentTest.fail(result.getTestName() + " Failed!!!!");
		System.out.println("--------------------- " + result.getTestName() + " FAILED!!!! ---------------------");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getTestName() + " Skipped!!!!!");
		String errorMessage = result.getThrowable().getMessage();
		extentTest.log(Status.FAIL, errorMessage);
		System.out.println("--------------------- " + result.getTestName() + " skipped!!!! ---------------------");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extentReports = new ExtentReports();
		// Code which will create an empty folder called us!!
		// check if the report is present.... if not presnet create onme
		// else delete it and then create us

		String reportPath = System.getProperty("user.dir") + "//reports";
		File f = new File(reportPath); // java io
		if (f.exists()) {
			try {
				FileUtils.forceDelete(f);
				FileUtils.forceMkdir(f);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				FileUtils.forceMkdir(f);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("DD-MM-yyyy-HH-mm");
		String data=formater.format(date);
		extentSparkReporter = new ExtentSparkReporter(reportPath+"//report-"+data+".html");
		extentReports.attachReporter(extentSparkReporter);

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

	}

}
