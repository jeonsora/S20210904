package com.oracle.sBootMybatis03.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
	private int odeptno;
	private String odname;
	private String oloc;
}
