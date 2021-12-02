package com.oracle.s20210904.wk.model;

import java.sql.Date;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WkApply {
	private String user_id;
	private int res_code;
	private String anno_code;
	private String app_sts;
	private Date app_regdate;
	private String com_ntc_code;
	private String user_ntc_code;
	
//	comm table
	@Transient
	private String comm_ctx;
	private String com_app_sts;
	
//	resume table
	@Transient
	private String res_title;
	
//	company table
	@Transient
	private String com_name;
}
