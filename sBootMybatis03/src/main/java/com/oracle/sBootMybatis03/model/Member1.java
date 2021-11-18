package com.oracle.sBootMybatis03.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member1 {
	private String id;
	private String password;
	private String name;
	private Date reg_date;
}
