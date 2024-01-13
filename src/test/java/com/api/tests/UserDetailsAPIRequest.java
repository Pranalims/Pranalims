package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserDetailsAPIRequest {

	@Test
	public void userDetailAPITest() {
		// TODO Auto-generated method stub
		baseURI = "http://139.59.91.96:9000";

		Header myAuthorizationHeader = new Header("Authorization", TestUtility.generateTokenFor(Role.FST));
		Response response = given().header(myAuthorizationHeader).when().get("/v1/userdetails");

		System.out.println(response.asPrettyString());
	}

}
