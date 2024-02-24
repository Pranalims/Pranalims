package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;

public class CreateJobAPITest {
	private String payload;
	private Header myHeader;
	private	Header myHeader2;

	@BeforeMethod(description = "Setting up Base URI, Payload and Header")

	public void setup() {
		payload = TestUtility.convertToJson(TestUtility.createJobRequestPOJO());

		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type", "application/json");
		myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.FD));
	}

	@Test(description = "Verify if the FD is able to create the Inwarranty job via API ", groups = { "api", "sanity",
			"e2e" })
	public void createJobAPITest() {

		TestUtility.jobId = given().header(myHeader).and().header(myHeader2).and().body(payload).log().all().when()
				.post("/v1/job/create").then().log().all().assertThat().statusCode(200).and()
				.body("message", equalTo("Job created successfully. ")).and().time(lessThan(1500L)).extract()
				.path("data.id");

		System.out.println(TestUtility.jobId);

	}

}
