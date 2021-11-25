package com.oracle.s20210904.gm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.gm.dao.GmAnnoDao;


@Service
public class GmAnnoServiceImpl implements GmAnnoService {
	
	@Autowired
	private GmAnnoDao ad;

	@Override
	public int total() {
		System.out.println("GmAnnoServiceImpl total Start...");
		int totcnt = ad.total();
		System.out.println("GmAnnoServiceImpl total totcnt->"+totcnt);
		
		return totcnt;
	}

	@Override
	public List<ComAnnounce> listAnno(ComAnnounce comAnnounce) {
		
		List<ComAnnounce> annoList = null;
		System.out.println("GmAnnoServiceImpl listAnno Start...");
		annoList = ad.listAnno(comAnnounce);
		System.out.println("GmAnnoServiceImpl annoList.size"+annoList.size());
		
		return annoList;
	}

	@Override
	public ComAnnounce detail(String anno_code) {
		System.out.println("GmAnnoServiceImpl detail Start...");
		ComAnnounce comanno = null;
		comanno = ad.detail(anno_code);
		System.out.println("GmAnnoServiceImpl comanno.getCom_name()->"+comanno.getCom_name());
		
		return comanno;
	}
	/*
	@Override
	public List<Comm> recjob() {
		System.out.println("GmAnnoServiceImpl recjob Start...");
		List<Comm> recjob = ad.recjob();
		System.out.println("GmAnnoServiceImpl recjob.size()->"+recjob.size());
		
		return recjob;
	}
	*/
	// 공통 테이블에서 모집 직종 가져오기
	
	@Override
	public Comm recjob(ComAnnounce com) {
		System.out.println("GmAnnoServiceImpl recjob Start...");
		Comm comm = ad.recjob(com);
		System.out.println("GmAnnoServiceImpl comm.getComm_ctx()"+comm.getComm_ctx());
		
		return comm;
	}
	
	// 고용형태
	@Override
	public Comm emptype() {
		System.out.println("GmAnnoServiceImpl emptype Start...");
		Comm comm = ad.emptype();
		System.out.println("GmAnnoServiceImpl comm.getComm_ctx()->"+comm.getComm_ctx());
		
		return comm;
	}
	 
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
