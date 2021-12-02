package com.oracle.s20210904.ds.model;

import lombok.Getter;
import lombok.Setter;

//tag목록 대분류명 같이 가져오기 
@Getter
@Setter
public class DsComm {
	private String main_cat;
	private String sub_cat;
	private String comm_ctx;
	private String comm_ctx2;
	private int start;
	private int end;
}
