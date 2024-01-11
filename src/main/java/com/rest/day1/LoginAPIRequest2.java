package com.rest.day1;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginAPIRequest2 {

	public static void main(String[] args) {

		baseURI = "http://139.59.91.96:9000";
		Header myHeader = new Header("Content-Type", "application/json");
		String requestBody = "{\r\n" + "    \"username\": \"iamfd\",\r\n" + "    \"password\": \"password\"\r\n" + "}";
	
		Response response = 
						given()
						.when()
							.header(myHeader)
						.and()
							.body(requestBody)
						.when()
							.post("/v1/login");
		
		System.out.println(response.asPrettyString());
		System.out.println("Status Code" + response.statusCode());
		System.out.println("Time in MilliSec " + response.time());
		
	}

}
