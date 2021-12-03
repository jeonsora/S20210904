package com.oracle.s20210904.wk.model;

import java.sql.Date;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WkScrap {
	private String anno_code;
	private String user_id;
	private Date scr_date;
	
	
	@Transient
	private String com_name;	//기업명
	@Transient
	private String com_id;		//기업 ID
	@Transient
	private int    rec_vol;		//모집 인원
	@Transient
	private int    emp_type;	//고용 형태
	@Transient
	private String career;		//경력코드
	@Transient
	private String comm_ctx;	//경력
	@Transient
	private String rec_edu;		//학력
	@Transient
	private int pay_info;		//급여정보
	@Transient
	private String work_cdt;	//근무 조건
	@Transient
	private Date   anno_regdate;	//공고 게시일
	@Transient
	private Date   anno_c_regdate;	//공고마감일
	@Transient
	private String anno_title;	//공고제목
}
