package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
	private int post_code;
	private String brd_code;
	private String user_id;
	private String post_title;
	private String post_ctx;
	private Date post_regdate;
	private int post_view;
	private String post_file;
	private String post_img;
	private int ref;
	private int ref_lev;
	private int ref_step;
}
