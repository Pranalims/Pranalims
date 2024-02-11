package com.api.pojo;

public final class Customer_Product {
	private String dop;
	private String serial_number;
	private String imei1;
	private String imei2;
	private String popurl;
	private int product_id;
	private int mst_model_id;

	public Customer_Product(String dop, String serial_number, String imei1, String imei2, String popurl, int product_id,
			int mst_model_id) {
		super();
		this.dop = dop;
		this.serial_number = serial_number;
		this.imei1 = imei1;
		this.imei2 = imei2;
		this.popurl = popurl;
		this.product_id = product_id;
		this.mst_model_id = mst_model_id;
	}

	@Override
	public String toString() {
		return "Customer_Product [dop=" + dop + ", serial_number=" + serial_number + ", imei1=" + imei1 + ", imei2="
				+ imei2 + ", popurl=" + popurl + ", product_id=" + product_id + ", mst_model_id=" + mst_model_id + "]";
	}

}
