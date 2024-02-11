package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	static int count =1;
	static final int MAX_ATTEMPT = 3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<=MAX_ATTEMPT) {
			count = count+1;
			return true;
		}
		return false; // the test will not be executed again and will marked as a failed!
	}

}
