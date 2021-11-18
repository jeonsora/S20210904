package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scrap {
	private String anno_code;
	private String user_id;
	private Date scr_date;
}
