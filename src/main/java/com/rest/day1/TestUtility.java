package com.rest.day1;

import com.google.gson.Gson;

public class TestUtility {

	public static String convertToJson(Object refVariable) {
		Gson gson = new Gson();
		String data = gson.toJson(refVariable);

		return data;
	}
}
