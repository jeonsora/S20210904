package com.oracle.s20210904.wk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkResumeDetail;

@Repository
public class WkResumeDetailDaoImpl implements WkResumeDetailDao{
	private final SqlSession session;
	@Autowired
	public WkResumeDetailDaoImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	
	@Override
	public int resumeDetailWrite(WkResumeDetail wkResumeDetail) {
		System.out.println("WkResumeDetailDaoImpl resumeDetailWrite()");
		int result=0;
		try {
			result=session.insert("WkResumeDetailWrite", wkResumeDetail);
			System.out.println("WkResumeDetailDaoImpl resumeDetailWrite() result : "+result);
		} catch (Exception e) {
			System.out.println("WkResumeDetailDaoImpl resumeDetailWrite() error : "+e.getMessage());
			throw new RuntimeException();
			
		}
		return result;
	}


	@Override
	public int resumeDetailDelete(Resume resume) {
		System.out.println("WkResumeDetailDaoImpl resumeDetailDelete()");
		int result=0;
		try {
			result=session.delete("WkResumeDetailDelete", resume);
		} catch (Exception e) {
			System.out.println("WkResumeDetailDaoImpl resumeDetailWrite() error : "+e.getMessage());
			throw new RuntimeException();
		}
		return result;
	}
	
	
}
