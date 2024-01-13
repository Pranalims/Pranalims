package com.util;

import static io.restassured.RestAssured.given;

import com.google.gson.Gson;
import com.pojo.LoginRequestPOJO;

import io.restassured.http.Header;

public class TestUtility {

	public static String convertToJson(Object refVariable) {
		Gson gson = new Gson();
		String data = gson.toJson(refVariable);

		return data;
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
