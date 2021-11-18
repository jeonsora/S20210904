package com.oracle.s20210904.comm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resume_detail")
public class ResumeDetail {
	private String user_id;
	private String res_code;
	private String car_code;
	private String com_name;
	private String emp_date;
	private String emp_dept;
	private String task;
}
