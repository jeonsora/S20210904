package com.oracle.s20210904.comm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ResumeDetail")
@Table(name = "resume_detail")
@IdClass(ResumeDetail.class)
public class ResumeDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String user_id;
	@Id
	private int res_code;
	@Id
	private int car_code;
	private String com_name;
	private String emp_date;
	private String emp_dept;
	private String task;
}
