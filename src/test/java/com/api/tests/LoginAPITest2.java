package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.LoginRequestPOJO;
import com.util.TestUtility;

import io.restassured.http.Header;

@Listeners(com.listeners.APIListeners.class)
@Test(testName = "SAmple API Test Class")
public class LoginAPITest2 {
	LoginRequestPOJO loginRequestPOJO;
	String jsonData;
	Header myHeader;
	Header myHeader2;

	
	@Test(description = "Verify if the User is able to Login into the Application via api ", groups = { "api", "sanity",
			 "e2e" }, retryAnalyzer = com.listeners.RetryAnalyzer.class)
	public void sampleTest() {

		System.out.println("My Sample Test");
		Assert.assertEquals(1, 1);
	}

}
