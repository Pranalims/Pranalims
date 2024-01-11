package com.rest.day1;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://139.59.91.96:9000";

		Header myHeader = new Header("Content-Type", "application/json");

		String requestBody = "{\r\n" + "    \"username\": \"iamfd\",\r\n" + "    \"password\": \"password\"\r\n" + "}";
		// inorder to make the api request in java

		RequestSpecification request = RestAssured.given();
		// request specfication ---> to make the api request for you ? Interface

		// Loosely coupled!!!!! Interfaces
		// 101
		request.header(myHeader);
		request.body(requestBody);
		Response response = request.post("/v1/login");
		System.out.println(response.asPrettyString());
		System.out.println("Status Code" + response.statusCode());
		System.out.println("Time in MilliSec " + response.time());
	}

}
