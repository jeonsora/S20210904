package com.oracle.s20210904.wk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.wk.model.Applycount;

@Repository
public class WkApplyDaoImpl implements WkApplyDao{

	private final SqlSession session;
	@Autowired
	public WkApplyDaoImpl(SqlSession session) {
		super();
		this.session = session;
	}

	@Override
	public List<Applycount> countApply(String mbid) {
		System.out.println("WkApplyDaoImpl countApply()");
		List<Applycount> applycount=null;
		try {
			applycount=session.selectList("WkApplycount", mbid);
			System.out.println("WkApplyDaoImpl countApply() listapply : "+applycount.size());
		} catch (Exception e) {
			System.out.println("WkApplyDaoImpl countApply() error : "+e.getMessage());
		}
		return applycount;
	}
	
	
}
