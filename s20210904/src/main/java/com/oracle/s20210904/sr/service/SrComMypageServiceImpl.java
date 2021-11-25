package com.oracle.s20210904.sr.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.s20210904.sr.dao.SrComMypageDao;

public class SrComMypageServiceImpl implements SrComMypageService {

	@Autowired
	private SrComMypageDao scmd;
	
	@Override
	public int total() {
		System.out.println("SrComMypageServiceImpl Start total...");
		int totCnt=scmd.total();
		System.out.println("SrComMypageServiceImpl Start totCnt=>"+totCnt);
		return totCnt;
	}

}
