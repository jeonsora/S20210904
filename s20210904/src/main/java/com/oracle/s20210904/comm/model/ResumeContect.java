package com.oracle.s20210904.comm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ResumeContect")
@Table(name = "resume_contect")
@IdClass(ResumeContect.class)
public class ResumeContect implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String com_id;
	@Id
	private String user_id;
	@Id
	private int res_code;
	private Date res_date;
	private String ntc_code;
}
