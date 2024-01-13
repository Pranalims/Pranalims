package com.rest.day1;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static com.rest.day1.Role.*;
public class UserDetailsAPIRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baseURI = "http://139.59.91.96:9000";
		
		Header myAuthorizationHeader = new Header("Authorization", TestUtility.generateTokenFor(FST));
		Response response=	given()
								.header(myAuthorizationHeader)
								.when()
								.get("/v1/userdetails");
		
		System.out.println(response.asPrettyString());
	}

}

