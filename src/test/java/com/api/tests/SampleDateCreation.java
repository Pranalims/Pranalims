package com.api.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleDateCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//2023-06-10T18:30:00.000Z
		
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("2023-06-10T18:30:00.000Z");
		System.out.println(dateFormat.format(date)+"T"+timeFormat.format(date)+".000Z");
	}

}
