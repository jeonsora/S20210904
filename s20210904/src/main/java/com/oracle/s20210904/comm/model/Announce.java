package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Announce {
	private String anno_code;
	private String com_id;
	private String com_bus;
	private int    rec_vol;
	private String rec_dtl;
	private int    emp_type;
	private String career;
	private String rec_edu;
	private int pay_info;
	private String work_cdt;
	private String etc_cdt;
	private String job_tag;
	private String tech_tag1;
	private String tech_tag2;
	private Date   anno_regdate;
	private Date   anno_c_regdate;
	private String anno_title;
}
