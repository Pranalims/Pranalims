package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.AssignJobPOJO;
import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;

public class AssignJobAPITest {
	private String jsonData;
	private Header myHeader;
	private Header myHeader2;

	@BeforeMethod(description = "Setting up Base URI, Payload and Header")
	public void setup() {
		jsonData = TestUtility.convertToJson(new AssignJobPOJO(TestUtility.jobId, 2));
		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type", "application/json");
		myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.SUP));
	}

	@Test(description = "Verify if the Superivsor is able to assign the job to the engineer ", groups = { "api",
			"sanity", "e2e" })
	public void assignJob() {

		given().header(myHeader).and().header(myHeader2).and().body(jsonData).log().all().when()
				.post("v1/engineer/assign").then().log().all().assertThat().statusCode(200).and()
				.body("message", equalTo("Engineer assigned successfully"));

	}
}
