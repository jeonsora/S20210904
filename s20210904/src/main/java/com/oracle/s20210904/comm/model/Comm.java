package com.oracle.s20210904.comm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Comm")
@IdClass(Comm.class)
public class Comm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String main_cat;
	@Id
	private String sub_cat;
	private String comm_ctx;
}
