package com.oracle.s20210904.gm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;

@Repository
public class GmAnnoDaoImpl implements GmAnnoDao {
	
	@Autowired
	private SqlSession session;

	public int total() {
		int tot = 0;
		System.out.println("GmAnnoDaoImpl total Start...");
		try {
			tot = session.selectOne("GmAnnoTotal");
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl total Exception"+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<ComAnnounce> listAnno(ComAnnounce comAnnounce) {
		List<ComAnnounce> annoList = null;
		System.out.println("GmAnnoDaoImpl listAnno Start...");
		try {
			annoList = session.selectList("GmAnnoListAll", comAnnounce);
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl listAnno Exception"+e.getMessage());
		}
		
		return annoList;
	}

	@Override
	public ComAnnounce detail(String anno_code) {
		ComAnnounce comanno = new ComAnnounce();
		System.out.println("GmAnnoDaoImpl detail Start...");
		try {
			comanno = session.selectOne("GmAnnoSelOne", anno_code);
			System.out.println("GmAnnoDaoImpl comanno.getCom_name()->"+comanno.getCom_name());
			System.out.println("GmAnnoDaoImpl comanno.getAnno_code()->"+comanno.getAnno_code());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl detail Exception"+e.getMessage());
		}
		
		return comanno;
	}
	/*
	@Override
	public List<Comm> recjob() {
		List<Comm> recjob = null;
		System.out.println("GmAnnoDaoImpl recjob Start...");
		try {
			recjob = session.selectList("GmCommRecjob");
			System.out.println("GmAnnoDaoImpl recjob.size()->"+recjob.size());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl recjob Exception"+e.getMessage());
		}
		return recjob;
	}
	*/
	// 모집 직종
	@Override
	public Comm recjob(ComAnnounce com) {
		Comm comm = null;
		System.out.println("GmAnnoDaoImpl recjob Start...");
		try {
			comm = session.selectOne("GmCommRecjob",com);
			System.out.println("comm에는 무엇이 있나?->"+comm.getComm_ctx());
			System.out.println("GmAnnoDaoImpl comm.getComm_ctx()->"+comm.getComm_ctx());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl recjob Exception"+e.getMessage());
		}
		
		return comm;
	}

	// 고용 형태
	@Override
	public Comm emptype() {
		Comm comm = null;
		System.out.println("GmAnnoDaoImpl emptype Start...");
		try {
			comm = session.selectOne("GmCommEmptype");
			System.out.println("GmAnnoDaoImpl comm.getComm_ctx()->"+comm.getComm_ctx());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl emptype Exception"+e.getMessage());
		}
		return comm;
	}
	
	


	

}
