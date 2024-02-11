package com.api.pojo;

public final class Problem {
	private int id;
	private String remark;
	public Problem(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", remark=" + remark + "]";
	}
	
	
}
