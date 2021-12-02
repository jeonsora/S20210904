package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apply {
	private String user_id;
	private int res_code;
	private String conno_code;
	private String app_sts;
	private Date app_regdate;
	private String com_ntc_code;
	private String user_ntc_code;
}
