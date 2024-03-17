package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {
	public static String componentType, testType;

	// Feature: Automatic Generation of my XML files!!
	public static void main(String[] args) {
		// api smoke ---- Java?? Feature in ATF

		// Code for the Automatic XML file creation
		componentType = args[0];
		testType = args[1];

		runTestNG(componentType, testType);
	}

	private static void runTestNG(String componentType, String testType) {
		System.out.println("****************** ComponentType is =" + componentType);
		System.out.println("****************** TestType is =" + testType);

		TestNG testNG = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("My Test Suite"); // <suite name="My Test Suite">
		suite.setVerbose(1);
		XmlTest test = new XmlTest(suite);
		test.setName("API Tests");

		XmlPackage xmlPackage = new XmlPackage();
		xmlPackage.setName("com." + componentType + ".tests");

		test.addIncludedGroup(testType);
		// Collection

		List<XmlPackage> xmlList = new ArrayList<>();
		xmlList.add(xmlPackage);

		test.setPackages(xmlList); // LIst of packages!!

		List<XmlTest> xmlTestList = new ArrayList<>();
		xmlTestList.add(test);

		suite.setTests(xmlTestList);

		List<XmlSuite> suiteList = new ArrayList<>();
		suiteList.add(suite);

		testNG.setXmlSuites(suiteList);
		System.out.println("****************** Executing Dynamic TestNG Xml file for " + componentType
				+ " and Test Type" + testType);

		testNG.run();

	}

}

