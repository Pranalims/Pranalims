package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.LoginRequestPOJO;
import com.util.TestUtility;

import io.restassured.http.Header;

public class LoginAPITest {
	LoginRequestPOJO loginRequestPOJO;
	String jsonData;
	Header myHeader;
	Header myHeader2;

	@BeforeMethod(description = "Setting up Base URI, Payload and Header")

	public void setup() {
		loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
		jsonData = TestUtility.convertToJson(loginRequestPOJO);
		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type", "application/json");
		myHeader2 = new Header("ABC", "XYZ");
	}

	@Test(description = "Verify if the User is able to Login into the Application via api ", groups = { "api", "sanity",
			"smoke", "e2e" })
	public void loginAPITest() {

		String data = given().header(myHeader).and().header(myHeader2).and().body(jsonData).log().all().when()
				.post("/v1/login").then().log().all().assertThat().statusCode(200).and()
				.body("message", equalTo("Success")).and().time(lessThan(500L)).extract().path("data.token");

		System.out.println(data);

	}

}
