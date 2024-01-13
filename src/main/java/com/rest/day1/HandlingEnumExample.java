package com.rest.day1;

public class HandlingEnumExample {
	public static void main(String[] args) {

		System.out.println(Role.FST);

		// How to convert String to enum
		String data = "CC";
		Role e = Role.valueOf(data);
		
		System.out.println(e);
		
		
		
	}
}
