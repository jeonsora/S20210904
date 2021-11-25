package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resume {
	private String user_id;
	private int res_code;
	private String res_sts;
	private String rep_res;
	private String res_email;
	private String res_img;
	private String hs_name;
	private String hs_mjr;
	private String univ_name;
	private String univ_date;
	private String univ_mjr;
	private String cov_let;
	private Date res_date;
	private String res_tag1;
	private String res_tag2;
	private String res_tag3;
	private String res_etc_link;
	private String res_etc_file;
}
