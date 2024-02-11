package com.api.pojo;

import java.util.Objects;

//POJO Design Pattern --- transfer object DP
//GSON or Jackson!!
public final class Person {
	private String name;
	private String contactNumber;
	private int age;
	private String address;

	public Person(String name, String contactNumber, int age, String address) {
		// intialization of instance!! ---> during object creation
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		if (contactNumber.length() == 10) {
			this.contactNumber = contactNumber;
		} else {
			System.err.print("Invalid value");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 18) {
			System.err.print("Invalid Age");
		} else {
			this.age = age;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, contactNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && age == other.age
				&& Objects.equals(contactNumber, other.contactNumber) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", contactNumber=" + contactNumber + ", age=" + age + ", address=" + address
				+ "]";
	}
//	

}
