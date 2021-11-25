package com.oracle.s20210904.wk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	
	
}
