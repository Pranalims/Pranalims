package com.util;

import static io.restassured.RestAssured.given;

import com.api.pojo.CreateJobRequestPOJO;
import com.api.pojo.Customer;
import com.api.pojo.Customer_Address;
import com.api.pojo.Customer_Product;
import com.api.pojo.LoginRequestPOJO;
import com.api.pojo.Problem;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

import io.restassured.http.Header;

public abstract class TestUtility { //closed the door any one to create the object TU
	public static int jobId;

	public static String convertToJson(Object refVariable) {
		Gson gson = new Gson();
		String data = gson.toJson(refVariable);
		return data;
	}

	public static CreateJobRequestPOJO createJobRequestPOJO() {
		Faker faker = new Faker();
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String emailAddress = faker.internet().emailAddress();

		String aptNumber = faker.address().buildingNumber();
		String aptName = faker.address().streetName();
		String streetName = faker.address().streetName();

		String IMEINumber = faker.numerify("8##############"); // 823435434234535
		Customer customer = new Customer(fName, lName, phoneNumber, null, emailAddress, null);
		Customer_Address address = new Customer_Address(aptNumber, aptName, streetName, "in orbit mall", "Link Road",
				"411045", "India", "Maharashtra");
		Customer_Product product = new Customer_Product("2023-06-10T18:30:00.000Z", IMEINumber, IMEINumber, IMEINumber,
				"2023-06-10T18:30:00.000Z", 1, 1);
		Problem[] deviceProblem = new Problem[1];
		deviceProblem[0] = new Problem(1, "Phone not working");

		CreateJobRequestPOJO createJobRequestPOJO = new CreateJobRequestPOJO(0, 2, 1, 1, customer, address, product,
				deviceProblem);

		return createJobRequestPOJO;
	}

	public static String generateTokenFor(String role) {

		LoginRequestPOJO loginRequestPOJO = null;
		if (role.equalsIgnoreCase("fd")) {
			loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
		} else if (role.equalsIgnoreCase("sup ")) {
			loginRequestPOJO = new LoginRequestPOJO("iamsup", "password");
		}

		else if (role.equalsIgnoreCase("eng")) {
			loginRequestPOJO = new LoginRequestPOJO("iameng", "password");
		}

		else if (role.equalsIgnoreCase("qc")) {
			loginRequestPOJO = new LoginRequestPOJO("iamqc", "password");
		}

		else if (role.equalsIgnoreCase("fst")) {
			loginRequestPOJO = new LoginRequestPOJO("iamfst3", "password");
		}

		else if (role.equalsIgnoreCase("cc")) {
			loginRequestPOJO = new LoginRequestPOJO("iamcc", "password");
		} else {
			System.err.print("Invalid role...Please enter role as fd,sup,qc,cc,fst,eng");
		}

		Header myHeader = new Header("Content-Type", "application/json");
		String jsonData = TestUtility.convertToJson(loginRequestPOJO);
		String data = given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log()
				.all().extract().path("data.token");

		return data;
	}

	public static String generateTokenFor(Role role) {

		LoginRequestPOJO loginRequestPOJO = null;
		if (role == Role.FD) { // comapre enum
			loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
		} else if (role == Role.SUP) {
			loginRequestPOJO = new LoginRequestPOJO("iamsup", "password");
		}

		else if (role == Role.ENG) {
			loginRequestPOJO = new LoginRequestPOJO("iameng", "password");
		}

		else if (role == Role.QC) {
			loginRequestPOJO = new LoginRequestPOJO("iamqc", "password");
		}

		else if (role == Role.FST) {
			loginRequestPOJO = new LoginRequestPOJO("iamfst3", "password");
		}

		else if (role == Role.CC) {
			loginRequestPOJO = new LoginRequestPOJO("iamcc", "password");
		}
		Header myHeader = new Header("Content-Type", "application/json");
		String jsonData = TestUtility.convertToJson(loginRequestPOJO);
		String data = given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log()
				.all().extract().path("data.token");

		return data;
	}
}
