package com.api.pojo;

import java.util.Arrays;

public final class CreateJobRequestPOJO {
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;
	private Customer customer;
	private Customer_Address customer_address;
	private Customer_Product customer_product;
	private Problem[] problems;

	

	public CreateJobRequestPOJO(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id,
			int mst_oem_id, Customer customer, Customer_Address customer_address, Customer_Product customer_product,
			Problem[] problems) {
		super();
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customer_address = customer_address;
		this.customer_product = customer_product;
		this.problems = problems;
	}



	@Override
	public String toString() {
		return "CreateJobRequestPOJO [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer_address=" + customer_address + ", customer_product=" + customer_product + ", customer="
				+ customer + ", problems=" + Arrays.toString(problems) + "]";
	}

}
