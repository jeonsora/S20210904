package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

// JOIN 
@Getter
@Setter
public class ComAnnounce {
	
	// company
	private String com_pw;
	private String com_name;
	private String com_tel;
	private String com_addr;
	private String com_email;
	private String com_sec;
	private String com_bus;
	private String com_regnum;
	private String com_mgr_tel;
	private String com_web;
	private String com_img;
	private String com_user;
	
	
	// announce
	private String anno_code;
	private String com_id;
	private String work_code;
	private String rec_job;
	private int    rec_vol;
	private String rec_dtl;
	private int    emp_type;
	private String career;
	private String rec_edu;
	private int    pay_info;
	private String work_cdt;
	private String etc_cdt;
	private String job_tag;
	private String tech_tag1;
	private String tech_tag2;
	private Date   anno_regdate;
	private Date   anno_c_regdate;
	private String anno_title; 
	
	
	
	
	
	// 조회용
	private String pageNum;
	private int start;
	private int end;
	

}
