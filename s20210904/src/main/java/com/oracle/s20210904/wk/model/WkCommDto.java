package com.oracle.s20210904.wk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "WkCommDto")
public class WkCommDto {
	@Id 
	private String sub_cat;
	private String comm_ctx;
	
	
}
