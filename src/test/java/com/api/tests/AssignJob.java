package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.pojo.LoginRequestPOJO;
import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;

public class AssignJob {
	@Test
	public void assignJob() {

		
		String jsonData = "{\r\n"
				+ "    \"job_id\": "+TestUtility.jobId+",\r\n"
				+ "    \"engineer_id\": 2\r\n"
				+ "}";
		baseURI = "http://139.59.91.96:9000";
		Header myHeader = new Header("Content-Type", "application/json");
		Header myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.SUP));

					given()
										.header(myHeader)
									.and()
									.header(myHeader2)
									.and()
										.body(jsonData)
									.log().all()
									.when()
										.post("v1/engineer/assign")
									.then()
									.log().all()
									.assertThat()
										.statusCode(200)
									.and()
										.body("message",equalTo("Engineer assigned successfully"));
									
		
				
	
		
	}
}
