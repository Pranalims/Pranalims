package com.rest.day1;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginAPIRequest4 {

	public static void main(String[] args) {

		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd","password");
		String jsonData = TestUtility.convertToJson(loginRequestPOJO);
		
		baseURI = "http://139.59.91.96:9000";
		Header myHeader = new Header("Content-Type", "application/json");
		Header myHeader2 = new Header("ABC", "XYZ");

					String data=	given()
										.header(myHeader)
									.and()
									.header(myHeader2)
									.and()
										.body(jsonData)
									.log().all()
									.when()
										.post("/v1/login")
									.then()
									.log().all()
									.assertThat()
										.statusCode(200)
									.and()
										.body("message",equalTo("Success"))
									.and()
										.time(lessThan(500L))
										.extract().path("data.token");
		
					System.out.println(data);
	
		
	}

}
