package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserDetailsAPITest {

	private Header myAuthorizationHeader;
	private Response response;

	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		myAuthorizationHeader = new Header("Authorization", TestUtility.generateTokenFor(Role.FST));
	}

	@Test(description = "Verify if the User Details API returns correct data ", groups = { "api", "sanity", "smoke",
			"e2e" })
	public void userDetailAPITest() {
		response = given().header(myAuthorizationHeader).when().get("/v1/userdetails");
	}

}
