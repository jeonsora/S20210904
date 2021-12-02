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
public class Comm{
	@Id
	private String main_cat;
//	@Id 
	private String sub_cat;
	private String comm_ctx;
}
