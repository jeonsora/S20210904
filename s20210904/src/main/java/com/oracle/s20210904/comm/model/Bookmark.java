package com.oracle.s20210904.comm.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookmark {
	private String com_id;
	private String user_id;
	private Date mrk_date;
}
