package com.oracle.s20210904.wk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkResume;

@Repository
public class WkResumeDaoImpl implements WkResumeDao{
	private final SqlSession session;
	@Autowired
	public WkResumeDaoImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	
	@Override
	public List<WkResume> resumeList(String mbid) {
		System.out.println("WkResumeDaoImpl resumeList()");
		List<WkResume> list=null;
		try {
			list=session.selectList("WkResumeSum", mbid);
		} catch (Exception e) {
			System.out.println("WkResumeDaoImpl resumeList() error : "+e.getMessage());
		}
		return list;
	}


	@Override
	public int resumeWrite(WkResume wkResume) {
		System.out.println("WkResumeDaoImpl resumeWrite()");
		int result=0;
		int max_res_code=0;
		try {
			max_res_code=session.selectOne("WkResumeMaxRescode", wkResume.getUser_id());
			wkResume.setRes_code(max_res_code+1);
			
			result=session.insert("WkResumeWrite", wkResume);
			result=max_res_code+1;
		} catch (Exception e) {
			System.out.println("WkResumeDaoImpl resumeWrite() error : "+e.getMessage());
			throw new RuntimeException();
		}
		return result;
	}


	@Override
	public int resumeDelete(Resume resume) {
		System.out.println("WkResumeDaoImpl resumeDelete()");
		int result=0;
		try {
			result=session.delete("WkResumeDelete", resume);
		} catch (Exception e) {
			System.out.println("WkResumeDaoImpl resumeDelete() error : "+e.getMessage());
			throw new RuntimeException();
		}
		return result;
	}


	@Override
	public Resume resumeselect(Resume resume) {
		System.out.println("WkResumeDaoImpl resumeselect()");
		Resume result=null;
		try {
			result=session.selectOne("resumeSelectOne", resume);
			System.out.println("WkResumeDaoImpl resumeselect() result res_code : "+result.getRes_code());
		} catch (Exception e) {
			System.out.println("WkResumeDaoImpl resumeselect() error : "+e.getMessage());
		}
		return result;
	}
	
	
	
}
