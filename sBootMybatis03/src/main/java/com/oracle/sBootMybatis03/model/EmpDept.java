package com.oracle.sBootMybatis03.model;

import lombok.Getter;
import lombok.Setter;

// join목적
@Getter
@Setter
public class EmpDept {
	//emp용
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	//dept용
	private String dname;
	private String loc;
	

}
