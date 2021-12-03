package com.oracle.s20210904.wk.model;

import java.util.List;

import javax.persistence.Transient;

import com.oracle.s20210904.comm.model.ResumeDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WkResumeDetail {
	private String user_id;
	private int res_code;
	private int car_code;
	private String com_name;
	private String emp_date;
	private String emp_dept;
	private String task;
	

	@Transient
	private int[] car_code_ar;
	@Transient
	private String[] com_name_ar;
	@Transient
	private String[] emp_date_ar;
	@Transient
	private String[] emp_dept_ar;
	@Transient
	private String[] task_ar;
	@Transient
	private List<ResumeDetail> ResumeDetailList;
	

	
}
