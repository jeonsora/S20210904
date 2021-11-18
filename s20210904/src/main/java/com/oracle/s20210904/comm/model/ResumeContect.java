package com.oracle.s20210904.comm.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resume_contect")
public class ResumeContect {
	private String com_id;
	private String user_id;
	private String res_code;
	private Date res_date;
	private String ntc_code;
}
