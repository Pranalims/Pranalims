package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.pojo.LoginRequestPOJO;
import com.util.TestUtility;

import io.restassured.http.Header;

public class LoginAPIRequest4 {

	@Test
	public void loginAPITest() {

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
