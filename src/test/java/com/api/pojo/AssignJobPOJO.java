package com.api.pojo;

public final class AssignJobPOJO {
	private int job_id;
	private int engineer_id;

	public AssignJobPOJO(int job_id, int engineer_id) {
		super();
		this.job_id = job_id;
		this.engineer_id = engineer_id;
	}

	@Override
	public String toString() {
		return "AssignJobPOJO [job_id=" + job_id + ", engineer_id=" + engineer_id + "]";
	}

}
