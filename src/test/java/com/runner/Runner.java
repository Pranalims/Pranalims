package com.runner;

import com.google.gson.Gson;
import com.pojo.CreateJobRequestPOJO;
import com.pojo.Customer;
import com.pojo.LoginRequestPOJO;
import com.pojo.Person;
import com.pojo.Problem;
import com.util.TestUtility;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamsup", "password");
		System.out.println(TestUtility.convertToJson(loginRequestPOJO));
		Customer customer = new Customer("Radhika", "D", "2334343435", "", "test@gmail.com", "");
		
		Problem[] myproblem = new Problem[1];
		myproblem[0] = new Problem(1, "battery issue");
		CreateJobRequestPOJO createJobRequestPOJO = new CreateJobRequestPOJO(0, 2, 1, 1, customer,myproblem);
		System.out.println(TestUtility.convertToJson(createJobRequestPOJO));

	}

}
